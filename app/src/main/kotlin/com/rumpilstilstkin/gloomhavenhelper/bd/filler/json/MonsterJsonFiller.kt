package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.MonsterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterStatsBd
import com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.models.MonsterJson
import javax.inject.Inject

class MonsterJsonFiller @Inject constructor(
    private val jsonDataLoader: JsonDataLoader,
    private val monsterDao: MonsterDao
) {
    suspend fun fillMonsters(version: Int) {
        val monsters = jsonDataLoader.loadMonsters(version)
        val entities = monsters.map { it.toEntity() }
        monsterDao.insertMonsters(*entities.toTypedArray())
    }

    suspend fun fillStats(version: Int, type: String, pack: String) {
        val allMonsters = monsterDao.getAllMonsters()
        val nameToId = allMonsters.associate { it.name to it.monsterId }

        val allStats =
            jsonDataLoader.loadMonsterStats(version, type, pack)

        val entities = allStats.flatMap { monsterStat ->
            val monsterId = nameToId[monsterStat.monsterName]
                ?: throw IllegalStateException("Monster not found: ${monsterStat.monsterName}")
            monsterStat.stats.map { levelStat ->
                MonsterStatsBd(
                    monsterId = monsterId,
                    scenarioLevel = levelStat.level,
                    isElite = levelStat.isElite,
                    life = levelStat.life,
                    stats = levelStat.stats
                )
            }
        }
        monsterDao.insertAllStats(*entities.toTypedArray())
    }
}
