package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.data.MonsterRepository
import com.rumpilstilstkin.gloomhavenhelper.data.ScenarioGameStateRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.LevelInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Magic
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioBattleInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioGameState
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioGameStateMonsterItem
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.Monster
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterCard
import javax.inject.Inject
import kotlin.Int

class RestoreScenarioStateUseCase @Inject constructor(
    private val scenarioGameStateRepository: ScenarioGameStateRepository,
    private val monsterRepository: MonsterRepository,
) {
    suspend operator fun invoke(
        team: TeamInfo,
        levelInfo: LevelInfo?
    ): ScenarioBattleInfo {
        val state = scenarioGameStateRepository.get()
        return state?.let { gameState ->
            val scenarioMonsters =
                monsterRepository.getMonstersByNames(gameState.monsterNames, team.level)
            val allCards = scenarioMonsters.flatMap { it.cards }
            val avaliableCards = gameState.availableCards.mapNotNull { cardId ->
                allCards.firstOrNull {
                    it.cardId == cardId
                }
            }
            ScenarioBattleInfo(
                name = state.name,
                golds = levelInfo?.goldCount ?: 0,
                exp = levelInfo?.experience ?: 0,
                trapDamage = levelInfo?.trapDamage ?: 0,
                gamersCount = team.characters.size,
                monsterLevel = levelInfo?.monsterLevel ?: 0,
                round = state.round,
                monsters = scenarioMonsters,
                availableCards = avaliableCards,
                activeMonsters = state.activeMonsters,
                magicCharges = state.magicCharges.associate {
                    it.name to it.value
                }
            )
        } ?: ScenarioBattleInfo(
            name = "Своя карта",
            monsters = emptyList(),
            golds = levelInfo?.goldCount ?: 0,
            exp = levelInfo?.experience ?: 0,
            trapDamage = levelInfo?.trapDamage ?: 0,
            gamersCount = team.characters.size,
            monsterLevel = levelInfo?.monsterLevel ?: 0
        )
    }
}