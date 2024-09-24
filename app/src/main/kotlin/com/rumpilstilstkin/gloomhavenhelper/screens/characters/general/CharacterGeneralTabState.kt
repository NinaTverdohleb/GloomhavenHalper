package com.rumpilstilstkin.gloomhavenhelper.screens.characters.general


data class CharacterGeneralTabState(
    val experience: Int,
    val gold: Int,
    val hasTeam: Boolean = false,
    val teamName: String? = null,
    val nextLevel: Int,
    val notes: String,
    //val mainTask: TaskUI?,
    val checkMarks: Int = 0,
    val isDonateAvailable: Boolean = false
) {
    companion object {
        val Empty = CharacterGeneralTabState(
            experience = 0,
            gold = 0,
            nextLevel = 0,
            notes = "",
        )
    }
}
