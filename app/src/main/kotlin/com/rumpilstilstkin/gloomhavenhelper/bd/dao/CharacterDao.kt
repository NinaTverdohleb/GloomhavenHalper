package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterBd

@Dao
interface CharacterDao {

    @Query("SELECT * FROM CharacterBd WHERE teamId LIKE :teamId")
    suspend fun findByTeamId(teamId: Int): List<CharacterBd>

    @Insert
    suspend fun insert(character: CharacterBd)

    @Delete
    suspend fun delete(character: CharacterBd)
}