package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.TeamBd

@Dao
interface TeamDao {
    @Query("SELECT * FROM TeamBd")
    suspend fun getAll(): List<TeamBd>

    @Query("SELECT * FROM TeamBd WHERE id LIKE :id LIMIT 1")
    suspend fun findById(id: Int): TeamBd

    @Insert
    suspend fun insert(team: TeamBd): Long

    @Delete
    suspend fun delete(team: TeamBd)
}