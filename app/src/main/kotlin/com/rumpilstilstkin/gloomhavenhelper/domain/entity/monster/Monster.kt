package com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster

import kotlinx.serialization.Serializable

@Serializable
data class Monster(
    val id: Int,
    val name: String,
    val life: Int,
    val stats: List<MonsterAction>,
    val eliteLife: Int,
    val eliteStats: List<MonsterAction>,
    val deckName: String,
    val cards: List<MonsterCard>,
    val isBoss: Boolean,
    val immunity: List<MonsterStatType>,
    val isFly: Boolean,
    val level: Int,
    val lifeMultiple: Boolean,
)


data class MonsterStats(
    val monsterId: Int,
    val level: Int,
    val isElite: Boolean,
    val life: Int,
    val stats: List<MonsterAction>,
)