package com.rumpilstilstkin.gloomhavenhelper.data.mappers

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.CharacterPersonalQuestDetailsBd
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.CharacterPersonalQuest
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.QuestReward

fun CharacterPersonalQuestDetailsBd.toDomain() = CharacterPersonalQuest(
    questId = this.personalTask.questId,
    title = this.personalTask.title,
    descriptions = this.personalTask.description,
    tasks = this.characterPersonalTask.tasks,
    reward = QuestReward(
        classType = this.personalTask.characterType?.let { CharacterClassType.valueOf(it) },
        alternativeReward = this.personalTask.specialText
    )
)