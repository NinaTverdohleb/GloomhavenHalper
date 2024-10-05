package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(foreignKeys = [
    ForeignKey(
        entity = CharacterClassBd::class,
        parentColumns = arrayOf("characterType"),
        childColumns = arrayOf("characterType"),
        onDelete = CASCADE
    ),
],
    indices = [
        Index("characterType"),
    ]
)
data class PerkBd(
    @PrimaryKey(autoGenerate = true) val perkId: Int = 0,
    @ColumnInfo(name = "text") val text: String,
    @ColumnInfo(name = "characterType") val characterType: String,
)