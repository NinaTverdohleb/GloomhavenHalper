package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import android.content.SharedPreferences
import androidx.core.content.edit
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GameLevelInfoDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GoodsDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.MonsterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.PerksDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.PersonalQuestDao
import com.rumpilstilstkin.gloomhavenhelper.bd.dao.ScenarioDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterAbilityCardBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterStatsBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.ScenarioMonsterBd
import com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.JsonDataLoader
import javax.inject.Inject

class DatabaseFiller @Inject constructor(
    private val characterClassDao: CharacterClassDao,
    private val gameLevelInfoDao: GameLevelInfoDao,
    private val scenarioDao: ScenarioDao,
    private val preferences: SharedPreferences,
    private val goodsDao: GoodsDao,
    private val perksDao: PerksDao,
    private val personalQuestDao: PersonalQuestDao,
    private val monsterDao: MonsterDao,
    private val jsonDataLoader: JsonDataLoader,
) {
    val version = preferences.getInt(PREFS_VERSION, 0)

    suspend fun fillDatabase() {
        if (characterClassDao.getAll().isEmpty()) {
            startFill()
        }
        if (monsterDao.getAllMonsters().isEmpty()) {
            fillMonsters()
        }
        preferences.edit { putInt(PREFS_VERSION, VERSION) }
    }

    private suspend fun startFill() {
        CharacterClassesFiller.fill_v1(characterClassDao)
        GameLevelInfoFiller.fill_v1(gameLevelInfoDao)
        ScenariosFiller.fill_v1(scenarioDao)
        GoodsFiller.fill_v1(goodsDao)
        PerksFiller.fill_v1(perksDao)
        QuestsFiller.fill_v1(personalQuestDao)
    }

    private suspend fun fillMonsters() {
        // Load and insert ability card decks
        val decks = jsonDataLoader.loadAbilityDecks()
        decks.forEach { deck ->
            deck.cards.forEach { card ->
                monsterDao.insertCard(
                    MonsterAbilityCardBd(
                        deckName = deck.deckName,
                        initiative = card.initiative,
                        actions = card.actions,
                        needsShuffle = card.needsShuffle
                    )
                )
            }
        }

        // Load and insert monsters with their stats
        val monsters = jsonDataLoader.loadMonsters()
        val monsterNameToId = mutableMapOf<String, Int>()

        monsters.forEach { monster ->
            val monsterId = monsterDao.insertMonster(
                MonsterBd(
                    name = monster.name,
                    deckName = monster.deckName
                )
            ).toInt()

            monsterNameToId[monster.name] = monsterId

            monster.stats.forEach { stat ->
                monsterDao.insertStats(
                    MonsterStatsBd(
                        monsterId = monsterId,
                        scenarioLevel = stat.level,
                        isElite = stat.isElite,
                        life = stat.life,
                        stats = stat.stats
                    )
                )
            }
        }

        // Load and insert scenario-monster mappings
        val scenarioMonsters = jsonDataLoader.loadScenarioMonsters()
        scenarioMonsters.forEach { scenario ->
            scenario.monsterNames.forEach { monsterName ->
                val monsterId = monsterNameToId[monsterName]
                if (monsterId != null) {
                    monsterDao.insertScenarioMonster(
                        ScenarioMonsterBd(
                            scenarioNumber = scenario.scenarioNumber,
                            monsterId = monsterId
                        )
                    )
                }
            }
        }
    }

    companion object {
        private const val VERSION = 1
        private const val PREFS_VERSION = "filler_version"
    }
}