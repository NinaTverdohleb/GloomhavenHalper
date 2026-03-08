package com.rumpilstilstkin.gloomhavenhelper.screens.teem.edit

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun TeamEditRoute(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center) {
        Text(text = "Edit team")
    }
}