package com.rumpilstilstkin.gloomhavenhelper.screens.dialogs.teams

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ShortTeamInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team.GetTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class TeamListDialogViewModel @Inject constructor(
    getTeamsUseCase: GetTeamsUseCase,
) : ViewModel() {

    val uiState: StateFlow<TeamListDialogUiState> = getTeamsUseCase().map { teams ->
        TeamListDialogUiState(
            teams = teams
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = TeamListDialogUiState(),
        started = SharingStarted.WhileSubscribed(10),
    )
}

data class TeamListDialogUiState(
    val teams: List<ShortTeamInfo> = emptyList()
)