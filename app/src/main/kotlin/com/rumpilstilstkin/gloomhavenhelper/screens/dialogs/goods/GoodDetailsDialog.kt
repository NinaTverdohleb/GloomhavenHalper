package com.rumpilstilstkin.gloomhavenhelper.screens.dialogs.goods

import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import com.rumpilstilstkin.gloomhavenhelper.R

import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoodDetailsDialog(
    goodNumber: Int,
    showDialog: Boolean,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
) {
    if (!showDialog) return

    BasicAlertDialog(
        modifier = modifier,
        content = {
            Image(painter = painterResource(id = getGoodImageByNumber(goodNumber)), contentDescription = "изображение")
        },
        onDismissRequest = { onDismiss() },
    )
}

private fun getGoodImageByNumber(goodNumber: Int): Int = when(goodNumber){
    1 -> R.drawable.unknown_good
    else -> R.drawable.unknown_good
}