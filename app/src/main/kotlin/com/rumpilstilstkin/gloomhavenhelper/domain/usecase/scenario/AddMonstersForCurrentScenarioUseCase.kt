package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.data.ScenarioGameStateRepository
import javax.inject.Inject

class AddMonstersForCurrentScenarioUseCase @Inject constructor(
    private val scenarioGameStateRepository: ScenarioGameStateRepository
) {
    suspend operator fun invoke(monsters: List<String>) {
        scenarioGameStateRepository.get()?.let { scenario ->
            scenarioGameStateRepository.update(
                scenario.copy(
                    monsterNames = (scenario.monsterNames + monsters).distinct()
                )
            )
        }
    }
}