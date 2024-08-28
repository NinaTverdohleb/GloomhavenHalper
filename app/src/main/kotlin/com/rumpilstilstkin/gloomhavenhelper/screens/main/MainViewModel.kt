package com.rumpilstilstkin.gloomhavenhelper.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    teamRepository: TeamRepository
) : ViewModel() {
    val uiState: StateFlow<MainScreenUiState> = teamRepository.currentTeam.map {
        it.fold(
            onSuccess = { team ->
                MainScreenUiState.Team(
                    teamName = team.name,
                    teamLevel = team.level
                )
            },
            onFailure = { MainScreenUiState.Empty }
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = MainScreenUiState.Empty,
        started = SharingStarted.WhileSubscribed(10),
    )

}

sealed interface MainScreenUiState {
    data object Empty : MainScreenUiState
    data class Team(val teamName: String, val teamLevel: Int) : MainScreenUiState
}