package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.GoodsDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.GoodBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.GoodType

object GoodsFiller {
    suspend fun fill_v1(
        goodsDao: GoodsDao
    ) {
        goodsDao.insertAll(
            GoodBd(
                number = 1,
                name = "Сапоги большого шага",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 1,
                name = "Сапоги большого шага",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 2,
                name = "Крылатые сапоги",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 2,
                name = "Крылатые сапоги",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 3,
                name = "Броня из шкур",
                type = GoodType.Body.name,
                cost = 10
            ),
            GoodBd(
                number = 3,
                name = "Броня из шкур",
                type = GoodType.Body.name,
                cost = 10
            ),
            GoodBd(
                number = 4,
                name = "Кожаная броня",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 4,
                name = "Кожаная броня",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 4,
                name = "Кожаная броня",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 5,
                name = "Плащ невидимка",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 5,
                name = "Плащ невидимка",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 6,
                name = "Очки орлиного взора",
                type = GoodType.Head.name,
                cost = 30
            ),
            GoodBd(
                number = 7,
                name = "Железный шлем",
                type = GoodType.Head.name,
                cost = 10
            ),
            GoodBd(
                number = 7,
                name = "Железный шлем",
                type = GoodType.Head.name,
                cost = 10
            ),
            GoodBd(
                number = 8,
                name = "Треугольный щит",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 8,
                name = "Треугольный щит",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 9,
                name = "Пронзающий лук",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 9,
                name = "Пронзающий лук",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 10,
                name = "Молот войны",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 10,
                name = "Молот войны",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 11,
                name = "Отравленный кинжал",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 11,
                name = "Отравленный кинжал",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 12,
                name = "Малое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 12,
                name = "Малое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 12,
                name = "Малое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 12,
                name = "Малое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 13,
                name = "Малое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 13,
                name = "Малое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 13,
                name = "Малое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 13,
                name = "Малое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 14,
                name = "Малое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 14,
                name = "Малое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 14,
                name = "Малое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 14,
                name = "Малое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 15,
                name = "Сапоги скорости",
                type = GoodType.Foot.name,
                cost = 30
            ),
            GoodBd(
                number = 15,
                name = "Сапоги скорости",
                type = GoodType.Foot.name,
                cost = 30
            ),
            GoodBd(
                number = 16,
                name = "Накидка с карманами",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 16,
                name = "Накидка с карманами",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 17,
                name = "Талисман Вдохновления",
                type = GoodType.Head.name,
                cost = 45
            ),
            GoodBd(
                number = 17,
                name = "Талисман Вдохновления",
                type = GoodType.Head.name,
                cost = 45
            ),
            GoodBd(
                number = 18,
                name = "Боевой топор",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 18,
                name = "Боевой топор",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 19,
                name = "Утяжеленная сеть",
                type = GoodType.DoubleArm.name,
                cost = 20
            ),
            GoodBd(
                number = 19,
                name = "Утяжеленная сеть",
                type = GoodType.DoubleArm.name,
                cost = 20
            ),
            GoodBd(
                number = 20,
                name = "Малое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 20,
                name = "Малое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 20,
                name = "Малое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 20,
                name = "Малое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 21,
                name = "Ослепляющая пыль",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 21,
                name = "Ослепляющая пыль",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 22,
                name = "Тяжелые поножи",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 22,
                name = "Тяжелые поножи",
                type = GoodType.Foot.name,
                cost = 20
            ),
            GoodBd(
                number = 23,
                name = "Кольчуга",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 23,
                name = "Кольчуга",
                type = GoodType.Body.name,
                cost = 20
            ),
            GoodBd(
                number = 24,
                name = "Амулет жизни",
                type = GoodType.Head.name,
                cost = 20
            ),
            GoodBd(
                number = 24,
                name = "Амулет жизни",
                type = GoodType.Head.name,
                cost = 20
            ),
            GoodBd(
                number = 25,
                name = "Зазубренный меч",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 25,
                name = "Зазубренный меч",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 26,
                name = "Длинное копье",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 26,
                name = "Длинное копье",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 27,
                name = "Большое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 27,
                name = "Большое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 27,
                name = "Большое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 27,
                name = "Большое лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 28,
                name = "Лунная серьга",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 28,
                name = "Лунная серьга",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 29,
                name = "Удобные башмаки",
                type = GoodType.Foot.name,
                cost = 30
            ),
            GoodBd(
                number = 29,
                name = "Удобные башмаки",
                type = GoodType.Foot.name,
                cost = 30
            ),
            GoodBd(
                number = 30,
                name = "Клепанная броня",
                type = GoodType.Body.name,
                cost = 30
            ),
            GoodBd(
                number = 30,
                name = "Клепанная броня",
                type = GoodType.Body.name,
                cost = 30
            ),
            GoodBd(
                number = 31,
                name = "Шлем ястреба",
                type = GoodType.Head.name,
                cost = 20
            ),
            GoodBd(
                number = 31,
                name = "Шлем ястреба",
                type = GoodType.Head.name,
                cost = 20
            ),
            GoodBd(
                number = 32,
                name = "Осадный щит",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 32,
                name = "Осадный щит",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 33,
                name = "Зажигательная бомба",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 33,
                name = "Зажигательная бомба",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 34,
                name = "Большое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 34,
                name = "Большое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 34,
                name = "Большое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 34,
                name = "Большое зелье выносливости",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 35,
                name = "Статуэтка сокола",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 35,
                name = "Статуэтка сокола",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 36,
                name = "Сапоги стремительности",
                type = GoodType.Foot.name,
                cost = 40
            ),
            GoodBd(
                number = 37,
                name = "Мантия воплощения",
                type = GoodType.Body.name,
                cost = 40
            ),
            GoodBd(
                number = 37,
                name = "Мантия воплощения",
                type = GoodType.Body.name,
                cost = 40
            ),
            GoodBd(
                number = 38,
                name = "Тяжелый шлем",
                type = GoodType.Head.name,
                cost = 30
            ),
            GoodBd(
                number = 38,
                name = "Тяжелый шлем",
                type = GoodType.Head.name,
                cost = 30
            ),
            GoodBd(
                number = 39,
                name = "Цепь с крюком",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 39,
                name = "Цепь с крюком",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 40,
                name = "Универсальный кинжал",
                type = GoodType.Arm.name,
                cost = 25
            ),
            GoodBd(
                number = 41,
                name = "Большое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 41,
                name = "Большое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 41,
                name = "Большое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 41,
                name = "Большое зелье силы",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 42,
                name = "Кольцо спешки",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 42,
                name = "Кольцо спешки",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 43,
                name = "Сапоги проворства",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 43,
                name = "Сапоги проворства",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 44,
                name = "Бригантина",
                type = GoodType.Body.name,
                cost = 35
            ),
            GoodBd(
                number = 44,
                name = "Бригантина",
                type = GoodType.Body.name,
                cost = 35
            ),
            GoodBd(
                number = 45,
                name = "Подвеска темных союзов",
                type = GoodType.Head.name,
                cost = 75
            ),
            GoodBd(
                number = 45,
                name = "Подвеска темных союзов",
                type = GoodType.Head.name,
                cost = 75
            ),
            GoodBd(
                number = 46,
                name = "Шипованный щит",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 46,
                name = "Шипованный щит",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 47,
                name = "Жатвенная коса",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 47,
                name = "Жатвенная коса",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 48,
                name = "Большое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 48,
                name = "Большое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 48,
                name = "Большое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 48,
                name = "Большое зелье маны",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 49,
                name = "Солнечная серьга",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 49,
                name = "Солнечная серьга",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 50,
                name = "Стальные сабатоны",
                type = GoodType.Foot.name,
                cost = 60
            ),
            GoodBd(
                number = 50,
                name = "Стальные сабатоны",
                type = GoodType.Foot.name,
                cost = 60
            ),
            GoodBd(
                number = 51,
                name = "Теневой доспех",
                type = GoodType.Body.name,
                cost = 30
            ),
            GoodBd(
                number = 51,
                name = "Теневой доспех",
                type = GoodType.Body.name,
                cost = 30
            ),
            GoodBd(
                number = 52,
                name = "Защитный амулет",
                type = GoodType.Head.name,
                cost = 60
            ),
            GoodBd(
                number = 52,
                name = "Защитный амулет",
                type = GoodType.Head.name,
                cost = 60
            ),
            GoodBd(
                number = 53,
                name = "Черный нож",
                type = GoodType.Arm.name,
                cost = 25
            ),
            GoodBd(
                number = 53,
                name = "Черный нож",
                type = GoodType.Arm.name,
                cost = 25
            ),
            GoodBd(
                number = 54,
                name = "Посох превосходства",
                type = GoodType.DoubleArm.name,
                cost = 60
            ),
            GoodBd(
                number = 54,
                name = "Посох превосходства",
                type = GoodType.DoubleArm.name,
                cost = 60
            ),
            GoodBd(
                number = 55,
                name = "Превосходное лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 55,
                name = "Превосходное лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 55,
                name = "Превосходное лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 55,
                name = "Превосходное лечебное зелье",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 56,
                name = "Кольцо жестокости",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 56,
                name = "Кольцо жестокости",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 57,
                name = "Сандали безмятежности",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 57,
                name = "Сандали безмятежности",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 58,
                name = "Накидка прозрачности",
                type = GoodType.Body.name,
                cost = 75
            ),
            GoodBd(
                number = 58,
                name = "Накидка прозрачности",
                type = GoodType.Body.name,
                cost = 75
            ),
            GoodBd(
                number = 59,
                name = "Телескопические линзы",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 59,
                name = "Телескопические линзы",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 60,
                name = "Нестабильная взрывчатка",
                type = GoodType.Arm.name,
                cost = 45
            ),
            GoodBd(
                number = 60,
                name = "Нестабильная взрывчатка",
                type = GoodType.Arm.name,
                cost = 45
            ),
            GoodBd(
                number = 61,
                name = "Фигурный щит",
                type = GoodType.DoubleArm.name,
                cost = 60
            ),
            GoodBd(
                number = 61,
                name = "Фигурный щит",
                type = GoodType.DoubleArm.name,
                cost = 60
            ),
            GoodBd(
                number = 62,
                name = "Пыль обречения",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 62,
                name = "Пыль обречения",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 63,
                name = "Счастливый глаз",
                type = GoodType.SmallThing.name,
                cost = 60
            ),
            GoodBd(
                number = 63,
                name = "Счастливый глаз",
                type = GoodType.SmallThing.name,
                cost = 60
            ),
            GoodBd(
                number = 64,
                name = "Сапоги быстрого бега",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 64,
                name = "Сапоги быстрого бега",
                type = GoodType.Foot.name,
                cost = 75
            ),
            GoodBd(
                number = 65,
                name = "Латы",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 65,
                name = "Латы",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 66,
                name = "Маска ужаса",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 66,
                name = "Маска ужаса",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 67,
                name = "Сбалансированный клинок",
                type = GoodType.Arm.name,
                cost = 60
            ),
            GoodBd(
                number = 67,
                name = "Сбалансированный клинок",
                type = GoodType.Arm.name,
                cost = 60
            ),
            GoodBd(
                number = 68,
                name = "Алебарда",
                type = GoodType.DoubleArm.name,
                cost = 75
            ),
            GoodBd(
                number = 68,
                name = "Алебарда",
                type = GoodType.DoubleArm.name,
                cost = 75
            ),
            GoodBd(
                number = 69,
                name = "Звездная серьга",
                type = GoodType.SmallThing.name,
                cost = 70
            ),
            GoodBd(
                number = 69,
                name = "Звездная серьга",
                type = GoodType.SmallThing.name,
                cost = 70
            ),
            GoodBd(
                number = 70,
                name = "Кольцо второго шанса",
                type = GoodType.SmallThing.name,
                cost = 75
            ),
            GoodBd(
                number = 70,
                name = "Кольцо второго шанса",
                type = GoodType.SmallThing.name,
                cost = 75
            ),
            GoodBd(
                number = 71,
                name = "Сапоги левитации",
                type = GoodType.Foot.name,
                cost = 50,
                isDrawing = true
            ),
            GoodBd(
                number = 71,
                name = "Сапоги левитации",
                type = GoodType.Foot.name,
                cost = 50
            ),
            GoodBd(
                number = 72,
                name = "Ботинки счастья",
                type = GoodType.Foot.name,
                cost = 50,
                isDrawing = true
            ),
            GoodBd(
                number = 72,
                name = "Ботинки счастья",
                type = GoodType.Foot.name,
                cost = 50
            ),
            GoodBd(
                number = 73,
                name = "Мерцающий плащ",
                type = GoodType.Body.name,
                cost = 50,
                isDrawing = true
            ),
            GoodBd(
                number = 73,
                name = "Мерцающий плащ",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 74,
                name = "Доспех лезвий",
                type = GoodType.Body.name,
                cost = 40,
                isDrawing = true
            ),
            GoodBd(
                number = 74,
                name = "Доспех лезвий",
                type = GoodType.Body.name,
                cost = 40
            ),
            GoodBd(
                number = 75,
                name = "Браслет стихий",
                type = GoodType.Head.name,
                cost = 25,
                isDrawing = true
            ),
            GoodBd(
                number = 75,
                name = "Браслет стихий",
                type = GoodType.Head.name,
                cost = 25
            ),
            GoodBd(
                number = 76,
                name = "Кольчужный капюшон",
                type = GoodType.Head.name,
                cost = 40,
                isDrawing = true
            ),
            GoodBd(
                number = 76,
                name = "Кольчужный капюшон",
                type = GoodType.Head.name,
                cost = 40
            ),
            GoodBd(
                number = 77,
                name = "Леденящий клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 77,
                name = "Леденящий клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 78,
                name = "Штормовой клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 78,
                name = "Штормовой клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 79,
                name = "Адский клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 79,
                name = "Адский клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 80,
                name = "Дрожащий клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 80,
                name = "Дрожащий клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 81,
                name = "Сияющий клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 81,
                name = "Сияющий клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 82,
                name = "Ночной клинок",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 82,
                name = "Ночной клинок",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 83,
                name = "Жезл мороза",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 83,
                name = "Жезл мороза",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 84,
                name = "Жезл Штормов",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 84,
                name = "Жезл Штормов",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 85,
                name = "Жезл Преисподней",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 85,
                name = "Жезл Преисподней",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 86,
                name = "Жезл дрожи земли",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 86,
                name = "Жезл дрожи земли",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 87,
                name = "Жезл сияния",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 87,
                name = "Жезл сияния",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 88,
                name = "Жезл темноты",
                type = GoodType.Arm.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 88,
                name = "Жезл темноты",
                type = GoodType.Arm.name,
                cost = 30
            ),
            GoodBd(
                number = 89,
                name = "Малое зелье исцеления",
                type = GoodType.SmallThing.name,
                cost = 10,
                isDrawing = true
            ),
            GoodBd(
                number = 89,
                name = "Малое зелье исцеления",
                type = GoodType.SmallThing.name,
                cost = 10
            ),
            GoodBd(
                number = 90,
                name = "Большое зелье исцеления",
                type = GoodType.SmallThing.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 90,
                name = "Большое зелье исцеления",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 91,
                name = "Стальное кольцо",
                type = GoodType.SmallThing.name,
                cost = 20,
                isDrawing = true
            ),
            GoodBd(
                number = 91,
                name = "Стальное кольцо",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 92,
                name = "Кольцо подавления",
                type = GoodType.SmallThing.name,
                cost = 25,
                isDrawing = true
            ),
            GoodBd(
                number = 92,
                name = "Кольцо подавления",
                type = GoodType.SmallThing.name,
                cost = 25
            ),
            GoodBd(
                number = 93,
                name = "Свиток силы",
                type = GoodType.SmallThing.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 93,
                name = "Свиток силы",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 94,
                name = "Свиток лечения",
                type = GoodType.SmallThing.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 94,
                name = "Свиток лечения",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 95,
                name = "Свиток выносливости",
                type = GoodType.SmallThing.name,
                cost = 30,
                isDrawing = true
            ),
            GoodBd(
                number = 95,
                name = "Свиток выносливости",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 96,
                name = "Реактивные сапоги",
                type = GoodType.Foot.name,
                cost = 80
            ),
            GoodBd(
                number = 96,
                name = "Реактивные сапоги",
                type = GoodType.Foot.name,
                cost = 80
            ),
            GoodBd(
                number = 97,
                name = "Портянки выносливости",
                type = GoodType.Foot.name,
                cost = 40
            ),
            GoodBd(
                number = 98,
                name = "Сапоги из чешуи дрейка",
                type = GoodType.Foot.name,
                cost = 50
            ),
            GoodBd(
                number = 99,
                name = "Лавовые ботфорты",
                type = GoodType.Foot.name,
                cost = 50
            ),
            GoodBd(
                number = 100,
                name = "Мантия призыва",
                type = GoodType.Body.name,
                cost = 40
            ),
            GoodBd(
                number = 101,
                name = "Вторая кожа",
                type = GoodType.Body.name,
                cost = 30
            ),
            GoodBd(
                number = 102,
                name = "Мантия самопожертвования",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 103,
                name = "Доспех из чешуи дрейка",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 104,
                name = "Паровой доспех",
                type = GoodType.Body.name,
                cost = 50
            ),
            GoodBd(
                number = 105,
                name = "Изьеденная молью шаль",
                type = GoodType.Body.name,
                cost = 10
            ),
            GoodBd(
                number = 106,
                name = "Ожерелье из зубов",
                type = GoodType.Head.name,
                cost = 40
            ),
            GoodBd(
                number = 107,
                name = "Рогатый шлем",
                type = GoodType.Head.name,
                cost = 30
            ),
            GoodBd(
                number = 107,
                name = "Рогатый шлем",
                type = GoodType.Head.name,
                cost = 30
            ),
            GoodBd(
                number = 108,
                name = "Шлем из чешуи дрейка",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 109,
                name = "Воровской капюшон",
                type = GoodType.Head.name,
                cost = 20
            ),
            GoodBd(
                number = 110,
                name = "Шлем гор",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 111,
                name = "Гребень волны",
                type = GoodType.Head.name,
                cost = 50
            ),
            GoodBd(
                number = 112,
                name = "Древний бур",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 112,
                name = "Древний бур",
                type = GoodType.DoubleArm.name,
                cost = 30
            ),
            GoodBd(
                number = 113,
                name = "Топор порчи черепов",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 114,
                name = "Посох Зорна",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 115,
                name = "Горный молот",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 116,
                name = "Воспламеняющийся меч",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 116,
                name = "Воспламеняющийся меч",
                type = GoodType.Arm.name,
                cost = 20
            ),
            GoodBd(
                number = 117,
                name = "Кровавый топор",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 117,
                name = "Кровавый топор",
                type = GoodType.Arm.name,
                cost = 40
            ),
            GoodBd(
                number = 118,
                name = "Посох стихий",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 118,
                name = "Посох стихий",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 119,
                name = "Череп ненависти",
                type = GoodType.Arm.name,
                cost = 50
            ),
            GoodBd(
                number = 120,
                name = "Посох призыва",
                type = GoodType.DoubleArm.name,
                cost = 60
            ),
            GoodBd(
                number = 121,
                name = "Сфера зари",
                type = GoodType.Arm.name,
                cost = 50
            ),
            GoodBd(
                number = 122,
                name = "Сфера сумерек",
                type = GoodType.Arm.name,
                cost = 50
            ),
            GoodBd(
                number = 123,
                name = "Кольцо черепов",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 123,
                name = "Кольцо черепов",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 124,
                name = "Компас обречения",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 125,
                name = "Странный механизм",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 126,
                name = "Управляемый паук",
                type = GoodType.SmallThing.name,
                cost = 40
            ),
            GoodBd(
                number = 127,
                name = "Гигантский управляемый паук",
                type = GoodType.SmallThing.name,
                cost = 60
            ),
            GoodBd(
                number = 128,
                name = "Черное кадило",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 129,
                name = "Черная карта",
                type = GoodType.SmallThing.name,
                cost = 75
            ),
            GoodBd(
                number = 130,
                name = "Плетеное кольцо",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 131,
                name = "Сердце предателя",
                type = GoodType.SmallThing.name,
                cost = 60
            ),
            GoodBd(
                number = 132,
                name = "Энергетическое ядро",
                type = GoodType.SmallThing.name,
                cost = 75
            ),
            GoodBd(
                number = 133,
                name = "Резонирующий кристал",
                type = GoodType.SmallThing.name,
                cost = 20
            ),
            GoodBd(
                number = 153,
                name = "Малое противоядие",
                type = GoodType.SmallThing.name,
                cost = 25
            ),
            GoodBd(
                number = 153,
                name = "Малое противоядие",
                type = GoodType.SmallThing.name,
                cost = 25
            ),
            GoodBd(
                number = 154,
                name = "Большое противоядие",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 154,
                name = "Большое противоядие",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 155,
                name = "Оберегающий доспех",
                type = GoodType.Body.name,
                cost = 75
            ),
            GoodBd(
                number = 156,
                name = "Клеймор стихий",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 156,
                name = "Клеймор стихий",
                type = GoodType.DoubleArm.name,
                cost = 50
            ),
            GoodBd(
                number = 157,
                name = "Древний лук",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 157,
                name = "Древний лук",
                type = GoodType.DoubleArm.name,
                cost = 40
            ),
            GoodBd(
                number = 158,
                name = "Заживляющие поножи",
                type = GoodType.Foot.name,
                cost = 35
            ),
            GoodBd(
                number = 158,
                name = "Заживляющие поножи",
                type = GoodType.Foot.name,
                cost = 35
            ),
            GoodBd(
                number = 159,
                name = "Свиток проворства",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 159,
                name = "Свиток проворства",
                type = GoodType.SmallThing.name,
                cost = 30
            ),
            GoodBd(
                number = 160,
                name = "Кинжал карманника",
                type = GoodType.Arm.name,
                cost = 45
            ),
            GoodBd(
                number = 161,
                name = "Метательный топор",
                type = GoodType.Arm.name,
                cost = 35
            ),
            GoodBd(
                number = 161,
                name = "Метательный топор",
                type = GoodType.Arm.name,
                cost = 35
            ),
            GoodBd(
                number = 162,
                name = "Генераторо порталов",
                type = GoodType.SmallThing.name,
                cost = 50
            ),
            GoodBd(
                number = 163,
                name = "Кристальная тиара",
                type = GoodType.Head.name,
                cost = 75
            ),
            GoodBd(
                number = 164,
                name = "Чаша пророчества",
                type = GoodType.DoubleArm.name,
                cost = 55
            ),
            GoodBd(
                number = 165,
                name = "Кольцо дуальности",
                type = GoodType.SmallThing.name,
                cost = 50
            )
        )
    }
}