package com.rumpilstilstkin.gloomhavenhelper.screens.scenario.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterItem
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MonsterListDialog(
    showDialog: Boolean,
    monsters: List<MonsterItem>,
    selectMonster: (Int) -> Unit,
    onDismiss: () -> Unit,
) {
    if (showDialog) {
        BasicAlertDialog(
            content = {
                Card(
                    shape = RoundedCornerShape(16.dp),

                    ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterHorizontally),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        monsters.forEach { monster ->
                            MonsterListItem(
                                monsterItem = monster,
                                modifier = Modifier.clickable {
                                    selectMonster(monster.id)
                                    onDismiss()
                                }
                            )
                        }
                    }
                }
            },
            onDismissRequest = { onDismiss() },
        )
    }
}

@Composable
fun MonsterListItem(
    monsterItem: MonsterItem,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(8.dp).fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineSmall,
            text = monsterItem.name
        )
    }
}

@Preview
@Composable
private fun MonsterListDialogPreview() {
    GloomhavenHalperTheme {
        MonsterListDialog(
            showDialog = true,
            monsters = listOf(
                MonsterItem.fixture(1, "Скелет"),
                MonsterItem.fixture(2, "Зомби"),
            ),
            onDismiss = {},
            selectMonster = {},
        )
    }
}