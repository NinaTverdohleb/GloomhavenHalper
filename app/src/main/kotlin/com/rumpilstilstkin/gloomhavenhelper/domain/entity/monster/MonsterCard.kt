package com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster

import kotlinx.serialization.Serializable

@Serializable
data class MonsterCard(
    val deckName: String,
    val cardId: Int,
    val imageName: String,
    val needsShuffle: Boolean = false,
    val initiative: Int
)
