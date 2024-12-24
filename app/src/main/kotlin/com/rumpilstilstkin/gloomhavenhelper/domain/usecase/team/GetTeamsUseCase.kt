package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team

import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ShortTeamInfo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
) {
    operator fun invoke(): Flow<List<ShortTeamInfo>> = teamRepository.getTeams()
}