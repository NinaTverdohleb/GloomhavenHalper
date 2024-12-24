package com.rumpilstilstkin.gloomhavenhelper.screens.start.team

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team.GetCurrentTeamUseCase
import com.rumpilstilstkin.gloomhavenhelper.navigation.GlHelperScreens
import com.rumpilstilstkin.gloomhavenhelper.navigation.events.GlHelperEvent
import com.rumpilstilstkin.gloomhavenhelper.screens.models.TeamUI
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamTabViewModel @Inject constructor(
    getCurrentTeamUseCase: GetCurrentTeamUseCase,
) : ViewModel() {

    private val _navigationEvents = MutableSharedFlow<GlHelperEvent>()
    val navigationEvents = _navigationEvents.asSharedFlow()

    val uiState: StateFlow<TeamTabUiState> = getCurrentTeamUseCase.invoke().map { team ->
        TeamTabUiState.Data(
            currentTeam = TeamUI(
                teamId = team.id,
                teamName = team.name,
                teamLevel = team.level,
                teamScenario = team.scenario.map { it.toUi() },
                teamReputation = team.reputation,
                prosperity = team.prosperity,
                teamAchievements = team.teamAchievement,
                globalAchievements = team.globalAchievement,
                characters = team.characters.map { it.toUi() },
                canAddCharacter = team.characters.size < 4
            ),
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = TeamTabUiState.Empty,
        started = SharingStarted.WhileSubscribed(10),
    )

    fun onAction(action: TeamTabAction) {
        viewModelScope.launch {
            when (action) {
                TeamTabAction.AddTeam -> {
                    _navigationEvents.emit(GlHelperEvent.Screen(GlHelperScreens.TeamCreate))
                }
                is TeamTabAction.CharacterDetails -> {
                    _navigationEvents.emit(GlHelperEvent.Screen(GlHelperScreens.CharacterDetails(characterId = action.characterId)))
                }

            }
        }
    }
}

sealed interface TeamTabAction {
    data object AddTeam : TeamTabAction
    data class CharacterDetails(val characterId: Int) : TeamTabAction
}