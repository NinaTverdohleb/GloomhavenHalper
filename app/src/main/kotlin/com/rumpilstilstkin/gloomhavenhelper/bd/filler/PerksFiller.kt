package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.PerksDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.PerkBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

object PerksFiller {
    suspend fun fill_v1(
        perksDao: PerksDao
    ) {
        addBrutePerks(perksDao)
        addMindthiefPerks(perksDao)
        addCragheartPerks(perksDao)
        addScoundrelPerks(perksDao)
        addSpellweaverPerks(perksDao)
        addTinkererPerks(perksDao)
        addBeastTyrantPerks(perksDao)
        addElementalistPerks(perksDao)
        addSummonerPerks(perksDao)
        addSunkeeperPerks(perksDao)
        addDoomstalkerPerks(perksDao)
        addSoothsingerPerks(perksDao)
        addSawbonesPerks(perksDao)
        addPlagueheraldPerks(perksDao)
        addNightshroudPerks(perksDao)
        addQuartermasterPerks(perksDao)
        addDivinerPerks(perksDao)
        addBerserkerPerks(perksDao)
    }

    private suspend fun addBrutePerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #05",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 ОТТОЛКНУТЬ #08 1\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 ОТТОЛКНУТЬ #08 1\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОБОЙ #09 3\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 РАЗОРУЖЕНИЕ #11\" и 1 карту с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"Щит 1 (на себя)\"",
                characterType = CharacterClassType.Brute.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты предметов и добавьте 1 карту #03",
                characterType = CharacterClassType.Brute.name
            )
        )
    }

    private suspend fun addCragheartPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #02 и 2 карты #04",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 с эффектом \"СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 с эффектом \"СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 2 карты эффектом \"#07 ОТТОЛКНУТЬ #08 2\"",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #23",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #23",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #21",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты предметов",
                characterType = CharacterClassType.Cragheart.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Cragheart.name
            )
        )
    }

    private suspend fun addScoundrelPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #02 на 1 карту #15",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОБОЙ #09 3\"",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 НЕВИДИМОСТЬ #24\"",
                characterType = CharacterClassType.Scoundrel.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Scoundrel.name
            )
        )
    }

    private suspend fun addMindthiefPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #03 на 2 карты #04",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #02 на 1 карту #15",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #16",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #16",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 3 карты c эффектом \"#07 ПРИТЯНУТЬ #17 1\"",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 3 карты c эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 2 карты c эффектом \"#07 ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 1 карту c эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Добавьте 1 карту c эффектом \"#07 РАЗОРУЖЕНИЕ #11\" и 1 карту c эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Mindthief.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Mindthief.name
            ),
        )
    }

    private suspend fun addSpellweaverPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #22",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #22",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #16",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #16",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #23 и 1 карту #07 #21",
                characterType = CharacterClassType.Spellweaver.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #19 и 1 карту #07 #20",
                characterType = CharacterClassType.Spellweaver.name
            )
        )
    }

    private suspend fun addTinkererPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #02 на 1 карту #15",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #05",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #22",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"Лечение 2\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"Лечение 2\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Tinkerer.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Tinkerer.name
            ),
        )
    }

    private suspend fun addBeastTyrantPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #23",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.BeastTyrant.name
            ),
        )
    }

    private suspend fun addElementalistPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 3 карты #15 #22",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 3 карты #15 #16",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 3 карты #15 #21",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 3 карты #15 #23",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #15 на 1 карту #15 #22 и 1 карту #15 #23",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #15 на 1 карту #15 #16 и 1 карту #15 #21",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03 с эффектом \"ОТТОЛКНУТЬ #08 1\"",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Elementalist.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Elementalist.name
            ),
        )
    }

    private suspend fun addSummonerPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Поменяйте 1 кару #02 на 1 карту #15",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 РАНА #14\"",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #22 и 1 карту #07 #21",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #20 и 1 карту #07 #23",
                characterType = CharacterClassType.Summoner.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев и добавьте 2 карты #03",
                characterType = CharacterClassType.Summoner.name
            )
        )
    }

    private suspend fun addSunkeeperPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #02 на 1 карту #15",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #19",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #19",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Щит 1 (на себя)\"",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты предметов и добавьте 2 карты #03",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Sunkeeper.name
            )
        )
    }

    private suspend fun addDoomstalkerPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #15 на 2 карты #03",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #15 на 2 карты #03",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #15 на 2 карты #03",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 с эффектом \"СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Doomstalker.name
            ),
            PerkBd(
                text = "Игнорирйте отрицательные эффекты сценариев",
                characterType = CharacterClassType.Doomstalker.name
            ),
        )
    }

    private suspend fun addSoothsingerPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Уберите 1 карту #02",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #03 на 1 карту #06",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #03 на 1 карту #06",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #03 с эффектом \"РАЗОРУЖЕНИЕ #11\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 с эффектом \"РАНА #14\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 с эффектом \"ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 с эффектом \"ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #05 с эффектом \"СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #15 с эффектом \"ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Добавтье 3 карты #07 #03",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Добавтье 2 карты с эффектом \"#07 ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Soothsinger.name
            ),
            PerkBd(
                text = "Добавтье 2 карты с эффектом \"#07 ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Soothsinger.name
            )
        )
    }

    private suspend fun addSawbonesPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #04",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #07 #04",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 РАНА #14\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 РАНА #14\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 Лечение 3\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 Лечение 3\"",
                characterType = CharacterClassType.Sawbones.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"Разверните 1 повернутую или потраченную карту предмета\"",
                characterType = CharacterClassType.Sawbones.name
            )
        )
    }

    private suspend fun addPlagueheraldPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Поменяйте 1 карту #02 на 1 карту #15",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #03",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 #21",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 #21",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 #21",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 ОТРАВЛЕНИЕ #25\"",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПАРАЛИЧ #18\"",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Plagueherald.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев и добавьте 1 карту #03",
                characterType = CharacterClassType.Plagueherald.name
            )
        )
    }

    private suspend fun addNightshroudPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #01 #20",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #01 #20",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 #20 на 1 карту #03 #20",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 #20 на 1 карту #03 #20",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"НЕВИДИМОСТЬ #24\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"НЕВИДИМОСТЬ #24\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Nightshroud.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев и добавьте 2 карты #03",
                characterType = CharacterClassType.Nightshroud.name
            )
        )
    }

    private suspend fun addQuartermasterPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 2 карты #07 #03",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 3 карты с эффектом \"#07 СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОБОЙ #09 3\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ДОБАВИТЬ ЦЕЛЬ #13\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"Разверните 1 повернутую или потраченную карту предмета\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"Разверните 1 повернутую или потраченную карту предмета\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #15 с эффектом \"Разверните 1 повернутую или потраченную карту предмета\"",
                characterType = CharacterClassType.Quartermaster.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев и добавьте 2 карты #03",
                characterType = CharacterClassType.Quartermaster.name
            )
        )
    }

    private suspend fun addDivinerPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Уберите 1 карту #02",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #03 на 1 карту #05 с эффектом \"Щит 1 (на себя)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 2 карты #03 на 1 карту #05 с эффектом \"Щит 1 (на себя)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #03 с эффектом \"Щит 1 (на любого союзника)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 #20",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 #19",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #05 с эффектом \"СМЯТЕНИЕ #12\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 с эффектом \"ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #04 с эффектом \"РЕГЕНИРАЦИЯ (на себя)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03 с эффектом \"Лечение 2 (на любого союзника)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1 (на себя)\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 ПРОКЛЯТЬЕ #26\"",
                characterType = CharacterClassType.Diviner.name
            ),
            PerkBd(
                text = "Игнорируйте отрицательные эффекты сценариев и добавьте 2 карты #03",
                characterType = CharacterClassType.Diviner.name
            )
        )
    }

    private suspend fun addBerserkerPerks(
        perksDao: PerksDao
    ) {
        perksDao.insertAll(
            PerkBd(
                text = "Уберите 2 карты #01",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Уберите 4 карты #15",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #01 на 1 карту #03",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #07 #04",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Поменяйте 1 карту #15 на 1 карту #07 #04",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 РАНА #14\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 РАНА #14\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту с эффектом \"#07 ОГЛУШЕНИЕ #10\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #03 с эффектом \"#07 ОРАЗОРУЖЕНИЕ #11\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 2 карты с эффектом \"#07 Лечение 1 (на себя)\"",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #22",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Добавьте 1 карту #04 #22",
                characterType = CharacterClassType.Berserker.name
            ),
            PerkBd(
                text = "Игнорируйте негативные эффекты предметов",
                characterType = CharacterClassType.Berserker.name
            ),
        )
    }
}