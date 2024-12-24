package com.rumpilstilstkin.gloomhavenhelper.screens.start.team.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterClassUI
import com.rumpilstilstkin.gloomhavenhelper.screens.models.CharacterUI
import com.rumpilstilstkin.gloomhavenhelper.ui.characters.CharacterList
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun CharactersBlock(
    characters: List<CharacterUI>,
    canAdd: Boolean,
    modifier: Modifier = Modifier,
    characterDetails: (Int) -> Unit,
    addCharacter: () -> Unit,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Игроки",
            style = MaterialTheme.typography.titleMedium,
        )
        CharacterList(
            characters = characters,
            onClick = characterDetails
        )
        if (canAdd) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { addCharacter() },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Добавить персонажа")
            }
        }
    }
}

@Preview
@Composable
private fun CharactersBlockPreview() {
    GloomhavenHalperTheme {
        CharactersBlock(
            characters = listOf(
                CharacterUI(
                    name = "Character 1",
                    level = 1,
                    characterClass = CharacterClassUI(
                        classType = CharacterClassType.Brute,
                        name = "Class 1",
                        imageRes = R.drawable.br,
                    ),
                    teamName = null,
                ),
            ),
            canAdd = true,
            characterDetails = {},
            addCharacter = {}
        )
    }
}
