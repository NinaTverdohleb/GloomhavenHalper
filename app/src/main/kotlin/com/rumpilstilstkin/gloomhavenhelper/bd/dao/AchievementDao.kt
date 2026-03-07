package com.rumpilstilstkin.gloomhavenhelper.bd.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.AchievementBd

@Dao
interface AchievementDao {
    @Query("SELECT * FROM AchievementBd")
    suspend fun getAll(): List<AchievementBd>

    @Insert
    suspend fun insertAll(vararg achievements: AchievementBd)
}
