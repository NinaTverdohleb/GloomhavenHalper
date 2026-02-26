package com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster

data class MonsterCard(
    val deckName: String,
    val cardId: Int,
    val imageName: String,
    val needsShuffle: Boolean = false,
)
