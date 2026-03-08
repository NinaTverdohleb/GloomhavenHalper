package com.rumpilstilstkin.gloomhavenhelper.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Achievement(
    val name: String,
    val value: Int,
    val maxValue: Int,
){
    companion object {
        fun fixture(
            name: String = "Achievement 1",
            value: Int = 1,
            maxValue: Int = 1,
        ) = Achievement(
            name = name,
            value = value,
            maxValue = maxValue
        )
    }
}
