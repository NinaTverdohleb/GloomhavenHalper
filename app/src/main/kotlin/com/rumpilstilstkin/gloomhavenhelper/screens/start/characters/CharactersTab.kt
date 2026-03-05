package com.rumpilstilstkin.gloomhavenhelper.screens.start.characters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterClassUI
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterUI
import com.rumpilstilstkin.gloomhavenhelper.screens.start.characters.components.EmptyCharacters
import com.rumpilstilstkin.gloomhavenhelper.ui.characters.CharacterList
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
internal fun CharactersTab(
    uiState: CharactersTabState,
    addCharacter: () -> Unit,
    openCharacterDetails: (Int) -> Unit,
    switchAlive: () -> Unit,
) {

    when (uiState) {
        is CharactersTabState.Empty -> {
            EmptyCharacters(
                addCharacter = addCharacter
            )
        }

        is CharactersTabState.Data -> {
            CharactersContent(
                filterAlive = uiState.filterAlive,
                characters = uiState.characters,
                switchAlive = switchAlive,
                addCharacter = addCharacter,
                openCharacterDetails = openCharacterDetails
            )
        }
    }
}


@Composable
fun CharactersContent(
    filterAlive: Boolean,
    characters: List<CharacterUI>,
    modifier: Modifier = Modifier,
    switchAlive: () -> Unit,
    openCharacterDetails: (Int) -> Unit,
    addCharacter: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(24.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Button(
                onClick = {
                    addCharacter.invoke()
                },
                modifier = Modifier
            ) {
                Text("Добавить персонажа")
            }

            Icon(
                modifier = Modifier.clickable {
                    switchAlive.invoke()
                },
                imageVector = if (filterAlive) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "isAlive"
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
                .weight(weight = 1f, fill = false)
        ) {
            CharacterList(characters = characters) {
                openCharacterDetails.invoke(it)
            }
        }
    }
}

@Preview
@Composable
private fun DataExample() {
    GloomhavenHalperTheme {
        CharactersContent(
            filterAlive = true,
            characters = listOf(
                CharacterUI(
                    name = "Name",
                    level = 6,
                    characterClass = CharacterClassUI(
                        imageRes = R.drawable.br,
                        name = "Name",
                        classType = CharacterClassType.Brute
                    ), teamName = null

                ),
                CharacterUI(
                    name = "Name2",
                    level = 6,
                    characterClass = CharacterClassUI(
                        imageRes = R.drawable.br,
                        name = "Name",
                        classType = CharacterClassType.Brute
                    ), teamName = null
                )
            ),
            switchAlive = {},
            addCharacter = {},
            openCharacterDetails = {}
        )
    }
}