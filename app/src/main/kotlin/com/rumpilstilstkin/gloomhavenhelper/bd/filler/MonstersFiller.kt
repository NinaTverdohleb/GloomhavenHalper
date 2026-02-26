package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.MonsterDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterAbilityCardBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterStatsBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction.Action
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction.Text
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType.*

object MonstersFiller {
    suspend fun fill_v1(monsterDao: MonsterDao) {
        fillMonsters(monsterDao)
        fillAbilityDecks(monsterDao)
    }

    private suspend fun fillMonsters(monsterDao: MonsterDao) {
        val bossId = monsterDao.insertMonster(
            MonsterBd(
                name = "Главарь разбойников",
                deckName = "boss",
                isBoss = true,
                immunity = listOf(STUN, IMMOBILIZE, CURSE)
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(bossId, 0, false, 8, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 1, false, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 2, false, 12, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 3, false, 13, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 4, false, 15, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 5, false, 16, listOf(Action(MOVE, "5"), Action(ATTACK, "5"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 6, false, 19, listOf(Action(MOVE, "5"), Action(ATTACK, "5"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
            MonsterStatsBd(bossId, 7, false, 23, listOf(Action(MOVE, "5"), Action(ATTACK, "5"), Text("Перемещается к двери и открывает комнату"), Text("Призывает Ожившие кости"))),
        )

        val livingBonesId = monsterDao.insertMonster(
            MonsterBd(
                name = "Ожившие кости",
                deckName = "living-bones",
                isBoss = false)

        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(livingBonesId, 0, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "1"), Action(TARGET, "2"))),
            MonsterStatsBd(livingBonesId, 0, true, 6, listOf(Action(MOVE, "4"), Action(ATTACK, "2"), Action(TARGET, "2"))),
            MonsterStatsBd(livingBonesId, 1, false, 5, listOf(Action(MOVE, "3"), Action(ATTACK, "1"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 1, true, 6, listOf(Action(MOVE, "4"), Action(ATTACK, "2"), Action(TARGET, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 2, false, 5, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 2, true, 7, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(TARGET, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 3, false, 7, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 3, true, 10, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(TARGET, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 4, false, 7, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 4, true, 11, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Action(TARGET, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 5, false, 9, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 5, true, 11, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Action(TARGET, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(livingBonesId, 6, false, 10, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 6, true, 11, listOf(Action(MOVE, "6"), Action(ATTACK, "4"), Action(TARGET, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(livingBonesId, 7, false, 13, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(TARGET, "2"), Action(SHIELD, "1"))),
            MonsterStatsBd(livingBonesId, 7, true, 14, listOf(Action(MOVE, "6"), Action(ATTACK, "4"), Action(TARGET, "3"), Action(SHIELD, "2"))),
        )

        val guardId = monsterDao.insertMonster(
            MonsterBd(
                name = "Разбойник-страж",
                deckName = "guard",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(guardId, 0, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),
            MonsterStatsBd(guardId, 0, true, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "3"))),
            MonsterStatsBd(guardId, 1, false, 6, listOf(Action(MOVE, "3"), Action(ATTACK, "2"))),
            MonsterStatsBd(guardId, 1, true, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(guardId, 2, false, 6, listOf(Action(MOVE, "3"), Action(ATTACK, "3"))),
            MonsterStatsBd(guardId, 2, true, 10, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(SHIELD, "1"))),
            MonsterStatsBd(guardId, 3, false, 9, listOf(Action(MOVE, "3"), Action(ATTACK, "3"))),
            MonsterStatsBd(guardId, 3, true, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(SHIELD, "2"))),
            MonsterStatsBd(guardId, 4, false, 10, listOf(Action(MOVE, "4"), Action(ATTACK, "3"))),
            MonsterStatsBd(guardId, 4, true, 11, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(SHIELD, "2"), Action(MUDDLE, ""))),
            MonsterStatsBd(guardId, 5, false, 11, listOf(Action(MOVE, "4"), Action(ATTACK, "4"))),
            MonsterStatsBd(guardId, 5, true, 12, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(SHIELD, "2"), Action(MUDDLE, ""))),
            MonsterStatsBd(guardId, 6, false, 14, listOf(Action(MOVE, "4"), Action(ATTACK, "4"))),
            MonsterStatsBd(guardId, 6, true, 14, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(SHIELD, "2"), Action(MUDDLE, ""))),
            MonsterStatsBd(guardId, 7, false, 16, listOf(Action(MOVE, "5"), Action(ATTACK, "4"))),
            MonsterStatsBd(guardId, 7, true, 14, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(SHIELD, "3"), Action(MUDDLE, ""))),
        )

        val archerId = monsterDao.insertMonster(
            MonsterBd(
                name = "Разбойник-лучница",
                deckName = "archer",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(archerId, 0, false, 4, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(archerId, 0, true, 6, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "3"))),
            MonsterStatsBd(archerId, 1, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "4"))),
            MonsterStatsBd(archerId, 1, true, 7, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 2, false, 6, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(RANGE, "4"))),
            MonsterStatsBd(archerId, 2, true, 9, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 3, false, 6, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "4"))),
            MonsterStatsBd(archerId, 3, true, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 4, false, 8, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 4, true, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "6"), Action(POISON, ""))),
            MonsterStatsBd(archerId, 5, false, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 5, true, 12, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Action(RANGE, "6"), Action(POISON, ""))),
            MonsterStatsBd(archerId, 6, false, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 6, true, 13, listOf(Action(MOVE, "4"), Action(ATTACK, "5"), Action(RANGE, "6"), Action(POISON, ""))),
            MonsterStatsBd(archerId, 7, false, 13, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "5"))),
            MonsterStatsBd(archerId, 7, true, 17, listOf(Action(MOVE, "4"), Action(ATTACK, "5"), Action(RANGE, "6"), Action(POISON, ""))),
        )

        val livingCorpseId = monsterDao.insertMonster(
            MonsterBd(
                name = "Оживший труп",
                deckName = "living-corpse",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(livingCorpseId, 0, false, 5, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(livingCorpseId, 0, true, 10, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(livingCorpseId, 1, false, 7, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(livingCorpseId, 1, true, 10, listOf(Action(MOVE, "1"), Action(ATTACK, "4"))),
            MonsterStatsBd(livingCorpseId, 2, false, 9, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(livingCorpseId, 2, true, 13, listOf(Action(MOVE, "1"), Action(ATTACK, "4"))),
            MonsterStatsBd(livingCorpseId, 3, false, 10, listOf(Action(MOVE, "1"), Action(ATTACK, "4"))),
            MonsterStatsBd(livingCorpseId, 3, true, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "5"))),
            MonsterStatsBd(livingCorpseId, 4, false, 11, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),
            MonsterStatsBd(livingCorpseId, 4, true, 15, listOf(Action(MOVE, "2"), Action(ATTACK, "5"), Action(POISON, ""))),
            MonsterStatsBd(livingCorpseId, 5, false, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),
            MonsterStatsBd(livingCorpseId, 5, true, 17, listOf(Action(MOVE, "2"), Action(ATTACK, "6"), Action(POISON, ""))),
            MonsterStatsBd(livingCorpseId, 6, false, 14, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(POISON, ""))),
            MonsterStatsBd(livingCorpseId, 6, true, 21, listOf(Action(MOVE, "2"), Action(ATTACK, "6"), Action(POISON, ""))),
            MonsterStatsBd(livingCorpseId, 7, false, 15, listOf(Action(MOVE, "2"), Action(ATTACK, "5"), Action(POISON, ""))),
            MonsterStatsBd(livingCorpseId, 7, true, 25, listOf(Action(MOVE, "2"), Action(ATTACK, "6"), Action(POISON, ""))),
        )

        val inoxGuardId = monsterDao.insertMonster(
            MonsterBd(
                name = "Инокс-стражница",
                deckName = "guard",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(inoxGuardId, 0, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),
            MonsterStatsBd(inoxGuardId, 0, true, 9, listOf(Action(MOVE, "1"), Action(ATTACK, "3"), Action(RETALIATE, "1"))),

            MonsterStatsBd(inoxGuardId, 1, false, 8, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),
            MonsterStatsBd(inoxGuardId, 1, true, 10, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RETALIATE, "2"))),

            MonsterStatsBd(inoxGuardId, 2, false, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "3"))),
            MonsterStatsBd(inoxGuardId, 2, true, 12, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(RETALIATE, "2"))),

            MonsterStatsBd(inoxGuardId, 3, false, 11, listOf(Action(MOVE, "3"), Action(ATTACK, "3"))),
            MonsterStatsBd(inoxGuardId, 3, true, 15, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(RETALIATE, "3"))),

            MonsterStatsBd(inoxGuardId, 4, false, 12, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RETALIATE, "1"))),
            MonsterStatsBd(inoxGuardId, 4, true, 17, listOf(Action(MOVE, "2"), Action(ATTACK, "5"), Action(RETALIATE, "3"))),

            MonsterStatsBd(inoxGuardId, 5, false, 13, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RETALIATE, "1"))),
            MonsterStatsBd(inoxGuardId, 5, true, 19, listOf(Action(MOVE, "2"), Action(ATTACK, "5"), Action(RETALIATE, "4"))),

            MonsterStatsBd(inoxGuardId, 6, false, 16, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RETALIATE, "1"))),
            MonsterStatsBd(inoxGuardId, 6, true, 21, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(RETALIATE, "4"))),

            MonsterStatsBd(inoxGuardId, 7, false, 19, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RETALIATE, "2"))),
            MonsterStatsBd(inoxGuardId, 7, true, 23, listOf(Action(MOVE, "3"), Action(ATTACK, "6"), Action(RETALIATE, "4"))),
        )

        val inoxArcherId = monsterDao.insertMonster(
            MonsterBd(
                name = "Инокс-лучник",
                deckName = "archer",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(inoxArcherId, 0, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "2"))),
            MonsterStatsBd(inoxArcherId, 0, true, 7, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "3"))),

            MonsterStatsBd(inoxArcherId, 1, false, 6, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxArcherId, 1, true, 8, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxArcherId, 2, false, 8, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxArcherId, 2, true, 11, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxArcherId, 3, false, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxArcherId, 3, true, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxArcherId, 4, false, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxArcherId, 4, true, 14, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(WOUND, ""))),

            MonsterStatsBd(inoxArcherId, 5, false, 12, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxArcherId, 5, true, 17, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "5"), Action(WOUND, ""))),

            MonsterStatsBd(inoxArcherId, 6, false, 12, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(WOUND, ""))),
            MonsterStatsBd(inoxArcherId, 6, true, 19, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(RANGE, "5"), Action(WOUND, ""))),

            MonsterStatsBd(inoxArcherId, 7, false, 15, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(WOUND, ""))),
            MonsterStatsBd(inoxArcherId, 7, true, 23, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(RANGE, "5"), Action(WOUND, ""))),
        )

        val inoxShamanId = monsterDao.insertMonster(
            MonsterBd(
                name = "Инокс-шаман",
                deckName = "shaman",
                isBoss = false
            )
        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(inoxShamanId, 0, false, 4, listOf(Action(MOVE, "1"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxShamanId, 0, true, 6, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "3"))),

            MonsterStatsBd(inoxShamanId, 1, false, 6, listOf(Action(MOVE, "1"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxShamanId, 1, true, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "3"))),

            MonsterStatsBd(inoxShamanId, 2, false, 7, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "3"))),
            MonsterStatsBd(inoxShamanId, 2, true, 11, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "3"))),

            MonsterStatsBd(inoxShamanId, 3, false, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "2"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxShamanId, 3, true, 14, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxShamanId, 4, false, 10, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxShamanId, 4, true, 16, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxShamanId, 5, false, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "3"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxShamanId, 5, true, 20, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxShamanId, 6, false, 15, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxShamanId, 6, true, 24, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Action(RANGE, "4"))),

            MonsterStatsBd(inoxShamanId, 7, false, 16, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(RANGE, "4"))),
            MonsterStatsBd(inoxShamanId, 7, true, 27, listOf(Action(MOVE, "4"), Action(ATTACK, "5"), Action(RANGE, "4"))),
        )

        val cultistId = monsterDao.insertMonster(
            MonsterBd(
                name = "Кульист",
                deckName = "cultist",
                isBoss = false
            )

        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(cultistId, 0, false, 4, listOf(Action(MOVE, "2"), Action(ATTACK, "1"))),
            MonsterStatsBd(cultistId, 0, true, 7, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),

            MonsterStatsBd(cultistId, 1, false, 5, listOf(Action(MOVE, "2"), Action(ATTACK, "1"))),
            MonsterStatsBd(cultistId, 1, true, 9, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),

            MonsterStatsBd(cultistId, 2, false, 7, listOf(Action(MOVE, "2"), Action(ATTACK, "1"))),
            MonsterStatsBd(cultistId, 2, true, 12, listOf(Action(MOVE, "2"), Action(ATTACK, "2"))),

            MonsterStatsBd(cultistId, 3, false, 9, listOf(Action(MOVE, "3"), Action(ATTACK, "1"))),
            MonsterStatsBd(cultistId, 3, true, 13, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(CURSE, ""))),

            MonsterStatsBd(cultistId, 4, false, 10, listOf(Action(MOVE, "3"), Action(ATTACK, "2"))),
            MonsterStatsBd(cultistId, 4, true, 15, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(CURSE, ""))),

            MonsterStatsBd(cultistId, 5, false, 11, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(CURSE, ""))),
            MonsterStatsBd(cultistId, 5, true, 18, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(CURSE, ""))),

            MonsterStatsBd(cultistId, 6, false, 14, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(CURSE, ""))),
            MonsterStatsBd(cultistId, 6, true, 22, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(CURSE, ""))),

            MonsterStatsBd(cultistId, 7, false, 15, listOf(Action(MOVE, "3"), Action(ATTACK, "3"), Action(CURSE, ""))),
            MonsterStatsBd(cultistId, 7, true, 25, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(CURSE, ""))),
        )

        val earthDemonId = monsterDao.insertMonster(
            MonsterBd(
                name = "Земляной демон",
                deckName = "earth-demon",
                isBoss = false
            )

        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(earthDemonId, 0, false, 7, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(earthDemonId, 0, true, 10, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),

            MonsterStatsBd(earthDemonId, 1, false, 9, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(earthDemonId, 1, true, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),

            MonsterStatsBd(earthDemonId, 2, false, 12, listOf(Action(MOVE, "1"), Action(ATTACK, "3"))),
            MonsterStatsBd(earthDemonId, 2, true, 18, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),

            MonsterStatsBd(earthDemonId, 3, false, 13, listOf(Action(MOVE, "2"), Action(ATTACK, "3"))),
            MonsterStatsBd(earthDemonId, 3, true, 20, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(IMMOBILIZE, ""))),

            MonsterStatsBd(earthDemonId, 4, false, 15, listOf(Action(MOVE, "2"), Action(ATTACK, "4"))),
            MonsterStatsBd(earthDemonId, 4, true, 21, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(IMMOBILIZE, ""))),

            MonsterStatsBd(earthDemonId, 5, false, 17, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(IMMOBILIZE, ""))),
            MonsterStatsBd(earthDemonId, 5, true, 25, listOf(Action(MOVE, "3"), Action(ATTACK, "5"), Action(IMMOBILIZE, ""))),

            MonsterStatsBd(earthDemonId, 6, false, 20, listOf(Action(MOVE, "2"), Action(ATTACK, "4"), Action(IMMOBILIZE, ""))),
            MonsterStatsBd(earthDemonId, 6, true, 27, listOf(Action(MOVE, "3"), Action(ATTACK, "6"), Action(IMMOBILIZE, ""))),

            MonsterStatsBd(earthDemonId, 7, false, 22, listOf(Action(MOVE, "3"), Action(ATTACK, "4"), Action(IMMOBILIZE, ""))),
            MonsterStatsBd(earthDemonId, 7, true, 32, listOf(Action(MOVE, "3"), Action(ATTACK, "6"), Action(IMMOBILIZE, ""))),
        )


        val airDemonId = monsterDao.insertMonster(
            MonsterBd(
                name = "Воздушный демон",
                deckName = "wind-demon",
                isBoss = false,
                fly = true,
            )

        ).toInt()
        monsterDao.insertAllStats(
            MonsterStatsBd(airDemonId, 0, false, 3, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(RANGE, "3"), Action(SHIELD, "1"))),
            MonsterStatsBd(airDemonId, 0, true, 5, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "4"), Action(SHIELD, "1"))),

            MonsterStatsBd(airDemonId, 1, false, 3, listOf(Action(MOVE, "3"), Action(ATTACK, "2"), Action(RANGE, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(airDemonId, 1, true, 5, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "4"), Action(SHIELD, "2"))),

            MonsterStatsBd(airDemonId, 2, false, 4, listOf(Action(MOVE, "4"), Action(ATTACK, "2"), Action(RANGE, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(airDemonId, 2, true, 7, listOf(Action(MOVE, "5"), Action(ATTACK, "3"), Action(RANGE, "4"), Action(SHIELD, "2"))),

            MonsterStatsBd(airDemonId, 3, false, 5, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(airDemonId, 3, true, 8, listOf(Action(MOVE, "5"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(SHIELD, "2"))),

            MonsterStatsBd(airDemonId, 4, false, 7, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "3"), Action(SHIELD, "2"))),
            MonsterStatsBd(airDemonId, 4, true, 8, listOf(Action(MOVE, "5"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(SHIELD, "2"), Action(DISARM, ""))),

            MonsterStatsBd(airDemonId, 5, false, 9, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "4"), Action(SHIELD, "2"))),
            MonsterStatsBd(airDemonId, 5, true, 11, listOf(Action(MOVE, "5"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(SHIELD, "2"), Action(DISARM, ""))),

            MonsterStatsBd(airDemonId, 6, false, 10, listOf(Action(MOVE, "4"), Action(ATTACK, "3"), Action(RANGE, "4"), Action(SHIELD, "3"))),
            MonsterStatsBd(airDemonId, 6, true, 12, listOf(Action(MOVE, "5"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(SHIELD, "3"), Action(DISARM, ""))),

            MonsterStatsBd(airDemonId, 7, false, 11, listOf(Action(MOVE, "4"), Action(ATTACK, "4"), Action(RANGE, "4"), Action(SHIELD, "3"))),
            MonsterStatsBd(airDemonId, 7, true, 13, listOf(Action(MOVE, "5"), Action(ATTACK, "5"), Action(RANGE, "4"), Action(SHIELD, "3"), Action(DISARM, ""))),
        )
    }

    private suspend fun fillAbilityDecks(monsterDao: MonsterDao) {
        // Boss deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "boss", initiative = 11, actions = listOf(Text("Способность 2"))),
            MonsterAbilityCardBd(deckName = "boss", initiative = 14, actions = listOf(Text("Способность 2"))),
            MonsterAbilityCardBd(deckName = "boss", initiative = 17, actions = listOf(Text("Способность 2")), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "boss", initiative = 85, actions = listOf(Text("Способность 1")), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "boss", initiative = 79, actions = listOf(Text("Способность 1"))),
            MonsterAbilityCardBd(deckName = "boss", initiative = 73, actions = listOf(Text("Способность 1"))),
            MonsterAbilityCardBd(deckName = "boss", initiative = 36, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "boss", initiative = 52, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "-1", listOf(Action(RANGE, "3"), Action(TARGET, "2")))
            )),
        )

        // living-bones deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 64, actions = listOf(Action(MOVE, "-1"), Action(ATTACK, "+1"))),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 20, actions = listOf(
                Action(MOVE, "-2"),
                Action(ATTACK, "+0"),
                Action(HEAL, "2", listOf(Text("На себя")))
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 25, actions = listOf(Action(MOVE, "+1"), Action(ATTACK, "-1"))),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 45, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 45, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 74, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0", listOf(Text("Все атаки в одну цель")))
            )),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 81, actions = listOf(Action(ATTACK, "+2"))),
            MonsterAbilityCardBd(deckName = "living-bones", initiative = 12, actions = listOf(
                Action(SHIELD, "1"),
                Action(HEAL, "2", listOf(Text("На себя")))
            ), needsShuffle = true),
        )

        // guard deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "guard", initiative = 15, actions = listOf(
                Action(SHIELD, "1"),
                Action(RETALIATE, "2")
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "guard", initiative = 30, actions = listOf(Action(MOVE, "+1"), Action(ATTACK, "-1"))),
            MonsterAbilityCardBd(deckName = "guard", initiative = 35, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+0", listOf(Action(RANGE, "2")))
            )),
            MonsterAbilityCardBd(deckName = "guard", initiative = 50, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "guard", initiative = 50, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "guard", initiative = 70, actions = listOf(Action(MOVE, "+1"), Action(ATTACK, "+1"))),
            MonsterAbilityCardBd(deckName = "guard", initiative = 55, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+0"),
                Action(STRENGTHEN, "", listOf(Text("На себя")))
            )),
            MonsterAbilityCardBd(deckName = "guard", initiative = 15, actions = listOf(
                Action(SHIELD, "1"),
                Action(ATTACK, "+0", listOf(Action(POISON, "")))
            ), needsShuffle = true),
        )

        // archer deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "archer", initiative = 16, actions = listOf(Action(MOVE, "+1"), Action(ATTACK, "-1"))),
            MonsterAbilityCardBd(deckName = "archer", initiative = 31, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0"))),
            MonsterAbilityCardBd(deckName = "archer", initiative = 32, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+1", listOf(Action(RANGE, "-1")))
            )),
            MonsterAbilityCardBd(deckName = "archer", initiative = 44, actions = listOf(Action(MOVE, "-1"), Action(ATTACK, "+1"))),
            MonsterAbilityCardBd(deckName = "archer", initiative = 56, actions = listOf(
                Action(ATTACK, "-1", listOf(Action(TARGET, "2")))
            )),
            MonsterAbilityCardBd(deckName = "archer", initiative = 68, actions = listOf(
                Action(ATTACK, "+1", listOf(Action(RANGE, "+1")))
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "archer", initiative = 14, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "-1", listOf(Text("Создает ловушку на 3 урона в ближайшей к врагу области")))
            )),
            MonsterAbilityCardBd(deckName = "archer", initiative = 29, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "-1", listOf(Action(RANGE, "+1"), Action(IMMOBILIZE, "")))
            ), needsShuffle = true),
        )

        // living-corpse deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 21, actions = listOf(
                Action(MOVE, "+1"),
                Action(IMMOBILIZE, ""),
                Action(MUDDLE, ""),
                Text("Цель один враг")
            )),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 47, actions = listOf(Action(MOVE, "+1"), Action(ATTACK, "-1"))),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 66, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0")), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 66, actions = listOf(Action(MOVE, "+0"), Action(ATTACK, "+0")), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 82, actions = listOf(Action(MOVE, "-1"), Action(ATTACK, "+1"))),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 91, actions = listOf(
                Action(MOVE, "+1"),
                Text("Зомби получает 1 урон")
            )),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 71, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+1"),
                Action(POISON, "", listOf(Text("Отравляет всех соседних врагов")))
            )),
            MonsterAbilityCardBd(deckName = "living-corpse", initiative = 32, actions = listOf(
                Action(ATTACK, "+2", listOf(Action(PUSH, "1"))),
                Text("Зомби получает 1 урон")
            )),
        )

        // shaman deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "shaman", initiative = 8, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "-1", subAction = listOf(Action(DISARM, "")))
            )),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 8, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+0", subAction = listOf(Action(IMMOBILIZE, "")))
            )),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 23, actions = listOf(
                Action(MOVE, "+0"),
                Action(HEAL, "3", listOf(Action(RANGE, "3")))
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 23, actions = listOf(
                Action(MOVE, "+0"),
                Action(HEAL, "3", listOf(Action(RANGE, "3")))
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 62, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0"))
            ),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 74, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+1")
            )),

            MonsterAbilityCardBd(deckName = "shaman", initiative = 89, actions = listOf(
                Action(MOVE, "-1"),
                Action(HEAL, "1", listOf(Text("Все рядомстоязие союзники"))),
                Action(BLESS, "", listOf(Text("Себя")))
            )),
            MonsterAbilityCardBd(deckName = "shaman", initiative = 9, actions = listOf(
                Action(MOVE, "+1"),
                Action(ATTACK, "-1", listOf(Action(CURSE, ""), Action(TARGET, "2")))
            ))
        )

        // cultist deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "cultist", initiative = 10, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "-1"),
                Text(content = "При смерти:", subAction = listOf(Text("#27"), Action(ATTACK, "+2")))
            )),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 10, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "-1"),
                Text(content = "При смерти:", subAction = listOf(Text("#27"), Action(ATTACK, "+2")))
            )),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 27, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0"),
            )),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 27, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0"),
            )),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 39, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+0"),
                Action(HEAL, "1", subAction = listOf(Text("Себя")))
            )),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 63, actions = listOf(
                Text("Призывает ожившие кости"),
                Text("Культист получает 2 повреждения"),
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 63, actions = listOf(
                Text("Призывает ожившие кости"),
                Text("Культист получает 2 повреждения"),
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "cultist", initiative = 9, actions = listOf(
                Action(MOVE, "-1"),
                Action(HEAL, "3", listOf(Action(RANGE, "3")))
            ))
        )

        // earth-demon deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 40, actions = listOf(
                Action(HEAL, "3", subAction = listOf(Text("Себя"))),
                Text("#33", subAction = listOf(Action(IMMOBILIZE, ""), Action(RANGE, "3")))
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 42, actions = listOf(
                Action(MOVE, "+1"),
                Action(ATTACK, "-1"),
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 62, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0"),
                Text("#23")
            )),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 71, actions = listOf(
                Action(ATTACK, "+0", subAction = listOf(Action(RANGE, "4"))),
                Text("#33", subAction = listOf(Action(TARGET, "2")))
            )),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 83, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+1"),
                Text("#23")
            )),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 93, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "-1", subAction = listOf(Text("Цели все соседние враги"))),
                Text("#33", subAction = listOf(Action(PUSH, "1")))
            )),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 79, actions = listOf(
                Action(MOVE, "+1"),
                Action(ATTACK, "+0"),
                Text("#31", subAction = listOf(Action(ATTACK, "-2")))
            )),
            MonsterAbilityCardBd(deckName = "earth-demon", initiative = 87, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "-1", listOf(Text("#35"))),
                Text("#34: #23")
            ))
        )

        // wind-demon deck
        monsterDao.insertCards(
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 9, actions = listOf(
                Action(ATTACK, "-1"),
                Action(HEAL, "1", subAction = listOf(Text("Себя"))),
                Text("#31", subAction = listOf(Action(INVISIBLE, "Себя")))
            )),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 21, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0", subAction = listOf(Action(PULL,"1"))),
                Text("#21")
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 21, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0", subAction = listOf(Action(PULL,"1"))),
                Text("#21")
            ), needsShuffle = true),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 29, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "-1", subAction = listOf(Action(TARGET, "2"))),
                Text("#31", subAction = listOf(Action(PUSH, "2")))
            )),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 37, actions = listOf(
                Action(MOVE, "+0"),
                Action(ATTACK, "+0", subAction = listOf(Text("#35"))),
                Text("#31", subAction = listOf(Action(ATTACK, "+1"),Text("#36")))
            )),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 43, actions = listOf(
                Action(MOVE, "-1"),
                Action(ATTACK, "+1"),
                Text("#31", subAction = listOf(Action(TARGET, "2")))
            )),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 43, actions = listOf(
                Action(PUSH, "1", subAction = listOf(Text("Цели все соседние враги"))),
                Action(ATTACK, "+0"),
                Text("#33", subAction = listOf(Action(RANGE, "-2")))
            )),
            MonsterAbilityCardBd(deckName = "wind-demon", initiative = 2, actions = listOf(
                Action(SHIELD, "1"),
                Action(MOVE, "-1"),
                Action(ATTACK, "-1"),
                Text("#33: #21"),
            ))
        )
    }
}
