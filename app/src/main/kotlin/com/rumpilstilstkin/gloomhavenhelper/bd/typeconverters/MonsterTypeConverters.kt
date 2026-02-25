package com.rumpilstilstkin.gloomhavenhelper.bd.typeconverters

import androidx.room.TypeConverter
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStat
import kotlinx.serialization.json.Json

private val json = Json {
    ignoreUnknownKeys = true
    encodeDefaults = true
}

class MonsterStatsTypeConverter {
    @TypeConverter
    fun fromList(list: List<MonsterStat>): String = json.encodeToString(list)

    @TypeConverter
    fun toList(value: String): List<MonsterStat> = json.decodeFromString(value)
}

class CardActionsTypeConverter {
    @TypeConverter
    fun fromList(list: List<MonsterAction>): String = json.encodeToString(list)

    @TypeConverter
    fun toList(value: String): List<MonsterAction> = json.decodeFromString(value)
}
