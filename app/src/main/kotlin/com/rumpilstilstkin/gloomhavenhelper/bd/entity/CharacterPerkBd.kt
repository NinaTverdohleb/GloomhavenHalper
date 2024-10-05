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
        entity = PerkBd::class,
        parentColumns = arrayOf("perkId"),
        childColumns = arrayOf("perkId"),
        onDelete = CASCADE
    )
],
    indices = [
        Index("characterId"),
        Index("perkId"),
    ]
)
data class CharacterPerkBd(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val characterId: Int,
    val perkId: Int,
)

data class CharacterPerkDetailsBd(
    @Embedded val characterPerk: CharacterPerkBd,
    @Relation(
        parentColumn = "perkId",
        entityColumn = "perkId"
    )
    val perk: PerkBd
)