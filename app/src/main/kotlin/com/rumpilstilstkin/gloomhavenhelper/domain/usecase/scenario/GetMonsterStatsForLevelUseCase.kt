package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.data.MonsterRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStats
import javax.inject.Inject

class GetMonsterStatsForLevelUseCase @Inject constructor(
    private val monsterRepository: MonsterRepository,
) {
    suspend operator fun invoke(monsterId: Int, level: Int, isElite: Boolean): MonsterStats =
        monsterRepository.getMonsterStats(
            monsterId = monsterId,
            level = level,
            isElite = isElite
        )
}