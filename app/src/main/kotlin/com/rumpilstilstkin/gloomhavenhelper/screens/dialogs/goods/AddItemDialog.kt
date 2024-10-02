package com.rumpilstilstkin.gloomhavenhelper.screens.dialogs.goods

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import com.rumpilstilstkin.gloomhavenhelper.screens.models.GoodUi
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.GloomhavenIcons
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.goods.Foot
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme


@Composable
fun AddItemDialog(
    characterId: Int,
    showDialog: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    if (!showDialog) return

    val viewModel =
        hiltViewModel<AddItemDialogViewModel, AddItemDialogViewModel.Factory> { factory ->
            factory.create(characterId)
        }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    AlertDialog(
        modifier = modifier,
        onDismissRequest = { onDismiss.invoke() },
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Добавить предмет",
                textAlign = TextAlign.Center
            )
        },
        text = {
            LazyColumn {
                items(uiState) { good ->

                }
            }
        },
        confirmButton = {
            Row {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        //TODO
                    }
                ) {
                    Text("Купить")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {
                        //TODO
                    }
                ) {
                    Text("Добавить")
                }
            }
        }
    )
}


@Composable
fun DialogGoodItem(
    good: GoodUi,
    modifier: Modifier = Modifier
) {
    var showDetailsDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    GoodDetailsDialog(
        goodNumber = good.number,
        showDialog = showDetailsDialog,
        onDismiss = { showDetailsDialog = false }
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .clickable { showDetailsDialog = true },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                modifier = Modifier,
                checked = isChecked,
                onCheckedChange = {
                    isChecked = !isChecked
                }
            )
            Icon(
                modifier = Modifier.size(34.dp),
                imageVector = good.typeImage,
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(text = "#" + good.number)
            Spacer(modifier = Modifier.width(8.dp))

            Text(
                modifier = Modifier.width(200.dp),
                text = good.name
            )
        }

        Text(text = "" + good.cost + "G")
    }
}

@Preview
@Composable
private fun SampleItem() {
    GloomhavenHalperTheme {
        DialogGoodItem(
            good = GoodUi(
                id = 1,
                number = 1,
                name = "Сапоги большого шага поешь этих сладких французких булок",
                typeImage = GloomhavenIcons.GoodTypes.Foot,
                cost = 20,
            )
        )
    }
}