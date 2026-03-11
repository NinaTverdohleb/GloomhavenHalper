package com.rumpilstilstkin.gloomhavenhelper.domain.usecase.scenario

import com.rumpilstilstkin.gloomhavenhelper.data.LevelInfoRepository
import com.rumpilstilstkin.gloomhavenhelper.data.MonsterRepository
import com.rumpilstilstkin.gloomhavenhelper.data.ScenarioRepository
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.ScenarioBattleInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.usecase.team.GetCurrentTeamUseCase
import com.rumpilstilstkin.gloomhavenhelper.utils.toResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetScenarioInfoUseCase @Inject constructor(
    private val getCurrentTeamUseCase: GetCurrentTeamUseCase,
    private val levelInfoRepository: LevelInfoRepository,
    private val monsterRepository: MonsterRepository,
    private val scenarioRepository: ScenarioRepository,
    private val restoreScenarioStateUseCase: RestoreScenarioStateUseCase,
) {
    suspend operator fun invoke(
        scenarioNumber: Int?,
        needRestore: Boolean
    ): Result<ScenarioBattleInfo> = withContext(Dispatchers.Default) {
        getCurrentTeamUseCase().first().let { team ->
            if (team != null) {
                val levelInfo = levelInfoRepository.getLevelInfo(team.level).getOrNull()
                if (needRestore) {
                    restoreScenarioStateUseCase(team, levelInfo)
                } else {
                    val monsters = scenarioNumber?.let { number ->
                        scenarioRepository.getScenario(number).monsters
                    } ?: emptyList()
                    val scenarioMonsters =
                        monsterRepository.getMonstersByNames(monsters, team.level)
                    ScenarioBattleInfo(
                        name = scenarioNumber?.let { number ->
                            team.activeScenario.firstOrNull { it.scenarioNumber == number }?.scenarioName
                        } ?: "Своя карта",
                        monsters = scenarioMonsters,
                        golds = levelInfo?.goldCount ?: 0,
                        exp = levelInfo?.experience ?: 0,
                        trapDamage = levelInfo?.trapDamage ?: 0,
                        gamersCount = team.characters.size,
                        monsterLevel = levelInfo?.monsterLevel ?: 0
                    )
                }.toResult()
            } else {
                Result.failure(IllegalStateException("Team is null"))
            }
        }
    }
}