package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.PersonalQuestDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.PersonalQuestBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.CharacterTaskItem

object QuestsFiller {

    suspend fun fill_v1(
        dao: PersonalQuestDao
    ) {
        dao.insertAll(
            PersonalQuestBd(
                questId = "510",
                title = "Искатель Ксорна",
                description = "Еше с детства ты слышал зов Ксорна. Когда-то его почитали как бога, но его паства давно уничтожена. Но ты можешь слышать его зов. Ты отправтлся в Глумхевен по его приказу. Ты найдешь нго останки и освободишь его. Случившееся однажды повторится снова.",
                specialText = "",
                characterType = CharacterClassType.Plagueherald.name,
                tasks = listOf(
                    CharacterTaskItem.Count(
                        id = 1,
                        priority = 0,
                        text = "Пройдите три сценария с названием Склеп",
                        count = 3
                    ),
                    CharacterTaskItem.Check(
                        id = 2,
                        priority = 1,
                        text = "Откройте и пройдите полностью сенарий \"Жуткий погреб\"",
                    )
                ),
                isRecyclable = false
            ),
            PersonalQuestBd(
                questId = "511",
                title = "Торговец",
                description = "Деньги это сила, а торговля это правило вашего мира. Вы уверены что если наберете достаточно предметов для открытия собственного магазина то сможете насладлаться полной и беззаботной жизнью. Пусть эти чудаки сами сражаются с опасностью за обедки",
                specialText = "",
                characterType = CharacterClassType.Quartermaster.name,
                tasks = listOf(
                    CharacterTaskItem.Count(
                        id = 1,
                        priority = 0,
                        text = "В инвентаре есть два предмета типа \"Голова\"",
                        count = 2
                    ),
                    CharacterTaskItem.Count(
                        id = 2,
                        priority = 0,
                        text = "В инвентаре есть два предмета типа \"Тело\"",
                        count = 2
                    ),
                    CharacterTaskItem.Count(
                        id = 3,
                        priority = 0,
                        text = "В инвентаре есть два предмета типа \"Ноги\"",
                        count = 2
                    ),
                    CharacterTaskItem.Count(
                        id = 4,
                        priority = 0,
                        text = "В инвентаре есть три предмета типа \"Одноручное\" или \"Двуручное\"",
                        count = 3
                    ),
                    CharacterTaskItem.Count(
                        id = 5,
                        priority = 0,
                        text = "В инвентаре есть четыре предмета типа \"Маленький предмет\"",
                        count = 4
                    ),
                ),
                isRecyclable = false
            )
        )
    }
}