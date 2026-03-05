package com.rumpilstilstkin.gloomhavenhelper.screens.start.characters

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterUI

sealed interface CharactersTabState {
    val showAddCharacterDialog: Boolean

    data class Empty(
        override val showAddCharacterDialog: Boolean = false
    ) : CharactersTabState

    data class Data(
        override val showAddCharacterDialog: Boolean = false,
        val filterAlive: Boolean = true,
        val characters: List<CharacterUI>
    ) : CharactersTabState
}

sealed interface CharactersTabAction {
    data class AddCharacter(val name: String, val level: Int, val characterType: CharacterClassType) : CharactersTabAction
    data object SwitchAlive: CharactersTabAction
    data object ShowAddCharacterDialog: CharactersTabAction
    data object CloseAddCharacterDialog: CharactersTabAction
    data class CharacterDetails(val characterId: Int): CharactersTabAction
}