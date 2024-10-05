package com.rumpilstilstkin.gloomhavenhelper.screens.models

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Perk

data class PerkUI(
    val id: Int,
    val text: String,
    val characterPerId: Int? = null
)


fun Perk.toUi() = PerkUI(
    id = this.id,
    text = this.text,
    characterPerId = this.characterPerkId
)
