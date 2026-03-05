package com.rumpilstilstkin.gloomhavenhelper.screens.start.characters.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
internal fun EmptyCharacters(
    modifier: Modifier = Modifier,
    addCharacter: () -> Unit,
) = Column(
    modifier = modifier
        .fillMaxSize()
        .padding(32.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
) {
    Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
    Spacer(modifier = Modifier.height(48.dp))
    Button(
        modifier = Modifier.fillMaxWidth(),
        onClick = {
            addCharacter.invoke()
        }) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Добавить персонажа",
            fontSize = 20.sp
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF1A1C24)
@Composable
private fun EmptyCharactersPreview() {
    GloomhavenHalperTheme {
        EmptyCharacters(
            addCharacter = {}
        )
    }
}