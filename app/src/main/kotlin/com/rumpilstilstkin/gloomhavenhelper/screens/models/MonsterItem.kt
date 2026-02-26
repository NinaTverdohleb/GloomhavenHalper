package com.rumpilstilstkin.gloomhavenhelper.screens.models

import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterAction
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterCard
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.monster.MonsterStatType

data class MonsterItem(
    val id: Int,
    val name: String,
    val currentCard: MonsterAbilityCard? = null,
    val units: List<MonsterUnit> = emptyList(),
    val isBoss: Boolean = false,
) {
    companion object {
        fun fixture(
            id: Int = 1,
            name: String = "Name",
            isBoss: Boolean = false
        ) = MonsterItem(
            id = id,
            name = name,
            currentCard = null,
            isBoss = isBoss,
        )
    }
}

data class MonsterUnit(
    val number: Int,
    val currentLife: Int,
    val maxLife: Int,
    val stats: List<EffectItem>,
    val isSpecial: Boolean,
    val effects: List<ActionUi> = emptyList(),
    val immunity: List<ActionUi> = emptyList()
)

data class MonsterAbilityCard(
    val id: Int,
    val initiative: Int,
    val lines: List<EffectItem>,
    val needsShuffle: Boolean = false
) {
    companion object {
        fun createFromMonsterCard(card: MonsterCard) = MonsterAbilityCard(
            id = card.cardId,
            initiative = card.initiative,
            lines = card.actions.map { EffectItem.fromCardAction(it) },
            needsShuffle = card.needsShuffle
        )
    }
}

sealed interface EffectItem {
    val subLines: List<EffectItem>?

    data class Action(
        val type: ActionUi,
        val modifier: String,
        override val subLines: List<EffectItem>? = null
    ) : EffectItem

    data class Text(val content: String) : EffectItem {
        override val subLines: List<EffectItem>? = null
    }

    companion object {
        fun fromCardAction(action: MonsterAction): EffectItem = when (action) {
            is MonsterAction.Action -> Action(
                type = ActionUi.fromMonsterStatType(action.statType),
                modifier = action.modifier,
                subLines = action.subAction?.let { action -> action.map { fromCardAction(it) } }
            )

            is MonsterAction.Text -> Text(
                content = action.content
            )
        }
    }
}