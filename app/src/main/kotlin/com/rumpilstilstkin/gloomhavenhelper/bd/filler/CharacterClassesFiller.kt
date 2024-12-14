package com.rumpilstilstkin.gloomhavenhelper.bd.filler

import com.rumpilstilstkin.gloomhavenhelper.bd.dao.CharacterClassDao
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterClassBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

object CharacterClassesFiller {

    suspend fun fill_v1(
        characterClassDao: CharacterClassDao
    ) {
        characterClassDao.insertAll(
            CharacterClassBd(name = "Инокс, дикарь", characterType = CharacterClassType.Brute.name),
            CharacterClassBd(
                name = "Вермлинг, повелитель зверей",
                characterType = CharacterClassType.BeastTyrant.name
            ),
            CharacterClassBd(
                name = "Саввас, пустотелый ",
                characterType = CharacterClassType.Cragheart.name
            ),
            CharacterClassBd(
                name = "Орхид, обрекающий",
                characterType = CharacterClassType.Doomstalker.name
            ),
            CharacterClassBd(
                name = "Саввас, элементалист",
                characterType = CharacterClassType.Elementalist.name
            ),
            CharacterClassBd(
                name = "Куатрил,воспевающая",
                characterType = CharacterClassType.Soothsinger.name
            ),
            CharacterClassBd(
                name = "Человек, костоправ",
                characterType = CharacterClassType.Sawbones.name
            ),
            CharacterClassBd(
                name = "Жнец, предвестник чумы",
                characterType = CharacterClassType.Plagueherald.name
            ),
            CharacterClassBd(
                name = "Куатрил, изобретатель",
                characterType = CharacterClassType.Tinkerer.name
            ),
            CharacterClassBd(
                name = "Эстер, покров ночи",
                characterType = CharacterClassType.Nightshroud.name
            ),
            CharacterClassBd(
                name = "Орхид, плетущая чары",
                characterType = CharacterClassType.Spellweaver.name
            ),
            CharacterClassBd(
                name = "Эстер, призывающая",
                characterType = CharacterClassType.Summoner.name
            ),
            CharacterClassBd(
                name = "Валрат, хранящая солнце",
                characterType = CharacterClassType.Sunkeeper.name
            ),
            CharacterClassBd(
                name = "Вермлинг, крадущая разум",
                characterType = CharacterClassType.Mindthief.name
            ),
            CharacterClassBd(
                name = "Человек, плутовка",
                characterType = CharacterClassType.Scoundrel.name
            ),
            CharacterClassBd(
                name = "Валрат, интендант",
                characterType = CharacterClassType.Quartermaster.name
            ),
            CharacterClassBd(
                name = "Эстрер, прорицательница",
                characterType = CharacterClassType.Diviner.name
            ),
            CharacterClassBd(
                name = "Инокс, берсерк",
                characterType = CharacterClassType.Berserker.name
            ),
        )
    }
}