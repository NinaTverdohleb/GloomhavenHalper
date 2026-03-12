package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.Relation

@Entity(
    primaryKeys = ["teamId", "goodId"],
    foreignKeys = [
        ForeignKey(
            entity = TeamBd::class,
            parentColumns = arrayOf("teamId"),
            childColumns = arrayOf("teamId"),
            onDelete = CASCADE
        )
    ],
    indices = [
        Index("teamId"),
        Index("goodId"),
    ]
)
data class TeamGoodBd(
    val teamId: Int,
    val goodId: Int,
)

data class TeamGoodBdDetailsBd(
    @Embedded val teamGood: TeamGoodBd,
    @Relation(
        parentColumn = "goodId",
        entityColumn = "goodId"
    )
    val good: GoodBd
)
