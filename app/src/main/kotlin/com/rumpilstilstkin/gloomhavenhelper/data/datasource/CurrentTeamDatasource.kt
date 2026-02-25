package com.rumpilstilstkin.gloomhavenhelper.data.datasource

import android.content.SharedPreferences
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton
import androidx.core.content.edit

@Singleton
class CurrentTeamDatasource @Inject constructor(
    private val preference: SharedPreferences
) {

    fun saveCurrentTeam(team: Int) {
        preference.edit(commit = true) { putInt(CURRENT_TEAM, team) }
    }

    fun getCurrentTeam(): Int{
        val currentTeam = preference.getInt(CURRENT_TEAM, EMPTY_TEAM)
        return currentTeam
    }

    companion object {
        private const val CURRENT_TEAM = "currentTeam"
        const val EMPTY_TEAM = -1
    }
}