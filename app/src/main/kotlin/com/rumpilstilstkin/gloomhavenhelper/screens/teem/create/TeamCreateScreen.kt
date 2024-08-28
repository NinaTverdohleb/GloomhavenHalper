package com.rumpilstilstkin.gloomhavenhelper.screens.teem.create

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController

@Composable
fun TeamCreateScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: TeamCreateViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    SideEffect {
        if (uiState.done) {
            navController.popBackStack()
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(
            onClick = { viewModel.action(TeamCreateAction.Save) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Сохранить команду")
        }

        TeamPart(name = uiState.name) {
            viewModel.action(TeamCreateAction.EditName(it))
        }

        CharacterPart(
            characters = uiState.characters,
            canAdd = uiState.canAdd
        ) {
            viewModel.action(TeamCreateAction.ShowCharacterDialog)
        }
    }

    AddCharacterDialog(
        showDialog = uiState.showCharacterDialog,
        classes = uiState.classes,
        onDismiss = { viewModel.action(TeamCreateAction.HideCharacterDialog) }
    ) { name, level, classId ->
        viewModel.action(
            TeamCreateAction.AddCharacter(
                name = name,
                level = level,
                classId = classId
            )
        )
    }
}

@Composable
fun TeamPart(
    name: String,
    modifier: Modifier = Modifier,
    onNameChanged: (String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Создадим мега команду",
        )

        TextField(
            value = name,
            onValueChange = { onNameChanged.invoke(it) },
        )

    }

}

@Composable
fun CharacterPart(
    characters: List<CharacterUI>,
    canAdd: Boolean,
    modifier: Modifier = Modifier,
    addCharacter: () -> Unit,
) {
    Log.d("Dto", characters.toString())
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Text(
            text = "Игроки",
        )

        if (canAdd) {
            Button(
                onClick = { addCharacter.invoke() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Добавить")
            }
        }


        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            items(characters) { character ->
                CharacterItem(
                    imageRes = character.characterClass.imageRes,
                    name = character.name,
                    level = character.level
                )
            }
        }
    }
}

@Composable
fun CharacterItem(
    imageRes: Int,
    name: String,
    level: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(painter = painterResource(id = imageRes), contentDescription = "")
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = name)
        Text(text = level.toString(), modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.End)
    }
}

@Composable
fun AddCharacterDialog(
    showDialog: Boolean,
    classes: List<CharacterClassUI>,
    onDismiss: () -> Unit,
    onAdd: (String, Int, Int) -> Unit
) {
    if (showDialog) {
        var newCharacterName by rememberSaveable { mutableStateOf("Text") }
        var selectedIndex by remember { mutableIntStateOf(0) }
        var level by remember { mutableStateOf("") }
        AlertDialog(
            onDismissRequest = { onDismiss.invoke() },
            title = { Text("Добавить персонажа") },
            text = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    DropdownWithIconAndText(
                        items = classes,
                        selectedIndex = selectedIndex
                    ) {
                        selectedIndex = classes.indexOf(it)
                    }
                    OutlinedTextField(
                        value = newCharacterName,
                        onValueChange = { newCharacterName = it },
                        label = { Text("Character Name") }
                    )
                    NumberInputField(
                        value = level,
                        onValueChange = { level = it },
                    )
                }
            },
            confirmButton = {
                Button(
                    onClick = {
                        onAdd.invoke(
                            newCharacterName,
                            level.toIntOrNull() ?: 0,
                            classes[selectedIndex].id
                        )
                    }
                ) {
                    Text("Добавить")
                }
            }
        )
    }
}

@Composable
fun DropdownWithIconAndText(
    items: List<CharacterClassUI>,
    selectedIndex: Int,
    onItemSelected: (CharacterClassUI) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        // Кнопка, которая открывает выпадающее меню
        IconButton(onClick = { expanded = !expanded }) {
            Icon(
                painter = painterResource(id = items[selectedIndex].imageRes),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        // Выпадающее меню
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = items[index].imageRes),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(text = item.name)
                        }
                    },
                    onClick = {
                        expanded = false
                        onItemSelected(item)
                    })
            }
        }
    }
}

@Composable
fun NumberInputField(
    value: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        value = value,
        onValueChange = { newValue ->
            // Фильтрация ввода, чтобы разрешить только цифры
            if (newValue.all { it.isDigit() }) {
                onValueChange(newValue)
            }
        },
        label = { Text(text = "Уровень персонажа") },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Number
        ),
        singleLine = true,
        modifier = Modifier.fillMaxWidth()
    )
}


