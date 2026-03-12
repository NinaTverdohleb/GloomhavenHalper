package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.goods

import com.rumpilstilstkin.gloomhavenhelper.data.GoodsRepository
import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class RemoveGoodFromCurrentTeamUseCase @Inject constructor(
    private val goodsRepository: GoodsRepository,
    private val teamRepository: TeamRepository,
) {
    suspend operator fun invoke(goodId: Int) {
        val team = teamRepository.currentTeam.first() ?: return
        goodsRepository.removeGoodFromTeam(team.teamId, goodId)
    }
}
