package com.rumpilstilstkin.gloomhavenhelper.domain.entity

import kotlin.math.roundToInt

data class CharacterClass(
    val id: Int,
    val image: Int,
    val name: String
)

data class CharacterForSave(
    val name: String,
    val level: Int,
    val classId: Int
)

fun List<Int>.toLevel(): Int {
    return this.average().div(2).roundToInt()
}


