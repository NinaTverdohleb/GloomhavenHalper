package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.ScenarioBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.LogicalCondition
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.PackType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioShortInfo

fun ScenarioBd.toDomain() = ScenarioInfo(
    scenarioNumber = this.scenarioNumber,
    scenarioName = this.name,
    scenarioRequirements = LogicalCondition(this.requirements),
    newScenario = this.newScenarios.split(",")
        .mapNotNull { if (it.isNotBlank()) it.trim().toInt() else null },
    teamAchievements = this.teamAchievement.split(","),
    globalAchievements = this.globalAchievement.split(","),
    location = this.location,
    pack = PackType.valueOf(this.pack),
    monsters = this.monsters
)

fun ScenarioBd.toShortDomain(
    isCompleted: Boolean
) = ScenarioShortInfo(
    scenarioNumber = this.scenarioNumber,
    scenarioName = this.name,
    scenarioRequirements = LogicalCondition(this.requirements),
    location = this.location,
    pack = PackType.valueOf(this.pack),
    isCompleted = isCompleted,
    monsters = this.monsters
)