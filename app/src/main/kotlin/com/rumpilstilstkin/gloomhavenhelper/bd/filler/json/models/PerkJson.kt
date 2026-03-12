package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.models

import kotlinx.serialization.Serializable

@Serializable
data class CharacterPerksJson(
    val characterType: String,
    val perks: List<PerkJson>
)

@Serializable
data class PerkJson(
    val text: String
)
