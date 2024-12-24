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
import com.rumpilstilstkin.gloomhavenhelper.screens.models.ShortScenarioUI
import com.rumpilstilstkin.gloomhavenhelper.ui.scenario.ScenarioListWithDialogs
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun ScenarioBlock(
    scenarios: List<ShortScenarioUI>,
    modifier: Modifier = Modifier,
    completeScenario: (Int) -> Unit,
    startScenario: (Int) -> Unit,
    addScenario: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Сценарии",
            style = MaterialTheme.typography.titleMedium,
        )
        Spacer(modifier = Modifier.height(8.dp))

        ScenarioListWithDialogs(
            scenarios = scenarios,
            onComplete = completeScenario,
            onStart = startScenario
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { addScenario() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Добавить сценарий")
        }
    }
}

@Preview
@Composable
private fun ScenarioBlockPreview() {
    GloomhavenHalperTheme {
        ScenarioBlock(
            scenarios = listOf(
                ShortScenarioUI(
                    scenarioNumber = 1,
                    scenarioName = "Scenario 1",
                    scenarioRequirements = "Requirements 1"
                )
            ),
            completeScenario = {},
            startScenario = {},
            addScenario = {}
        )
    }
}