package com.rumpilstilstkin.gloomhavenhelper.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Bage(
    text: String,
    color: Color,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(
                color = color,
                shape = CircleShape
            ).padding(4.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.bodyLarge,
            text = text,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSecondary
        )
    }
}