package com.rumpilstilstkin.gloomhavenhelper.screens.scenario.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
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
fun SpawnMonsterDialog(
    monsterName: String,
    availableIds: List<Int>,
    onDismiss: () -> Unit,
    onSpawn: (numbers: List<Int>, isElite: Boolean) -> Unit,
) {
    var selectedTier by remember { mutableStateOf(UnitTier.Normal) }
    var selectedIds by remember { mutableStateOf<List<Int>>(emptyList()) }

    BasicAlertDialog(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(20.dp),
        onDismissRequest = onDismiss
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.size(20.dp),
                )
                Text(
                    text = monsterName,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                )
            }

            TierSelector(
                selected = selectedTier,
                onSelect = { selectedTier = it },
            )

            // ── Assign Unit ID ─────────────────────────────────────────────
            UnitIdGrid(
                ids = availableIds,
                selectedIds = selectedIds,
                onSelect = { number ->
                    if(selectedIds.contains(number)){
                        selectedIds = selectedIds - number
                    }else {
                        selectedIds = selectedIds + number
                    }
                },
            )

            // ── Buttons ────────────────────────────────────────────────────
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Cancel
                OutlinedButton(
                    onClick = onDismiss,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    border = BorderStroke(1.dp, Color(0xFF374151)),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color.Transparent,
                        contentColor = Color(0xFF9CA3AF),
                    ),
                ) {
                    Text("Закрыть", fontSize = 12.sp)
                }

                // Spawn
                Button(
                    onClick = { onSpawn(selectedIds, selectedTier == UnitTier.Elite) },
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(8.dp),
                    enabled = selectedIds.isNotEmpty(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onSurface,
                        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.4f),
                    ),
                ) {
                    Text(
                        "Выбрать",
                        fontSize = 12.sp,
                    )
                }
            }
        }
    }
}

// ─── Tier selector ────────────────────────────────────────────────────────────

enum class UnitTier(val text: String) { Normal("Обычные"), Elite("Элитные") }

@Composable
private fun TierSelector(
    selected: UnitTier,
    onSelect: (UnitTier) -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF0F1F18))
            .padding(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        UnitTier.entries.forEach { tier ->
            val isSelected = tier == selected
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clip(RoundedCornerShape(6.dp))
                    .background(
                        if (isSelected) Color(0xFFC9A84C) else Color.Transparent
                    )
                    .clickable { onSelect(tier) }
                    .padding(vertical = 8.dp),
                contentAlignment = Alignment.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                ) {
                    if (tier == UnitTier.Elite) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            tint = if (isSelected) Color.White else Color(0xFF6B7280),
                            modifier = Modifier.size(12.dp),
                        )
                    }
                    Text(
                        text = tier.text,
                        fontSize = 13.sp,
                        fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                        color = if (isSelected) Color.White else Color(0xFF6B7280),
                    )
                }
            }
        }
    }
}

// ─── Unit ID grid ─────────────────────────────────────────────────────────────

@Composable
private fun UnitIdGrid(
    ids: List<Int>,
    selectedIds: List<Int>,
    onSelect: (Int) -> Unit,
) {
    val columns = 5
    val rows = ids.chunked(columns)

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        rows.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                row.forEach { id ->
                    UnitIdCell(
                        id = id,
                        isSelected = selectedIds.contains(id),
                        onClick = { onSelect(id) },
                        modifier = Modifier.weight(1f),
                    )
                }
                // fill empty slots in last row
                repeat(columns - row.size) {
                    Spacer(Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun UnitIdCell(
    id: Int,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val cyan = Color(0xFF4DD0E1)
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xFF0F2A2A) else Color(0xFF0F1F18))
            .then(
                if (isSelected) Modifier.border(1.dp, cyan, RoundedCornerShape(8.dp))
                else Modifier
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = id.toString(),
            fontSize = 14.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Normal,
            color = if (isSelected) cyan else Color(0xFF6B7280),
        )
    }
}

@Preview
@Composable
private fun SpawnMonsterDialogPreview() {
    GloomhavenHalperTheme {
        SpawnMonsterDialog(
            monsterName = "Хвостожабка",
            availableIds = (1..14).toList(),
            onDismiss = { },
            onSpawn = { _, _ -> },
        )
    }
}