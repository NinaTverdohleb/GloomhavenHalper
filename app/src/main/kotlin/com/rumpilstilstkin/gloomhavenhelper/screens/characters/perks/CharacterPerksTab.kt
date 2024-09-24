package com.rumpilstilstkin.gloomhavenhelper.screens.characters.perks

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.rumpilstilstkin.gloomhavenhelper.screens.characters.general.CharacterGeneralTabViewModel
import com.rumpilstilstkin.gloomhavenhelper.screens.models.PerkUI
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun CharacterPerksTab(
    characterId: Int,
    modifier: Modifier = Modifier
) {
    val viewModel =
        hiltViewModel<CharacterPerksTabViewModel, CharacterPerksTabViewModel.Factory> { factory ->
            factory.create(characterId)
        }
    //val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    var showAddPerksDialog by remember { mutableStateOf(false) }
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    showAddPerksDialog = true
                },
                content = {
                    Icon(Icons.Filled.Add, "Добавить навык")
                }
            )
        },
        content = { innerPadding ->
            AddPerksDialog(
                avaliablePerks = emptyList(),
                showDialog = showAddPerksDialog,
                onDismiss = { showAddPerksDialog = false },
                onPerkSelected = {
                    showAddPerksDialog = false
                }
            )
            CharacterPerksList(perks = emptyList(), modifier = modifier.padding(innerPadding))
        }
    )

}

@Composable
fun AddPerksDialog(
    avaliablePerks: List<PerkUI>,
    showDialog: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onPerkSelected: (Int) -> Unit,
) {
    if (showDialog) {
        AlertDialog(
            modifier = modifier,
            onDismissRequest = { onDismiss.invoke() },
            title = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Доступные навыки",
                    textAlign = TextAlign.Center
                )
            },
            text = {
                LazyColumn(
                    modifier = modifier.fillMaxWidth()
                ) {
                    items(avaliablePerks) { perk ->
                        Text(
                            modifier = Modifier
                                .padding(horizontal = 12.dp, vertical = 8.dp)
                                .clickable { onPerkSelected(perk.id) },
                            text = perk.text
                        )
                        HorizontalDivider(
                            modifier = Modifier.padding(horizontal = 12.dp),
                            thickness = 1.dp,
                            color = MaterialTheme.colorScheme.outline
                        )
                    }
                }
            },
            confirmButton = {
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = { onDismiss.invoke() }
                ) {
                    Text("Закрыть")
                }
            }
        )
    }

}

@Composable
fun CharacterPerksList(
    perks: List<PerkUI>,
    modifier: Modifier = Modifier,
    onDeleted: (Int) -> Unit = {}
) {

    LazyColumn(
        modifier = modifier.fillMaxWidth()
    ) {
        items(perks) { perk ->
            PerkItem(
                perk = perk,
                onDeleted = onDeleted
            )
            HorizontalDivider(
                modifier = Modifier.padding(horizontal = 12.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outline
            )
        }
    }

}

@Composable
fun PerkItem(
    perk: PerkUI,
    modifier: Modifier = Modifier,
    onDeleted: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = perk.text)
        IconButton(onClick = { onDeleted(perk.id) }) {
            Icon(Icons.Filled.Delete, "Удалить навык", tint = MaterialTheme.colorScheme.error)
        }
    }

}

@Preview
@Composable
private fun Sample() {
    GloomhavenHalperTheme {
        CharacterPerksList(
            perks = listOf(
                PerkUI(1, "Перк 1"),
                PerkUI(2, "Перк 2"),
                PerkUI(3, "Перк 3"),
            )
        )
    }
}

@Preview
@Composable
private fun SampleAddPerksDialog() {
    GloomhavenHalperTheme {
        AddPerksDialog(
            avaliablePerks = listOf(
                PerkUI(1, "Перк 1"),
                PerkUI(2, "Перк 2"),
                PerkUI(3, "Перк 3"),
            ),
            showDialog = true,
            onDismiss = {},
            onPerkSelected = {}
        )
    }
}