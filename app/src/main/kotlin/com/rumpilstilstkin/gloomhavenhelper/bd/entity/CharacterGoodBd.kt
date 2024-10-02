package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey
import androidx.room.Relation

@Entity(foreignKeys = [
    ForeignKey(
        entity = CharacterBd::class,
        parentColumns = arrayOf("characterId"),
        childColumns = arrayOf("characterId"),
        onDelete = CASCADE
    ),
    ForeignKey(
        entity = GoodBd::class,
        parentColumns = arrayOf("goodId"),
        childColumns = arrayOf("goodId"),
        onDelete = CASCADE
    )
],
    indices = [
        Index("characterId"),
        Index("goodId"),
    ]
)
data class CharacterGoodBd(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val characterId: Int,
    val goodId: Int,
)

data class CharacterGoodDetailsBd(
    @Embedded val characterGood: CharacterGoodBd,
    @Relation(
        parentColumn = "goodId",
        entityColumn = "goodId"
    )
    val good: GoodBd
)