package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfoWithScenario
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamScenarios
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

//TODO change
class FilterTeamScenariosUseCase @Inject constructor() {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(team: TeamInfoWithScenario): TeamScenarios {
        val allAchievement = sequenceOf(
            team.teamAchievement,
            team.globalAchievement
        )
            .flatMap { it.splitToSequence(",") }
            .map { it.trim() }
            .filter { it.isNotEmpty() }
            .toSet()
        val completed = team.scenario.filter { it.isCompleted }
        val avaliable = team.scenario
            .filter { !it.isCompleted }.toSet()
        val (active, blocked) = avaliable.partition { scenario ->
            val requirements = scenario.scenarioRequirements
                .split(",")
                .map { it.trim() }
                .filter { it.isNotEmpty() }
            requirements.isEmpty() || requirements.all { it in allAchievement }
        }
        return TeamScenarios(
            activeScenarios = active,
            blockedScenarios = blocked,
            completedScenarios = completed,
        )
    }
}