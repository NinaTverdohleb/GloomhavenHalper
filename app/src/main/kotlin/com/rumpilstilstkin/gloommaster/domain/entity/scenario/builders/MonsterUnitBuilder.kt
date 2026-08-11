package com.rumpilstilstkin.gloommaster.domain.entity.scenario.builders

import com.rumpilstilstkin.gloommaster.domain.entity.ScenarioGameStateMonsterUnit
import com.rumpilstilstkin.gloommaster.domain.entity.monster.Monster
import com.rumpilstilstkin.gloommaster.domain.entity.monster.MonsterStatType
import com.rumpilstilstkin.gloommaster.domain.entity.scenario.MonsterUnit

class MonsterUnitBuilder(
    private val stateUnit: ScenarioGameStateMonsterUnit,
    private val baseMonster: Monster,
) {
    private var lastLevel: Int = 0
    private var newLevel: Int = 0
    private var gamersCount: Int = 1

    fun levels(levels: Pair<Int, Int>) =
        apply {
            this.lastLevel = levels.first
            this.newLevel = levels.second
        }

    fun gamersCount(count: Int) = apply { this.gamersCount = count }

    suspend fun build(
        availableEffects: Set<MonsterStatType>,
        getMonster: suspend (level: Int, slug: String) -> Monster?,
    ): MonsterUnit {
        val unitMonster =
            if (lastLevel == stateUnit.level) {
                baseMonster
            } else {
                val levelC = maxOf((newLevel + (stateUnit.level - lastLevel)), 0)
                getMonster(levelC, baseMonster.slug) ?: baseMonster
            }
        return MonsterUnit.create(
            monster = unitMonster,
            number = stateUnit.number,
            maxLife = stateUnit.maxLife,
            currentLife = stateUnit.currentLife,
            effects = stateUnit.effects,
            gamersCount = gamersCount,
            availableEffects = availableEffects,
            isElite = stateUnit.isElite,
            isNew = stateUnit.isNew,
        )
    }
}
