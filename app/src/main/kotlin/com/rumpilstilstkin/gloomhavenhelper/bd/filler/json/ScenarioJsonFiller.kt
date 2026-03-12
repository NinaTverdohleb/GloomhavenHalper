package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.ScenarioDao
import javax.inject.Inject

class ScenarioJsonFiller @Inject constructor(
    private val jsonDataLoader: JsonDataLoader,
    private val scenarioDao: ScenarioDao
) {
    suspend fun fill(version: Int) {
        val scenarios = jsonDataLoader.loadScenarios(version)
        val entities = scenarios.map { it.toEntity() }
        scenarioDao.insertAll(*entities.toTypedArray())
    }
}
