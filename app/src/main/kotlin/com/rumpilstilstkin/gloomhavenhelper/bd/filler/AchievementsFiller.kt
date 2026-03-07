package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.AchievementDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.AchievementBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.PackType

object AchievementsFiller {
    suspend fun fill_v1(achievementDao: AchievementDao) {
        addGlobalAchievements(achievementDao)
        addPartyAchievements(achievementDao)
    }

    private suspend fun addGlobalAchievements(achievementDao: AchievementDao) {
        achievementDao.insertAll(
            AchievementBd(
                name = "Возможость улучшений",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Сбежавшая торговка",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Древняя технология",
                pack = PackType.MAIN.name,
                isGlobal = true,
                maxRang = 5
            ),
            AchievementBd(
                name = "Помощь дрейку",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Подводное дыхание",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "На грани тьмы",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Портал обезврежен",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Голос освобожден",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Конец упадка",
                pack = PackType.MAIN.name,
                isGlobal = true,
                maxRang = 3
            ),
            AchievementBd(
                name = "Конец вторжения",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Конец эпохи Мрака",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Уничтожение порядка",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Городское правление: демоны",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Артефакт: найден",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Артефакт: потерян",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Артефакт: очищен",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Вторжение мертвецов",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Убийство дрейка",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Голос умолк",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Городское правление: военные",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
            AchievementBd(
                name = "Городское правление: торговцы",
                pack = PackType.MAIN.name,
                isGlobal = true
            ),
        )
    }

    private suspend fun addPartyAchievements(achievementDao: AchievementDao) {
        achievementDao.insertAll(
            AchievementBd(
                name = "Первые шаги",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Планы Джексеры",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Задание демона",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Карта сокровищ",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Путь через руины",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Приглашение",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "По следам",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Кадило Каменолома",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Темная награда",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Веление Голоса",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Предложение дрейка",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Путь через впадину",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Голос и скипитер",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Сокровище голоса",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Сокровище дрейка",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Помощь Красношипа",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Путь через пропасть",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Источник отравы",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Путь через жилище",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Морской конвой",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Гробокопатели",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Сомнительный помощник",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Дурное знамение",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Дрожь земли",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Посох воды",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Син-Ра",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Возвращение долга",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Личное задание: Последователь зорна",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Посох Зорна находится в инвентаре",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Личное задание: Возвращение леса",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Личное задание: Месть",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Личное задание: В Поисках лекарства",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Личное задание: Грехопадение",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
            AchievementBd(
                name = "Храбрость",
                pack = PackType.MAIN.name,
                isGlobal = false
            ),
        )
    }
}
