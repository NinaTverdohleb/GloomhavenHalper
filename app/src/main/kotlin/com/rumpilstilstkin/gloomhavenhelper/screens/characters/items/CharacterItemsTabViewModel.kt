package com.rumpilstilstkin.gloomhavenhelper.screens.characters.items

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.GetCharacterGoodsUseCase
import com.rumpilstilstkin.gloomhavenhelper.screens.models.GoodUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toUi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

@HiltViewModel(assistedFactory = CharacterItemsTabViewModel.Factory::class)
class CharacterItemsTabViewModel @AssistedInject constructor(
    @Assisted val id: Int,
    getCharacterGoodsUseCase: GetCharacterGoodsUseCase,
) : ViewModel() {

    val uiState: StateFlow<List<GoodUi>> = getCharacterGoodsUseCase(id).map {
        it.map { good -> good.toUi()}
    }.stateIn(
        scope = viewModelScope,
        initialValue = emptyList(),
        started = SharingStarted.WhileSubscribed(100),
    )

    @AssistedFactory
    interface Factory {
        fun create(id: Int): CharacterItemsTabViewModel
    }
}