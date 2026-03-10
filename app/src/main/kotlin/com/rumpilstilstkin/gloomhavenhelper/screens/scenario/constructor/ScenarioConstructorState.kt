package com.rumpilstilstkin.gloomhavenhelper.screens.scenario.constructor

import androidx.compose.runtime.Immutable
import kotlinx.collections.immutable.ImmutableList

sealed interface ScenarioConstructorStateUi {
    data object Loading : ScenarioConstructorStateUi

    @Immutable
    data class Content(
        val availableMonsters: ImmutableList<String>,
        val selectedMonsters: ImmutableList<String>,
    ) : ScenarioConstructorStateUi
}

data class ScenarioConstructorStateLogic(
    val allMonsters: List<String> = emptyList(),
    val selectedMonsters: Set<String> = emptySet(),
)

sealed interface ScenarioConstructorAction {
    data object Back : ScenarioConstructorAction
    data class ToggleMonster(val monster: String) : ScenarioConstructorAction
    data class StartScenario(val scenarioId: Int?) : ScenarioConstructorAction
}
