package com.rumpilstilstkin.gloomhavenhelper.screens.characters

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.screens.characters.general.CharacterGeneralTab
import com.rumpilstilstkin.gloomhavenhelper.screens.characters.items.CharacterItemsTab
import com.rumpilstilstkin.gloomhavenhelper.screens.characters.perks.CharacterPerksTab
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme
import com.rumpilstilstkin.gloomhavenhelper.ui.view.Bage

@Composable
fun CharacterDetailsScreen(
    characterId: Int,
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    val viewModel = hiltViewModel<CharacterDetailsViewModel, CharacterDetailsViewModel.Factory> { factory ->
        factory.create(characterId)
    }
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
    ) {
        CharacterHeader(
            classImg = uiState.characterClass.imageRes,
            name = uiState.name,
            level = uiState.level
        )

        CharactersTabs(
            showFirstTab = { CharacterGeneralTab(characterId) },
            showSecondTab = { CharacterItemsTab(characterId) },
            showThirdTab = { CharacterPerksTab(characterId) }
        )
    }

}

@Composable
fun CharacterDetailsMain(
    classImg: Int,
    name: String,
    level: Int,
    modifier: Modifier = Modifier,
    showFirstTab: @Composable () -> Unit,
    showSecondTab: @Composable () -> Unit,
    showThirdTab: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        CharacterHeader(
            classImg = classImg,
            name = name,
            level = level
        )

        CharactersTabs(
            showFirstTab = showFirstTab,
            showSecondTab = showSecondTab,
            showThirdTab = showThirdTab
        )
    }

}

@Composable
fun CharacterHeader(
    classImg: Int,
    name: String,
    level: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxWidth()
            .padding(top = 32.dp, bottom = 16.dp, ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = classImg),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.secondary),
            modifier = Modifier.size(48.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = name, style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onPrimary
        )
        Spacer(modifier = Modifier.width(16.dp))
        Bage(
            text = level.toString(),
            color = MaterialTheme.colorScheme.background,
            modifier = Modifier.size(44.dp)
        )

    }
}

@Composable
fun CharactersTabs(
    modifier: Modifier = Modifier,
    showFirstTab: @Composable () -> Unit,
    showSecondTab: @Composable () -> Unit,
    showThirdTab: @Composable () -> Unit
) {
    var tabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabs = listOf("Общее", "Предметы", "Навыки")

    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        Column {
            TabRow(
                selectedTabIndex = tabIndex,
            ) {
                tabs.forEachIndexed { index, title ->
                    Tab(text = { Text(text = title) },
                        selected = tabIndex == index,
                        onClick = { tabIndex = index }
                    )
                }
            }
            when (tabIndex) {
                0 -> showFirstTab()
                1 -> showSecondTab()
                2 -> showThirdTab()
            }
        }
    }
}

@Preview
@Composable
private fun CharacterDetailsExample() {
    GloomhavenHalperTheme {
        CharacterDetailsMain(
            classImg = R.drawable.be,
            name = "Warrior",
            level = 10,
            showFirstTab = { },
            showSecondTab = { },
            showThirdTab = { }
        )
    }
}