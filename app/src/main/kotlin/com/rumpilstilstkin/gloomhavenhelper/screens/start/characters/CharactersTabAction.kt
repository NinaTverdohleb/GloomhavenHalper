package com.rumpilstilstkin.gloomhavenhelper.screens.start.characters

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

sealed interface CharactersTabAction {
    data class AddCharacter(val name: String, val level: Int, val characterType: CharacterClassType) : CharactersTabAction
    data object SwitchAlive: CharactersTabAction
    data class ShowByTeam(val teamId: Int?): CharactersTabAction
}