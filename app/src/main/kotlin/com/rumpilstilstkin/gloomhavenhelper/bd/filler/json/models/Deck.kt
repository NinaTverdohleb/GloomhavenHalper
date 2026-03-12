package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.models

import kotlinx.serialization.Serializable

@Serializable
data class DeckJson(
    val name: String,
    val cards: List<CardJson>
)

@Serializable
data class CardJson(
    val image: String,
    val needsShuffle: Boolean,
    val initiative: Int
)