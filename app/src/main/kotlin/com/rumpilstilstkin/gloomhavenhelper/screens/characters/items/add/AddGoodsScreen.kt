package com.rumpilstilstkin.gloomhavenhelper.screens.characters.items.add

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalMinimumInteractiveComponentEnforcement
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.GoodType
import com.rumpilstilstkin.gloomhavenhelper.screens.dialogs.goods.GoodDetailsDialog
import com.rumpilstilstkin.gloomhavenhelper.screens.models.GoodUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.toImage
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.GloomhavenIcons
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.goods.Foot
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme


@Composable
fun AddGoodsScreen(
    characterId: Int,
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val viewModel =
        hiltViewModel<AddGoodsScreenViewModel, AddGoodsScreenViewModel.Factory> { factory ->
            factory.create(characterId)
        }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    if (uiState.effects.isClose) {
        navController.popBackStack()
    }

    AddGoodsView(
        goods = uiState.goods,
        searchText = uiState.effects.searchText,
        filterType = uiState.effects.selectedFilters,
        modifier = modifier,
        onAction = viewModel::onAction,
    )
}

@Composable
fun AddGoodsView(
    searchText: String,
    goods: List<GoodUi>,
    filterType: GoodType?,
    modifier: Modifier = Modifier,
    onAction: (AddGoodsScreenActions) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val selectedFilter: (GoodType) -> Unit = {
                onAction(AddGoodsScreenActions.SelectFilter(it))
            }
            FilterButton(
                type = GoodType.Foot,
                selectedFilter = filterType,
                onSelectedChanged = selectedFilter
            )
            FilterButton(
                type = GoodType.Body,
                selectedFilter = filterType,
                onSelectedChanged = selectedFilter
            )
            FilterButton(
                type = GoodType.Arm,
                selectedFilter = filterType,
                onSelectedChanged = selectedFilter
            )
            FilterButton(
                type = GoodType.DoubleArm,
                selectedFilter = filterType,
                onSelectedChanged = selectedFilter
            )
            FilterButton(
                type = GoodType.SmallThing,
                selectedFilter = filterType,
                onSelectedChanged = selectedFilter
            )
        }
        HorizontalDivider(
            modifier = Modifier.padding(vertical = 16.dp),
            thickness = 1.dp,
            color = MaterialTheme.colorScheme.outline
        )

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            value = searchText,
            onValueChange = { onAction(AddGoodsScreenActions.SearchTextChange(it)) },
            label = { Text("Название или номер") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = MaterialTheme.colorScheme.primary,
                unfocusedBorderColor = MaterialTheme.colorScheme.primary,
                focusedLabelColor = MaterialTheme.colorScheme.primary,
                unfocusedLabelColor = MaterialTheme.colorScheme.onSecondary,
                cursorColor = MaterialTheme.colorScheme.primary,

            )
        )
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        LazyColumn(
            Modifier.weight(1f)
        ) {
            items(goods) { good ->
                AddGoodsItem(good) {
                    onAction(AddGoodsScreenActions.ChangeSelectedGoods(it))
                }
                HorizontalDivider(
                    modifier = Modifier.padding(horizontal = 12.dp),
                    thickness = 1.dp,
                    color = MaterialTheme.colorScheme.outline
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Button(
                modifier = Modifier,
                onClick = {
                    onAction(AddGoodsScreenActions.BuySelectedGoods)
                }
            ) {
                Text("Купить")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                modifier = Modifier,
                onClick = {
                    onAction(AddGoodsScreenActions.AddSelectedGoods)
                }
            ) {
                Text("Добавить")
            }
        }
    }
}

@Composable
fun FilterButton(
    type: GoodType,
    selectedFilter: GoodType?,
    modifier: Modifier = Modifier,
    onSelectedChanged: (GoodType) -> Unit
) {
    val isChecked = selectedFilter == type
    Icon(
        modifier = modifier
            .size(60.dp)
            .clickable {
                onSelectedChanged(type)
            },
        imageVector = type.toImage(),
        contentDescription = null,
        tint = if (isChecked) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary
    )

}


@Composable
fun AddGoodsItem(
    good: GoodUi,
    modifier: Modifier = Modifier,
    onSelectedChanged: (Int) -> Unit,
) {
    var showDetailsDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    GoodDetailsDialog(
        goodNumber = good.number,
        showDialog = showDetailsDialog,
        onDismiss = { showDetailsDialog = false },
        canAdd = !isChecked,
        onAdd = {
            onSelectedChanged(good.id)
            isChecked = true
            showDetailsDialog = false
        }
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { showDetailsDialog = true },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
                Checkbox(
                    modifier = Modifier.padding(),
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = !isChecked
                        onSelectedChanged(good.id)
                    },
                    colors = CheckboxDefaults.colors().copy(
                        uncheckedBorderColor = MaterialTheme.colorScheme.primary,
                    )
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Icon(
                modifier = Modifier.size(34.dp),
                imageVector = good.typeImage,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "#" + good.number)
            Spacer(modifier = Modifier.width(16.dp))

            Text(
                modifier = Modifier,
                text = good.name,
                style = MaterialTheme.typography.bodyLarge
            )
        }

        Text(
            modifier = Modifier.padding(
                horizontal = 8.dp
            ),
            style = MaterialTheme.typography.titleLarge,
            text = "${good.cost} G"
        )
    }
}

@Preview
@Composable
private fun SampleItem() {
    GloomhavenHalperTheme {
        Box(
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        ) {
            AddGoodsView(
                searchText = "",
                goods = listOf(
                    GoodUi(
                        id = 1,
                        number = 1,
                        name = "Сапоги большого шага поешь этих сладких французких булок",
                        typeImage = GloomhavenIcons.GoodTypes.Foot,
                        cost = 20,
                    )
                ),
                filterType = GoodType.Arm,
                onAction = {},
            )
        }
    }
}