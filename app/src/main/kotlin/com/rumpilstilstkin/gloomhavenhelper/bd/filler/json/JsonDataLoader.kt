package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.serialization.json.Json
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class JsonDataLoader @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        classDiscriminator = "kind"
    }

    private inline fun <reified T> load(fileName: String): T {
        val jsonString = context.assets
            .open("data/$fileName")
            .bufferedReader()
            .use { it.readText() }
        return json.decodeFromString(jsonString)
    }

    fun loadAbilityDecks(): List<AbilityDeckJson> = load("ability_decks.json")

    fun loadMonsters(): List<MonsterJson> = load("monsters.json")

    fun loadScenarioMonsters(): List<ScenarioMonstersJson> = load("scenario_monsters.json")
}
