package com.rumpilstilstkin.gloomhavenhelper.screens.teem.create

sealed interface TeamCreateAction {
    data class EditName(val name: String) : TeamCreateAction
    data object ShowCharacterDialog : TeamCreateAction
    data object HideCharacterDialog : TeamCreateAction
    data class AddCharacter(val name: String, val level: Int, val classId: Int) : TeamCreateAction
    data object Save : TeamCreateAction
}