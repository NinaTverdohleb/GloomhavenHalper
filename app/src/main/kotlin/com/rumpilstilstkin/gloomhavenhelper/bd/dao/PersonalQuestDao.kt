package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.PersonalQuestBd

@Dao
interface PersonalQuestDao  {
    @Query("SELECT * FROM PersonalQuestBd")
    suspend fun getAll(): List<PersonalQuestBd>

    @Query("SELECT * FROM PersonalQuestBd WHERE questId LIKE :questId LIMIT 1")
    suspend fun getScenario(questId: String): PersonalQuestBd

    @Insert
    suspend fun insertAll(vararg quests: PersonalQuestBd)
}