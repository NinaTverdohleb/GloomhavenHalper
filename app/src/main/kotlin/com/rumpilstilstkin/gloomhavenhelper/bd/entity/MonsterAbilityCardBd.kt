package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction

@Entity(
    indices = [
        Index("deckName")
    ]
)
data class MonsterAbilityCardBd(
    @PrimaryKey(autoGenerate = true) val cardId: Int = 0,
    val deckName: String,
    val initiative: Int,
    val actions: List<MonsterAction>,
    val needsShuffle: Boolean = false,
)
