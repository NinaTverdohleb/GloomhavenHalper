package com.rumpilstilstkin.gloomhavenhelper.screens.models

import androidx.compose.runtime.Immutable
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.CharacterPersonalQuest
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.CharacterTaskItem
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.quest.QuestReward
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

@Immutable
data class PersonalQuestUI(
    val id: String,
    val title: String,
    val description: String,
    val phases: ImmutableList<QuestTaskPhaseUI>,
    val completed: Boolean = false,
    val reward: QuestReward
)

@Immutable
data class QuestTaskPhaseUI(
    val priority: Int,
    val completed: Boolean = false,
    val visible: Boolean = false,
    val tasks: ImmutableList<CharacterTaskItemUI>,
)

sealed interface CharacterTaskItemUI {
    val id: Int
    val title: String
    val priority: Int

    data class Check(
        override val id: Int,
        override val title: String,
        override val priority: Int,
        val isChecked: Boolean = false,
    ) : CharacterTaskItemUI

    data class Count(
        override val id: Int,
        override val title: String,
        override val priority: Int,
        val count: Int,
        val currentCount: Int = 0,
    ) : CharacterTaskItemUI
}

fun CharacterTaskItem.toUI(): CharacterTaskItemUI {
    return when (this) {
        is CharacterTaskItem.Check -> CharacterTaskItemUI.Check(
            id = this.id,
            title = this.text,
            priority = this.priority,
            isChecked = this.isChecked
        )

        is CharacterTaskItem.Count -> CharacterTaskItemUI.Count(
            id = this.id,
            title = this.text,
            priority = this.priority,
            count = this.count,
            currentCount = this.currentCount
        )
    }
}

fun CharacterPersonalQuest.toUI() = PersonalQuestUI(
    id = this.questId,
    title = this.title,
    description = this.descriptions,
    completed = this.tasks.all { it.completed },
    reward = this.reward,
    phases = tasks.toImmutableListQuestTaskPhaseUIList()
)

private fun List<CharacterTaskItem>.toImmutableListQuestTaskPhaseUIList() =
    this.groupBy { it.priority }.map { (priority, tasks) ->
        QuestTaskPhaseUI(
            priority = priority,
            completed = tasks.all { it.completed },
            tasks = tasks.map { it.toUI() }.sortedBy { it.priority }.toImmutableList()
        )
    }.compile()

private fun List<QuestTaskPhaseUI>.compile() =
    this
        .mapIndexed {
                    index, questTaskPhase -> questTaskPhase.copy(visible = questTaskPhase.priority == 0 || this[index - 1].completed)
        }
        .sortedBy { it.priority }
        .toImmutableList()

