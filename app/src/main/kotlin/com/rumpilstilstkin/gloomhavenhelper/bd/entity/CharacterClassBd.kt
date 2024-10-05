package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CharacterClassBd(
    @ColumnInfo(name = "name") val name: String,
    @PrimaryKey
    @ColumnInfo(name = "characterType") val characterType: String
)