package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterClassBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClass
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

fun CharacterClassBd.toDomain() = CharacterClass(
    type = CharacterClassType.valueOf(this.characterType),
    name = this.name
)