package com.rumpilstilstkin.gloomhavenhelper.screens.characters.items.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Good
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.GoodType
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.goods.AddGoodForCharacterUseCase
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.goods.BuyGoodForCharacterUseCase
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters.goods.GetAvaliableCharacterGoodsUseCase
import com.rumpilstilstkin.gloomhavenhelper.screens.models.GoodUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toUi
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = AddGoodsScreenViewModel.Factory::class)
class AddGoodsScreenViewModel @AssistedInject constructor(
    @Assisted val id: Int,
    private val addCharacterGoodsUseCase: AddGoodForCharacterUseCase,
    private val buyGoodForCharacterUseCase: BuyGoodForCharacterUseCase,
    private val getGodsForCharacterUseCase: GetAvaliableCharacterGoodsUseCase
) : ViewModel() {

    private val selectedGoodsIds: MutableList<Int> = mutableListOf()

    private val availableGoods: MutableList<Good> = mutableListOf()

    private val effects: MutableStateFlow<AddGoodsScreenEffects> = MutableStateFlow(
        AddGoodsScreenEffects()
    )

    internal val uiState: StateFlow<AddGoodsScreenState> = effects.map { effects ->
        if (availableGoods.isEmpty()) {
            availableGoods.addAll(getGodsForCharacterUseCase(characterId = id))
        }
        AddGoodsScreenState(
            goods = availableGoods
                .filter {
                    if (effects.selectedFilters != null) it.type == effects.selectedFilters
                    else true
                }
                .map { it.toUi() },
            effects = effects
        )
    }.stateIn(
        scope = viewModelScope,
        initialValue = AddGoodsScreenState(),
        started = SharingStarted.WhileSubscribed(100),
    )

    fun onAction(action: AddGoodsScreenActions) {
        viewModelScope.launch {
            when (action) {
                is AddGoodsScreenActions.ChangeSelectedGoods -> {
                    if (action.id in selectedGoodsIds) selectedGoodsIds.remove(action.id)
                    else selectedGoodsIds.add(action.id)
                }

                is AddGoodsScreenActions.AddSelectedGoods -> {
                    addCharacterGoodsUseCase.invoke(selectedGoodsIds, id)
                    effects.emit(effects.value.copy(isClose = true))
                }

                is AddGoodsScreenActions.BuySelectedGoods -> {
                    buyGoodForCharacterUseCase.invoke(
                        availableGoods.filter { it.id in selectedGoodsIds },
                        id
                    ).fold(
                        onSuccess = {
                            effects.emit(effects.value.copy(isClose = true))
                        },
                        onFailure = {
                            effects.emit(effects.value.copy(showCantBuyDialog = true))
                        }
                    )
                }

                is AddGoodsScreenActions.CloseCantBuyDialog -> {
                    effects.emit(effects.value.copy(showCantBuyDialog = false))
                }

                is AddGoodsScreenActions.Close -> {
                    effects.emit(effects.value.copy(isClose = true))
                }

                is AddGoodsScreenActions.SelectFilter -> {
                    val newFilter =
                        if (action.type == uiState.value.effects.selectedFilters) null else action.type
                    effects.emit(effects.value.copy(selectedFilters = newFilter))
                }
            }
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(id: Int): AddGoodsScreenViewModel
    }
}

internal data class AddGoodsScreenState(
    val goods: List<GoodUi> = emptyList(),
    val effects: AddGoodsScreenEffects = AddGoodsScreenEffects(),
)

internal data class AddGoodsScreenEffects(
    val showCantBuyDialog: Boolean = false,
    val isClose: Boolean = false,
    val selectedFilters: GoodType? = null
)

sealed interface AddGoodsScreenActions {
    data class ChangeSelectedGoods(val id: Int) : AddGoodsScreenActions
    data object AddSelectedGoods : AddGoodsScreenActions
    data object BuySelectedGoods : AddGoodsScreenActions
    data object CloseCantBuyDialog : AddGoodsScreenActions
    data object Close : AddGoodsScreenActions
    data class SelectFilter(val type: GoodType) : AddGoodsScreenActions
}