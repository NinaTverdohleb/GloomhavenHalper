package com.rumpilstilstkin.gloomhavenhelper.screens.scenario.constructor

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.ui.components.GloomCard
import com.rumpilstilstkin.gloomhavenhelper.ui.components.GloomToolbarTitle
import com.rumpilstilstkin.gloomhavenhelper.ui.components.GloomVariantCard
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme
import kotlinx.collections.immutable.persistentListOf

@Composable
internal fun ScenarioConstructorScreen(
    state: ScenarioConstructorStateUi,
    back: () -> Unit,
    toggleMonster: (String) -> Unit,
    startScenario: () -> Unit,
) {
    Scaffold(
        topBar = {
            GloomToolbarTitle(
                title = "Конструктор сценария",
                back = back,
            )
        }
    ) { paddingValues ->

        when(state){
            is ScenarioConstructorStateUi.Content -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues)
                        .padding(16.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Выберите монстров",
                        style = MaterialTheme.typography.titleMedium
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.weight(1f)
                    ) {
                        items(
                            items = state.selectedMonsters,
                            key = { it }
                        ) { monster ->
                            MonsterSelectCard(
                                monster = monster,
                                isSelected = true,
                                onClick = { toggleMonster(monster) }
                            )
                        }

                        items(
                            items = state.availableMonsters,
                            key = { it }
                        ) { monster ->
                            MonsterSelectCard(
                                monster = monster,
                                isSelected = false,
                                onClick = { toggleMonster(monster) }
                            )
                        }
                    }
                    Button(
                        onClick = startScenario,
                        enabled =  state.selectedMonsters.isNotEmpty(),
                        modifier = Modifier.fillMaxWidth().padding(top = 16.dp)
                    ) {
                        Text("Начать сценарий")
                    }
                }
            }
            ScenarioConstructorStateUi.Loading -> {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(paddingValues),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }
    }
}

@Composable
private fun MonsterSelectCard(
    monster: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    GloomVariantCard(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
        active = isSelected,
    ) {
        Row(
            modifier = modifier.fillMaxWidth().padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = monster,
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurface
            )
            if (isSelected) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ScenarioConstructorScreenPreview() {
    GloomhavenHalperTheme {
        ScenarioConstructorScreen(
            state = ScenarioConstructorStateUi.Content(
                availableMonsters = persistentListOf(
                    "Банит-страж",
                    "Темный маг",
                ),
                selectedMonsters = persistentListOf( "Скелет-воин", "Зомби"),
            ),
            back = {},
            toggleMonster = {},
            startScenario = {},
        )
    }
}
