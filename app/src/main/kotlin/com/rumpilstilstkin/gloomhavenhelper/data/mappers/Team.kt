package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.TeamBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.TeamInfoForSave

fun TeamInfoForSave.toBd() = TeamBd(
    name = this.name,
)