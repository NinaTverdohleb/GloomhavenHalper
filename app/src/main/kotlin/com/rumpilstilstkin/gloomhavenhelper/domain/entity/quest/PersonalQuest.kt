package com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest

data class CharacterPersonalQuest(
    val questId: String,
    val title: String,
    val descriptions: String,
    val reward: QuestReward,
    val tasks: List<CharacterTaskItem>
)
