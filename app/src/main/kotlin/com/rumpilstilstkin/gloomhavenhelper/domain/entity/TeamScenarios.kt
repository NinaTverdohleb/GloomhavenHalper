package com.rumpilstilstkin.gloomhavenhelper.domain.entity

data class TeamScenarios(
    val activeScenarios: List<ScenarioShortInfo>,
    val blockedScenarios: List<ScenarioShortInfo>,
    val completedScenarios: List<ScenarioShortInfo>,
)
