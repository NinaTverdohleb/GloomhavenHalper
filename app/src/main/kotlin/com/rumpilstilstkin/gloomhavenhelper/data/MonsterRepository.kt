package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.MonsterDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.Monster
import javax.inject.Inject

class MonsterRepository @Inject constructor(
    val monsterDao: MonsterDao
) {
    suspend fun getMonstersForScenario(
        scenarioNumber: Int,
        level: Int
    ): List<Monster> =
        monsterDao.getMonstersForScenario(
            scenarioNumber = scenarioNumber
        ).map { monster ->
            val regularStats = monsterDao.getStats(
                monsterId = monster.monsterId,
                level = level,
                isElite = false
            )
            val eliteStats = if (monster.isBoss) {
                null
            } else {
                monsterDao.getStats(
                    monsterId = monster.monsterId,
                    level = level,
                    isElite = true
                )
            }
            val cards = monsterDao.getCardsByDeckName(monster.deckName)
            Monster(
                id = monster.monsterId,
                name = monster.name,
                life = regularStats.life,
                stats = regularStats.stats,
                eliteLife = eliteStats?.life ?: 0,
                eliteStats = eliteStats?.stats ?: emptyList(),
                cards = cards.map { it.toDomain() },
                deckName = monster.deckName,
                isBoss = monster.isBoss,
                immunity = monster.immunity
            )
        }
}
