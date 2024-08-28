package com.rumpilstilstkin.gloomhavenhelper.screens.teem.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.data.ClassRepository
import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamCreateViewModel@Inject constructor(
    private val teamRepository: TeamRepository,
    private val classRepository: ClassRepository,
) : ViewModel() {
    private val team = MutableStateFlow(TeamCreateUiState.Empty)

    val uiState: StateFlow<TeamCreateUiState> = team.asStateFlow()

    init {
        viewModelScope.launch {
            val classes = classRepository.getAllClasses().map { classModel ->
                CharacterClassUI(
                    id = classModel.id,
                    name = classModel.name,
                    imageRes = classModel.image
                )
            }
            team.emit(TeamCreateUiState.Empty.copy(classes = classes))
        }
    }

    fun action(action: TeamCreateAction) {
        val currentValue = team.value
        viewModelScope.launch {
            when (action) {
                is TeamCreateAction.EditName -> {
                    team.emit(currentValue.copy(name = action.name))
                }

                is TeamCreateAction.AddCharacter -> {
                    classRepository.getClassById(action.classId).let { classModel ->
                        val newValue = currentValue.copy(
                            characters = currentValue.characters + CharacterUI(
                                name = action.name,
                                level = action.level,
                                characterClass = CharacterClassUI(
                                    id = classModel.id,
                                    name = classModel.name,
                                    imageRes = classModel.image
                                )
                            ),
                            showCharacterDialog = false
                        )
                        team.emit(newValue)
                    }
                }

                is TeamCreateAction.Save -> {
                    teamRepository.saveTeam(currentValue.toTeamForSave())
                    team.emit(currentValue.copy(done = true))
                }

                is TeamCreateAction.ShowCharacterDialog -> {
                    team.emit(currentValue.copy(showCharacterDialog = true))
                }

                TeamCreateAction.HideCharacterDialog -> {
                    team.emit(currentValue.copy(showCharacterDialog = false))
                }
            }
        }
    }
}