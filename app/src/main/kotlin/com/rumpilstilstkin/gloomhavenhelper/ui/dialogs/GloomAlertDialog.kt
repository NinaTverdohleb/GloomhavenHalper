package com.rumpilstilstkin.gloomhavenhelper.ui.dialogs

import android.icu.text.CaseMap
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GloomAlertDialog(
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit,
    modifier: Modifier = Modifier,
    confirmEnabled: Boolean = true,
    cancelText: String = "Закрыть",
    confirmText: String = "Выбрать",
    title: String? = null,
    content: @Composable () -> Unit,
) = BasicAlertDialog(
    onDismissRequest = onDismissRequest,
    modifier = modifier
        .clip(RoundedCornerShape(16.dp))
        .background(MaterialTheme.colorScheme.surface)
        .padding(20.dp),
    content = {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            if (title != null) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                HorizontalDivider(color = MaterialTheme.colorScheme.outline)
            }
            content()
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Cancel
                OutlinedButton(
                    onClick = onDismissRequest,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF9CA3AF),
                    ),
                ) {
                    Text(cancelText, fontSize = 12.sp)
                }

                // Spawn
                Button(
                    onClick = onConfirmRequest,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    enabled = confirmEnabled,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                    ),
                ) {
                    Text(
                        confirmText,
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
)

@Preview
@Composable
private fun GloomAlertDialogPreview() {
    GloomhavenHalperTheme {
        GloomAlertDialog(
            onDismissRequest = {},
            onConfirmRequest = {},
            content = {},
            title = "Title"
        )
    }
}