package com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

data class QuestReward(
    val classType: CharacterClassType? = null,
    val alternativeReward: String = ""
)
