package com.rumpilstilstkin.gloomhavenhelper.screens.scenario

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rumpilstilstkin.gloomhavenhelper.screens.models.ActionUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.EffectItem
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterAbilityCard
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterItem
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterUnit
import com.rumpilstilstkin.gloomhavenhelper.screens.scenario.components.AddMonsterCard
import com.rumpilstilstkin.gloomhavenhelper.screens.scenario.components.RegularMonsterCard
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun ScenarioScreen(
    state: ScenarioUIState,
    complete: () -> Unit,
    back: () -> Unit,
    addMonster: () -> Unit,
    deleteMonster: (monsterId: Int) -> Unit,
    deleteUnit: (unitNumber: Int, monsterId: Int) -> Unit,
    updateUnitLife: (unitNumber: Int, monsterId: Int, life: Int) -> Unit,
    switchUnitEffect: (unitNumber: Int, monsterId: Int, effect: ActionUi) -> Unit,
    nextRound: () -> Unit,
    addMonsterUnit: (unitNumbers: List<Int>, monsterId: Int, isElite: Boolean) -> Unit,
) = Scaffold(
    topBar = {
        CombatToolbar(
            roundNumber = state.round,
            back = back,
            complete = complete
        )
    },
    containerColor = Color(0xFF1A1C24),
) { paddingValues ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .padding(top = 16.dp),
    ) {
        ScenarioHeader(
            title = state.name,
        )

        Spacer(
            modifier = Modifier.height(16.dp)
        )
        ScenarioScreenContent(
            modifier = Modifier.weight(1f),
            monsters = state.monsters,
            addMonster = addMonster,
            delete = deleteMonster,
            deleteUnit = deleteUnit,
            updateUnitLife = updateUnitLife,
            switchUnitEffect = switchUnitEffect,
            addMonsterUnit = addMonsterUnit
        )
        if (state.monsters.isNotEmpty()) {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = nextRound
            ) {
                Text(
                    text = "Раунд",
                    fontSize = 16.sp
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CombatToolbar(
    roundNumber: Int,
    complete: () -> Unit,
    back: () -> Unit
) = CenterAlignedTopAppBar(
    title = {
        Box(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.secondary,
                    shape = RoundedCornerShape(50)
                )
                .heightIn(min = 24.dp)
                .padding(horizontal = 10.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Раунд: $roundNumber",
                style = LocalTextStyle.current.copy(
                    fontSize = 14.sp,
                    lineHeight = 12.sp,
                    platformStyle = PlatformTextStyle(includeFontPadding = false),
                    lineHeightStyle = LineHeightStyle(
                        alignment = LineHeightStyle.Alignment.Center,
                        trim = LineHeightStyle.Trim.Both
                    )
                ),
                color = MaterialTheme.colorScheme.secondary,
                textAlign = TextAlign.Center
            )
        }
    },
    navigationIcon = {
        IconButton(onClick = back) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
        }
    },
    actions = {
        TextButton(
            onClick = complete
        ) {
            Text(
                text = "Завершить",
                fontSize = 13.sp,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
)

@Composable
private fun ScenarioHeader(
    title: String,
    modifier: Modifier = Modifier
) = Row(
    modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall,
        color = MaterialTheme.colorScheme.onSurface
    )
}

@Composable
fun ScenarioScreenContent(
    monsters: List<MonsterItem>,
    addMonster: () -> Unit,
    delete: (monsterNumber: Int) -> Unit,
    deleteUnit: (unitNumber: Int, monsterId: Int) -> Unit,
    updateUnitLife: (unitNumber: Int, monsterId: Int, life: Int) -> Unit,
    switchUnitEffect: (unitNumber: Int, monsterId: Int, effect: ActionUi) -> Unit,
    addMonsterUnit: (unitNumbers: List<Int>, monsterId: Int, isElite: Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        val pageCount = monsters.size + 1
        val pagerState = rememberPagerState(pageCount = { pageCount })
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 16.dp),
                pageSpacing = 16.dp,
                modifier = Modifier.padding(top = 24.dp)
            ) { page ->
                if (page == pageCount - 1) {
                    AddMonsterCard(
                        addMonster = addMonster
                    )
                } else {
                    val currentCard = monsters[page]
                    RegularMonsterCard(
                        item = currentCard,
                        delete = delete,
                        deleteUnit = deleteUnit,
                        updateUnitLife = updateUnitLife,
                        switchUnitEffect = switchUnitEffect,
                        addMonsterUnit = addMonsterUnit
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ScenarioScreenPreview() {
    GloomhavenHalperTheme {
        ScenarioScreen(
            state = ScenarioUIState(
                name = "Гиблая лужa",
                monsters = listOf(
                    MonsterItem(
                        id = 1,
                        name = "Хвостожабка",
                        currentCard = MonsterAbilityCard(
                            id = 524,
                            initiative = 15,
                            lines = listOf(
                                EffectItem.Action(ActionUi.MOVE, "-1"),
                                EffectItem.Action(
                                    ActionUi.STRENGTH,
                                    "",
                                    listOf(EffectItem.Text("Себя"))
                                ),
                            ),
                            needsShuffle = true
                        ),
                        units = listOf(
                            MonsterUnit(
                                number = 2,
                                isSpecial = true,
                                currentLife = 10,
                                maxLife = 10,
                                stats = listOf(
                                    EffectItem.Action(
                                        type = ActionUi.MOVE,
                                        modifier = "3"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.ATTACK,
                                        modifier = "4"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.SHIELD,
                                        modifier = "2"
                                    ),
                                )
                            ),
                            MonsterUnit(
                                number = 3,
                                isSpecial = false,
                                currentLife = 10,
                                maxLife = 10,
                                stats = listOf(
                                    EffectItem.Action(
                                        type = ActionUi.MOVE,
                                        modifier = "3"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.ATTACK,
                                        modifier = "4"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.SHIELD,
                                        modifier = "2"
                                    ),
                                )
                            ),
                            MonsterUnit(
                                number = 5,
                                isSpecial = false,
                                currentLife = 10,
                                maxLife = 10,
                                stats = listOf(
                                    EffectItem.Action(
                                        type = ActionUi.MOVE,
                                        modifier = "3"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.ATTACK,
                                        modifier = "4"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.SHIELD,
                                        modifier = "2"
                                    ),
                                )
                            ),
                        )
                    ),
                    MonsterItem(
                        id = 2,
                        name = "Скелет",
                        currentCard = MonsterAbilityCard(
                            id = 524,
                            initiative = 15,
                            lines = listOf(
                                EffectItem.Action(ActionUi.MOVE, "-1"),
                                EffectItem.Action(
                                    ActionUi.STRENGTH,
                                    "",
                                    listOf(EffectItem.Text("Себя"))
                                ),
                            ),
                            needsShuffle = true
                        ),
                        units = listOf(
                            MonsterUnit(
                                number = 2,
                                isSpecial = true,
                                currentLife = 10,
                                maxLife = 10,
                                stats = listOf(
                                    EffectItem.Action(
                                        type = ActionUi.MOVE,
                                        modifier = "3"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.ATTACK,
                                        modifier = "4"
                                    ),
                                    EffectItem.Action(
                                        type = ActionUi.SHIELD,
                                        modifier = "2"
                                    ),
                                )
                            ),
                        )
                    )
                )
            ),
            addMonster = {},
            back = {},
            complete = {},
            deleteMonster = { _ -> },
            deleteUnit = { _, _ -> },
            updateUnitLife = { _, _, _ -> },
            switchUnitEffect = { _, _, _ -> },
            nextRound = {},
            addMonsterUnit = {_, _, _ -> }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ScenarioScreenEmptyPreview() {
    GloomhavenHalperTheme {
        ScenarioScreen(
            state = ScenarioUIState(
                name = "Гиблая лужa",
            ),
            addMonster = {},
            back = {},
            complete = {},
            deleteMonster = { _ -> },
            deleteUnit = { _, _ -> },
            updateUnitLife = { _, _, _ -> },
            switchUnitEffect = { _, _, _ -> },
            nextRound = {},
            addMonsterUnit = {_, _, _ -> }
        )
    }
}
