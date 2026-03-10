package com.rumpilstilstkin.gloomhavenhelper.navigation.navtypes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.Monster
import kotlinx.serialization.json.Json

val MonsterListType = object : NavType<List<Monster>>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): List<Monster>? {
        return bundle.getString(key)?.let { Json.decodeFromString(it) }
    }

    override fun parseValue(value: String): List<Monster> {
        return Json.decodeFromString(Uri.decode(value))
    }

    override fun put(bundle: Bundle, key: String, value: List<Monster>) {
        bundle.putString(key, Json.encodeToString(value))
    }

    override fun serializeAsValue(value: List<Monster>): String {
        return Uri.encode(Json.encodeToString(value))
    }
}