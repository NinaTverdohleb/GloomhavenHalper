package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterPerkDetailsBd
import com.rumpilstilstkin.gloomhavenhelper.bd.entity.PerkBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.Perk

fun PerkBd.toDomain() = Perk(
    id = this.perkId,
    text = this.text,
    characterType = CharacterClassType.valueOf(this.characterType),
)

fun CharacterPerkDetailsBd.toDomain() = Perk(
    id = this.perk.perkId,
    text = this.perk.text,
    characterType = CharacterClassType.valueOf(this.perk.characterType),
    characterPerkId = this.characterPerk.id
)