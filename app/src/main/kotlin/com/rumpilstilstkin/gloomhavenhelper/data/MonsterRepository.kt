package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.MonsterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.ScenarioDao
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toDomain
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.Monster
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStats
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MonsterRepository @Inject constructor(
    val monsterDao: MonsterDao,
    val scenarioDao: ScenarioDao,
) {
    suspend fun getMonsterNamesForScenario(
        scenarioNumber: Int,
    ): List<String> =
        scenarioDao.getScenario(
            scenarioNumber = scenarioNumber
        ).monsters

    suspend fun getMonsterStats(monsterId: Int, level: Int, isElite: Boolean): MonsterStats {
        val monster = monsterDao.getMonsterById(monsterId)
        val stats = monsterDao.getStats(
            monsterId = monster.monsterId,
            level = level,
            isElite = isElite
        )
        return MonsterStats(
            monsterId = monster.monsterId,
            level = level,
            isElite = isElite,
            life = stats.life,
            stats = stats.stats,
        )
    }

    suspend fun getMonstersForPacks(packs: List<String>): List<String> =
        monsterDao.getMonstersByPacks(packs).map { monster -> monster.name }


    suspend fun getMonstersByNames(
        names: List<String>,
        level: Int
    ): List<Monster> =
        names
            .map { monsterName ->
                val monster = monsterDao.getMonsterByName(monsterName)
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
                    immunity = monster.immunity,
                    isFly = monster.fly,
                    level = level,
                    lifeMultiple = monster.lifeMultiple,
                )
            }
}