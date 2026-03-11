package com.rumpilstilstkin.gloomhavenhelper.navigation

import kotlinx.serialization.Serializable

sealed interface GlHelperScreens {
    @Serializable
    data object Start : GlHelperScreens

    @Serializable
    data object EditCurrentTeam : GlHelperScreens

    @Serializable
    data class Scenario(val scenarioId: Int?, val restore: Boolean,) : GlHelperScreens

    @Serializable
    data class CharacterDetails(val characterId: Int) : GlHelperScreens

    @Serializable
    data class AddGoodsForCharacter(val characterId: Int) : GlHelperScreens

    @Serializable
    data class SearchPersonalQuest(val characterId: Int) : GlHelperScreens

    @Serializable
    data object AddGoodsForTeam : GlHelperScreens

    @Serializable
    data object AddScenarioForTeam : GlHelperScreens

    @Serializable
    data object TeamAchievements : GlHelperScreens
    @Serializable
    data object GlobalAchievements : GlHelperScreens
    @Serializable
    data class ScenarioConstructor(val scenarioId: Int?) : GlHelperScreens
}