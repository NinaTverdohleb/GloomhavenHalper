package com.rumpilstilstkin.gloomhavenhelper.bd.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.PackType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType

@Entity
data class MonsterBd(
    @PrimaryKey(autoGenerate = true) val monsterId: Int = 0,
    val name: String,
    val deckName: String,
    val isBoss: Boolean,
    val fly: Boolean = false,
    val immunity: List<MonsterStatType> = emptyList(),
    val pack: String = PackType.MAIN.name,
)
