package com.rumpilstilstkin.gloomhavenhelper.screens.characters.goods.add

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rumpilstilstkin.gloomhavenhelper.screens.characters.goods.add.components.AddGoodsStatusRow
import com.rumpilstilstkin.gloomhavenhelper.ui.goods.AddGoodsView
import com.rumpilstilstkin.gloomhavenhelper.ui.goods.AddGoodsViewState
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme
@Composable
internal fun AddGoodsScreen(
    uiState: AddGoodsForCharacterScreenUiState,
    onAction: (AddGoodsForCharacterScreenActions) -> Unit,
) {
    AddGoodsView(
        state = uiState.goodsState,
        modifier = Modifier.fillMaxWidth(),
        selectFilter = { onAction(AddGoodsForCharacterScreenActions.SelectFilter(it)) },
        changeSearchText = { onAction(AddGoodsForCharacterScreenActions.SearchTextChange(it)) },
        selectGood = { onAction(AddGoodsForCharacterScreenActions.SelectGood(it)) },
        unselectGood = { onAction(AddGoodsForCharacterScreenActions.UnselectGood(it)) }
    ) {
        AddGoodsStatusRow(
            allGold = uiState.allGold,
            goodsGold = uiState.goodsGold,
            onAction = { onAction(it) }
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1A1C24)
@Composable
private fun AddGoodsScreenPreview() {
    GloomhavenHalperTheme {
        AddGoodsScreen(
            uiState = AddGoodsForCharacterScreenUiState(
                goodsState = AddGoodsViewState.fixture()
            ),
            onAction = {}
        )
    }
}