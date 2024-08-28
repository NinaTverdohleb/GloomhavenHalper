package com.rumpilstilstkin.gloomhavenhelper.data

import android.content.res.Resources.NotFoundException
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.TeamDao
import com.rumpilstilstkin.gloomhavenhelper.data.datasource.CurrentTeamDatasource
import com.rumpilstilstkin.gloomhavenhelper.data.mappers.toBd
import com.rumpilstilstkin.gloomhavenhelper.di.ApplicationScope
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfo
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfoForSave
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.toLevel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamRepository @Inject constructor(
    @ApplicationScope private val externalScope: CoroutineScope,
    private val currentTeamDatasource: CurrentTeamDatasource,
    private val teamDao: TeamDao,
    private val characterDao: CharacterDao,
) {
    private val _currentTeam: MutableStateFlow<Result<TeamInfo>> =
        MutableStateFlow(Result.failure(NotFoundException()))

    val currentTeam: StateFlow<Result<TeamInfo>> = _currentTeam.asStateFlow()

    init {
        externalScope.launch {
            updateCurrentTeam()
        }
    }

    suspend fun saveTeam(team: TeamInfoForSave) {
        val savedTeamId = teamDao.insert(team.toBd()).toInt()
        currentTeamDatasource.saveCurrentTeam(savedTeamId)
        team.characters.forEach {
            characterDao.insert(it.toBd(savedTeamId))
        }
        updateCurrentTeam()
    }

    private suspend fun updateCurrentTeam() {
        if (currentTeamDatasource.currentTeam != CurrentTeamDatasource.EMPTY_TEAM) {
            teamDao.findById(currentTeamDatasource.currentTeam).let { team ->
                val characters = characterDao.findByTeamId(team.id).filter { it.isAlive }
                _currentTeam.emit(
                    Result.success(
                        TeamInfo(
                            id = team.id,
                            name = team.name,
                            level = characters.map { it.level }.toLevel()
                        )
                    )
                )
            }
        }
    }
}