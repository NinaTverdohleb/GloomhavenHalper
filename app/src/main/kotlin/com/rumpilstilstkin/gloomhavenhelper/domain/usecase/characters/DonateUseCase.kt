package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.characters

import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team.GetNextChurchValueUseCase
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team.UpdateTeamProsperityUseCase
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class DonateUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val getNextChurchValueUseCase: GetNextChurchValueUseCase,
    private val updateTeamProsperityUseCase: UpdateTeamProsperityUseCase
) {
    suspend operator fun invoke(oldChurchValue: Int) {
        val team = teamRepository.currentTeam.first() ?: return
        val churchValue = teamRepository.donate(team.teamId)
        if (churchValue == getNextChurchValueUseCase(oldChurchValue)) {
            updateTeamProsperityUseCase(team.prosperity.plus(1))
        }
    }
}