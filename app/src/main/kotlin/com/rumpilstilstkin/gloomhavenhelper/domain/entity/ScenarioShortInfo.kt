package com.rumpilstilstkin.gloomhavenhelper.domain.entity

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.Monster

data class ScenarioShortInfo(
    val scenarioNumber: Int,
    val scenarioName: String,
    val scenarioRequirements: LogicalCondition,
    val isCompleted: Boolean,
    val location: String,
    val pack: PackType
)

data class ScenarioInfo(
    val scenarioNumber: Int,
    val scenarioName: String,
    val scenarioRequirements: LogicalCondition,
    val newScenario: List<Int>,
    val teamAchievements: List<String>,
    val globalAchievements: List<String>,
    val location: String,
    val pack: PackType
)