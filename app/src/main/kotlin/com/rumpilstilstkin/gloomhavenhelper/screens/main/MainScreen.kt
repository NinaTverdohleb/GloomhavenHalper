package com.rumpilstilstkin.gloomhavenhelper.screens.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.navigation.GlHelperScreens
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun MainScreen(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is MainScreenUiState.Empty -> EmptyScreen(modifier = modifier) {
            navController.navigate(GlHelperScreens.TeamCreate)
        }
        is MainScreenUiState.Team -> TeamPreview(
            team = uiState as MainScreenUiState.Team, modifier = modifier
        )
    }
}

@Composable
fun EmptyScreen(
    modifier: Modifier = Modifier,
    createTeam: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "logo")
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = {
            createTeam.invoke()
        }) {
            Text(text = "Начать игру", fontSize = 20.sp)
        }

    }
}

@Composable
fun TeamPreview(
    team: MainScreenUiState.Team,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = team.teamName, fontSize = 20.sp)
    }
}

@Preview
@Composable
private fun Empty() {
    GloomhavenHalperTheme {
        EmptyScreen {}
    }
}