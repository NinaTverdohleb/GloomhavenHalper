package com.rumpilstilstkin.gloomhavenhelper.data

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.ScenarioGameStateDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.ScenarioGameStateBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioGameState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScenarioGameStateRepository @Inject constructor(
    private val scenarioGameStateDao: ScenarioGameStateDao,
) {
    suspend fun get(): ScenarioGameState? =
        scenarioGameStateDao.get()?.toDomain()

    suspend fun getByName(name: String): ScenarioGameState? =
        scenarioGameStateDao.getByName(name)?.toDomain()

    suspend fun save(state: ScenarioGameState) {
        scenarioGameStateDao.insert(state.toEntity())
    }

    suspend fun update(state: ScenarioGameState) {
        scenarioGameStateDao.update(state.toEntity())
    }

    suspend fun delete() {
        scenarioGameStateDao.deleteAll()
    }

    private fun ScenarioGameStateBd.toDomain() = ScenarioGameState(
        name = name,
        monsterNames = monsterNames,
        round = round,
        availableCards = availableCards,
        activeMonsters = activeMonsters,
        magicCharges = magicChargeMap,
    )

    private fun ScenarioGameState.toEntity() = ScenarioGameStateBd(
        name = name,
        monsterNames = monsterNames,
        round = round,
        availableCards = availableCards,
        activeMonsters = activeMonsters,
        magicChargeMap = magicCharges,
    )
}
