package com.rumpilstilstkin.gloomhavenhelper.domain.entity

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType
import com.rumpilstilstkin.gloomhavenhelper.screens.models.EffectItem
import kotlinx.serialization.Serializable

@Serializable
data class ScenarioGameState(
    val scenarioNumber: Int?,
    val name: String,
    val monsterNames: List<String>,
    val round: Int,
    val availableCards: List<Int>,
    val activeMonsters: List<ScenarioGameStateMonsterItem>,
    val magicCharges: List<ScenarioGameStateMagic>
)

@Serializable
data class ScenarioGameStateMagic(
    val name: String,
    val value: Int
)

@Serializable
data class ScenarioGameStateMonsterItem(
    val id: Int,
    val currentCard: Int? = null,
    val units: List<ScenarioGameStateMonsterUnit> = listOf(),
)

@Serializable
data class ScenarioGameStateMonsterUnit(
    val number: Int,
    val currentLife: Int,
    val level: Int,
    val isElite: Boolean,
    val effects: List<MonsterStatType>
)
