package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterForSave

fun CharacterForSave.toBd(teamId: Int) = CharacterBd(
    name = this.name,
    level = this.level,
    classId = this.classId,
    teamId = teamId
)