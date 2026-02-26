package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType
import kotlinx.serialization.Serializable

/**
 * JSON model for ability card deck.
 * Multiple monsters can share the same deck by referencing the same deckName.
 */
@Serializable
data class AbilityDeckJson(
    val deckName: String,
    val cards: List<AbilityCardJson>
)

@Serializable
data class AbilityCardJson(
    val initiative: Int,
    val actions: List<MonsterAction>,
    val needsShuffle: Boolean = false
)

/**
 * JSON model for monster definition.
 */
@Serializable
data class MonsterJson(
    val name: String,
    val deckName: String,
    val stats: List<MonsterStatsJson>,
    val isBoss: Boolean,
    val immunity: List<MonsterStatType>? = null
)

@Serializable
data class MonsterStatsJson(
    val level: Int,
    val isElite: Boolean,
    val life: Int,
    val stats: List<MonsterAction>,
)

/**
 * JSON model for scenario-monster mapping.
 */
@Serializable
data class ScenarioMonstersJson(
    val scenarioNumber: Int,
    val monsterNames: List<String>
)
