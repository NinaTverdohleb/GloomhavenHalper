package com.rumpilstilstkin.gloomhavenhelper.screens.characters.general

import androidx.compose.runtime.Immutable
import com.rumpilstilstkin.gloomhavenhelper.screens.models.PersonalQuestUI
import kotlinx.collections.immutable.ImmutableList

@Immutable
data class CharacterGeneralTabState(
    val experience: Int,
    val gold: Int,
    val hasTeam: Boolean = false,
    val teamName: String? = null,
    val nextLevel: Int,
    val notes: String,
    val checkMarks: Int = 0,
    val isDonateAvailable: Boolean = false,
    val personalQuest: PersonalQuestUI? = null
) {
    companion object {
        val Empty = CharacterGeneralTabState(
            experience = 0,
            gold = 0,
            nextLevel = 0,
            notes = "",
            personalQuest = null
        )
    }
}
