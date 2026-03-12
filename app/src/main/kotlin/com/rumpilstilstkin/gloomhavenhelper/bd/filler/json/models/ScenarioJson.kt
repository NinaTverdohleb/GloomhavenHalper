package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.models

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.ScenarioBd
import kotlinx.serialization.Serializable

@Serializable
data class ScenarioJson(
    val scenarioNumber: Int,
    val name: String,
    val newScenarios: String = "",
    val teamAchievement: String = "",
    val globalAchievement: String = "",
    val requirements: String = "",
    val monsters: List<String> = emptyList(),
    val location: String = "",
    val pack: String
) {
    fun toEntity() = ScenarioBd(
        scenarioNumber = scenarioNumber,
        name = name,
        newScenarios = newScenarios,
        teamAchievement = teamAchievement,
        globalAchievement = globalAchievement,
        requirements = requirements,
        monsters = monsters,
        location = location,
        pack = pack
    )
}
