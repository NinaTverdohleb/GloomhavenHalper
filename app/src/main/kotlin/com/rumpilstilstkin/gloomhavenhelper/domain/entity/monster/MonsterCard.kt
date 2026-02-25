package com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster

data class MonsterCard(
    val deckName: String,
    val cardId: Int,
    val initiative: Int,
    val actions: List<MonsterAction>,
    val needsShuffle: Boolean = false,
)
