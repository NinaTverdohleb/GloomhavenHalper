package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamScenarios
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetTeamScenariosUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val filterTeamScenariosUseCase: FilterTeamScenariosUseCase
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<TeamScenarios> =
        teamRepository.currentTeamId.flatMapLatest { teamId ->
            teamRepository.getTeamWithScenarioFlow(teamId).map { teamInfoWithScenario ->
                filterTeamScenariosUseCase(teamInfoWithScenario)
            }
        }
}