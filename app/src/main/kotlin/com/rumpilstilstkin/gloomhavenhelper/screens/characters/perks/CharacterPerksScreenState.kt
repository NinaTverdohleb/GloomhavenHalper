package com.rumpilstilstkin.gloomhavenhelper.screens.characters.perks

import com.rumpilstilstkin.gloomhavenhelper.screens.models.PerkUI

data class CharacterPerksScreenState (
    val characterPerks: List<PerkUI> = emptyList(),
    val avaliablePerks: List<PerkUI> = emptyList(),
)