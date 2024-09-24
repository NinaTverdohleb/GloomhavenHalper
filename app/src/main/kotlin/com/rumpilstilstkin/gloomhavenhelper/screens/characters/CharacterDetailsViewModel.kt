package com.rumpilstilstkin.gloomhavenhelper.screens.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.GetCharacterGeneralInfoUseCase
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterClassUI
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterUI
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toUI
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel(assistedFactory = CharacterDetailsViewModel.Factory::class)
class CharacterDetailsViewModel @AssistedInject constructor(
    @Assisted val id: Int,
    getCharacterUseCase: GetCharacterGeneralInfoUseCase,
) : ViewModel() {

    val uiState: StateFlow<CharacterUI> = getCharacterUseCase(id).map {
        it.toUI()
    }.stateIn(
        scope = viewModelScope,
        initialValue = CharacterUI(
            name = "",
            level = 0,
            characterClass = CharacterClassUI(
                name = "",
                id = 0,
                imageRes = R.drawable.br
            ),
            id = id,
            isAlive = false
        ),
        started = SharingStarted.WhileSubscribed(100),
    )

    @AssistedFactory
    interface Factory {
        fun create(id: Int): CharacterDetailsViewModel
    }
}