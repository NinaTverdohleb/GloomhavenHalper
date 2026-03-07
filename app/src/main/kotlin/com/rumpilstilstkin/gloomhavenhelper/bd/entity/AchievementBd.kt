package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AchievementBd(
    @PrimaryKey(autoGenerate = true) val achievementId: Int = 0,
    val name: String,
    val pack: String,
    val maxRang: Int = 1,
    val isGlobal: Boolean,
)
