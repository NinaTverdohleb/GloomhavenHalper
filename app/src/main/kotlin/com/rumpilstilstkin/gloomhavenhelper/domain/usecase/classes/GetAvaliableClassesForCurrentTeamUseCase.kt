package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.classes

import com.rumpilstilstkin.gloomhavenhelper.data.CharacterClassRepository
import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

class GetAvaliableClassesForCurrentTeamUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val characterClassRepository: CharacterClassRepository,
) {

    @OptIn(ExperimentalCoroutinesApi::class)
    operator fun invoke(): Flow<List<CharacterClassType>> =
        teamRepository.currentTeamId
            .flatMapLatest { teamId ->
                characterClassRepository.getAvailableClassesForTeam(teamId)
            }
}