package com.rumpilstilstkin.gloomhavenhelper.screens.scenario

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioBattleInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterCard
import com.rumpilstilstkin.gloomhavenhelper.screens.models.ActionUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.EffectItem
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterAbilityCard
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterItem
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterUnit

data class ScenarioLogicState(
    val scenarioInfo: ScenarioBattleInfo,
    val availableCards: List<MonsterCard>,
    val activeMonsters: List<MonsterItem> = emptyList(),
    val round: Int = 0,
    val showMonsterDialog: Boolean = false
) {
    fun toUIState(): ScenarioUIState {
        val existingIds = activeMonsters.map { it.id }.toSet()
        return ScenarioUIState(
            name = scenarioInfo.name,
            exp = scenarioInfo.exp,
            gold = scenarioInfo.golds,
            trapDamage = scenarioInfo.trapDamage,
            round = round,
            monsters = activeMonsters,
            showMonsterDialog = showMonsterDialog,
            monstersForAdd = scenarioInfo.monsters.filter { it.id !in existingIds }.map {
                MonsterItem(
                    id = it.id,
                    name = it.name,
                    currentCard = null,
                )
            }
        )
    }

    fun addMonster(monsterId: Int): ScenarioLogicState {
        val newMonster = scenarioInfo.monsters.first { it.id == monsterId }
        return this
            .copy(
                activeMonsters = activeMonsters +
                        MonsterItem(
                            id = newMonster.id,
                            name = newMonster.name,
                            currentCard = null,
                        ),
            )
            .updateMonsterCard(newMonster.id)
    }

    fun removeMonster(monsterId: Int): ScenarioLogicState =
        this.copy(
            activeMonsters = activeMonsters.filter { it.id != monsterId }
        )

    fun addUnits(numbers: List<Int>, monsterId: Int, isSpecial: Boolean): ScenarioLogicState {
        val monster = scenarioInfo.monsters.first { it.id == monsterId }
        val maxLife = if (isSpecial) monster.eliteLife else monster.life
        val stats = if (isSpecial) monster.eliteStats else monster.stats
        val newUnits = numbers.map {number ->
            MonsterUnit(
                number = number,
                maxLife = maxLife,
                currentLife = maxLife,
                stats = stats.map {
                    EffectItem.fromCardAction(it)
                },
                isSpecial = isSpecial,
            )
        }
        return this.copy(
            activeMonsters = activeMonsters.map {
                if (it.id == monsterId) {
                    it.copy(
                        units = it.units + newUnits
                    )
                } else {
                    it
                }
            }
        )
    }

    fun removeUnit(number: Int, monsterId: Int): ScenarioLogicState {
        return this.copy(
            activeMonsters = activeMonsters.map { monsterItem ->
                if (monsterItem.id == monsterId) {
                    monsterItem.copy(
                        units = monsterItem.units.filter { it.number != number }
                    )
                } else {
                    monsterItem
                }
            }
        )
    }

    fun nextRound(): ScenarioLogicState {
        var state = this
        this.activeMonsters.forEach {
            state = state.updateMonsterCard(it.id)
        }
        return state.copy(
            round = round + 1
        )

    }

    fun updateUnitLife(monsterId: Int, number: Int, newValue: Int): ScenarioLogicState {
        return this.copy(
            activeMonsters = activeMonsters.map { monsterItem ->
                if (monsterItem.id == monsterId) {
                    monsterItem.copy(
                        units = monsterItem.units.map {
                            if (it.number == number) {
                                it.copy(
                                    currentLife = newValue
                                )
                            } else {
                                it
                            }
                        }
                    )
                } else {
                    monsterItem
                }
            }
        )
    }

    fun addEffect(monsterId: Int, number: Int, effect: ActionUi): ScenarioLogicState {
        return this.copy(
            activeMonsters = activeMonsters.map { monsterItem ->
                if (monsterItem.id == monsterId) {
                    monsterItem.copy(
                        units = monsterItem.units.map {
                            if (it.number == number) {
                                val newEffects = if (it.effects.contains(effect)){
                                    it.effects - effect
                                }else {
                                    it.effects + effect
                                }
                                it.copy(
                                    effects = newEffects
                                )
                            } else {
                                it
                            }
                        }
                    )
                } else {
                    monsterItem
                }
            }
        )
    }

    private fun selectCard(monsterId: Int): MonsterCard {
        val monster = scenarioInfo.monsters.first { it.id == monsterId }
        return availableCards.filter { it.deckName == monster.deckName }.random()
    }

    private fun updateMonsterCard(monsterId: Int): ScenarioLogicState {
        val card = if (round != 0) {
            selectCard(monsterId)
        } else {
            null
        }
        val newAvaliableCards = if (card != null && !card.needsShuffle) {
            availableCards.filter { it.cardId != card.cardId }
        } else {
            availableCards
        }
        return this.copy(
            activeMonsters = activeMonsters.map {
                if (it.id == monsterId) {
                    it.copy(
                        currentCard = card?.let { MonsterAbilityCard.createFromMonsterCard(it) }
                    )
                } else {
                    it
                }
            },
            availableCards = newAvaliableCards
        )
    }
}

data class ScenarioUIState(
    val name: String = "",
    val exp: Int = 0,
    val gold: Int = 0,
    val trapDamage: Int = 0,
    val round: Int = 0,
    val showMonsterDialog: Boolean = false,
    val monsters: List<MonsterItem> = emptyList(),
    val monstersForAdd: List<MonsterItem> = emptyList(),
)

sealed interface ScenarioActions {
    data class AddUnits(val numbers: List<Int>, val monsterId: Int, val isElite: Boolean) :
        ScenarioActions

    data class RemoveUnit(val number: Int, val monsterId: Int) : ScenarioActions
    data object CompleteScenario : ScenarioActions
    data class AddMonster(val monsterId: Int) : ScenarioActions
    data class RemoveMonster(val monsterId: Int) : ScenarioActions
    data class UpdateUnitLife(val newValue: Int, val monsterId: Int, val unitNumber: Int) :
        ScenarioActions

    data object NextRound : ScenarioActions
    data class SwitchUnitEffect(val effect: ActionUi, val monsterId: Int, val unitNumber: Int) :
        ScenarioActions

    data object OpenMonstersDialog : ScenarioActions
    data object CloseMonstersDialog : ScenarioActions
}