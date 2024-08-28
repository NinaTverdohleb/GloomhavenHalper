package com.rumpilstilstkin.gloomhavenhelper.data.datasource

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurrentTeamDatasource @Inject constructor(
    private val preference: SharedPreferences
) {
    private var _currentTeam: Int = preference.getInt(CURRENT_TEAM, EMPTY_TEAM)

    val currentTeam: Int
        get() = _currentTeam

    fun saveCurrentTeam(team: Int) {
        preference.edit().putInt(CURRENT_TEAM, team).apply()
        _currentTeam = team
    }

    companion object {
        private const val CURRENT_TEAM = "currentTeam"
        const val EMPTY_TEAM = -1
    }
}