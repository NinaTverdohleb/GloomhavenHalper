package com.rumpilstilstkin.gloomhavenhelper.screens.dialogs.goods

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.GetCharacterGoodsUseCase
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.goods.GetAllGoodsUseCase
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

@HiltViewModel(assistedFactory = AddItemDialogViewModel.Factory::class)
class AddItemDialogViewModel @AssistedInject constructor(
    @Assisted val id: Int,
    getCharacterGoodsUseCase: GetCharacterGoodsUseCase,
    val getAllGoodsUseCase: GetAllGoodsUseCase
) : ViewModel() {

    val uiState: StateFlow<List<GoodUi>> = getCharacterGoodsUseCase(id).map { characterGoods ->
        getAllGoodsUseCase().filter { good -> good.id !in characterGoods.map { it.id } }
            .map { good -> good.toUi() }
    }.stateIn(
        scope = viewModelScope,
        initialValue = emptyList(),
        started = SharingStarted.WhileSubscribed(100),
    )

    @AssistedFactory
    interface Factory {
        fun create(id: Int): AddItemDialogViewModel
    }
}