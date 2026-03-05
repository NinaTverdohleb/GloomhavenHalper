package com.rumpilstilstkin.gloomhavenhelper.screens.start.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.data.CharacterRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterForSave
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterInfo
import com.rumpilstilstkin.gloomhavenhelper.navigation.events.GlHelperEvent
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersTabViewModel @Inject constructor(
    private val characterRepository: CharacterRepository,
) : ViewModel() {

    private val _navigationEvents = MutableSharedFlow<GlHelperEvent>()
    val navigationEvents = _navigationEvents.asSharedFlow()

    private val charactersList: StateFlow<List<CharacterInfo>> =
        characterRepository.getAllCharacters().map { characters ->
            characters
        }.stateIn(
            scope = viewModelScope,
            initialValue = emptyList(),
            started = SharingStarted.WhileSubscribed(0),
        )

    private val filterState: MutableStateFlow<Filters> = MutableStateFlow(Filters())

    val uiState: StateFlow<CharactersTabState> =
        charactersList.combine(filterState) { characters, filters ->
            if (characters.isNotEmpty()) {
                CharactersTabState.Data(
                    filters = filters,
                    characters = characters
                        .filter { if (filters.filterAlive) it.isAlive else true }
                        .filter { if (filters.filterTeamId != null) it.team?.teamId == filters.filterTeamId else true }
                        .map { it.toUi() }
                )
            } else {
                CharactersTabState.Empty(false)
            }
        }.stateIn(
            scope = viewModelScope,
            initialValue = CharactersTabState.Empty(false),
            started = SharingStarted.WhileSubscribed(0),
        )

    fun onAction(action: CharactersTabAction) {
        viewModelScope.launch {
            when (action) {
                is CharactersTabAction.AddCharacter -> {
                    characterRepository.addCharacter(
                        CharacterForSave(
                            name = action.name,
                            level = action.level,
                            characterType = action.characterType
                        )
                    )
                }

                is CharactersTabAction.SwitchAlive -> {
                    filterState.emit(
                        filterState.value.copy(filterAlive = !filterState.value.filterAlive)
                    )
                }

                is CharactersTabAction.ShowByTeam -> {
                    filterState.emit(
                        filterState.value.copy(filterTeamId = action.teamId)
                    )
                }
            }
        }
    }
}