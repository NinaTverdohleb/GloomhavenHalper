package com.rumpilstilstkin.gloomhavenhelper.bd.filler.json.models

import com.rumpilstilstkin.gloomhavenhelper.bd.entity.MonsterAbilityCardBd
import kotlinx.serialization.Serializable

@Serializable
data class DeckJson(
    val name: String,
    val cards: List<CardJson>
){
    fun toEntity(): List<MonsterAbilityCardBd> = cards.map {
        MonsterAbilityCardBd(
            deckName = name,
            imageName = it.image,
            needsShuffle = it.needsShuffle,
            initiative = it.initiative,
        )
    }
}

@Serializable
data class CardJson(
    val image: String,
    val needsShuffle: Boolean,
    val initiative: Int
)