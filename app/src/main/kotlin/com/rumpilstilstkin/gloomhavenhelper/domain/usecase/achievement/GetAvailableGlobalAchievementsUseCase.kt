package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.achievement

import com.rumpilstilstkin.gloomhavenhelper.data.AchievementRepository
import com.rumpilstilstkin.gloomhavenhelper.data.TeamRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Achievement
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetAvailableGlobalAchievementsUseCase @Inject constructor(
    private val teamRepository: TeamRepository,
    private val achievementRepository: AchievementRepository,
) {
    operator fun invoke(): Flow<List<Achievement>> =
        teamRepository.currentTeam.map { team ->
            if (team == null) {
                emptyList()
            } else {
                val allAchievements = achievementRepository.getGlobalAchievementsByPacks(team.packs.map { it.name })
                val existingNames = team.globalAchievement.map { it.name }.toSet()
                allAchievements.filter { it.name !in existingNames }
            }
        }
}
