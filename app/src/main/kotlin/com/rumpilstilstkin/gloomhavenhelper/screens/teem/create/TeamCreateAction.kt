package com.rumpilstilstkin.gloomhavenhelper.screens.teem.create

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

sealed interface TeamCreateAction {
    data class EditName(val name: String) : TeamCreateAction
    data object ShowCharacterDialog : TeamCreateAction
    data object HideCharacterDialog : TeamCreateAction
    data class AddCharacter(val name: String, val level: Int, val characterType: CharacterClassType) : TeamCreateAction
    data object Save : TeamCreateAction
    data class DeleteCharacter(val id: Int) : TeamCreateAction
    data class LeaveCharacter(val id: Int) : TeamCreateAction
    data class UpdateCharacter(val id: Int, val level: Int) : TeamCreateAction
}