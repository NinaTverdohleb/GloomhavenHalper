package com.rumpilstilstkin.gloomhavenhelper.domain.entity

data class Perk(
    val id: Int,
    val text: String,
    val characterType: CharacterClassType,
    val characterPerkId: Int? = null
)
