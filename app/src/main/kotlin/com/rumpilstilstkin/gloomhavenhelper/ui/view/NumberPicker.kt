package com.rumpilstilstkin.gloomhavenhelper.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun NumberPicker(
    value: Int,
    intRange: IntRange,
    size: PickerSize = PickerSize.M,
    modifier: Modifier = Modifier,
    onValueChange: (Int) -> Unit,
) {
    Row(
        modifier = modifier.padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = CenterVertically
    ) {
        PickerButton(
            size = size,
            value = value,
            type = PickerButtonType.MINUS,
            onValueChange = {
                onValueChange(checkRange(it, intRange))
            }
        )
        val textStyle = when(size){
            PickerSize.S -> MaterialTheme.typography.headlineSmall
            PickerSize.M -> MaterialTheme.typography.headlineMedium
        }
        val padding = when(size){
            PickerSize.S -> 4.dp
            PickerSize.M -> 16.dp
        }
        Text(
            style = textStyle,
            modifier = Modifier.padding(horizontal = padding).align(CenterVertically).defaultMinSize(minWidth = 48.dp),
            text = value.toString(),
            textAlign = TextAlign.Center
        )
        PickerButton(
            size = size,
            value = value,
            type = PickerButtonType.PLUS,
            onValueChange = {
                onValueChange(checkRange(it, intRange))
            }
        )
    }
}

private fun checkRange(value: Int, range: IntRange): Int {
    return when {
        value < range.first -> range.first
        value > range.last -> range.last
        else -> value
    }
}

@Preview
@Composable
private fun SampleM() {
    GloomhavenHalperTheme {
        NumberPicker(
            value = 127,
            intRange = IntRange(12, 15),
            onValueChange = {}
        )
    }

}

@Preview
@Composable
private fun SampleS() {
    GloomhavenHalperTheme {
        NumberPicker(
            size = PickerSize.S,
            value = 127,
            intRange = IntRange(12, 15),
            onValueChange = {}
        )
    }

}