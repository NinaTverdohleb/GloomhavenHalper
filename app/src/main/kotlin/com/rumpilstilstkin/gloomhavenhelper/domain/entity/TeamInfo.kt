package com.rumpilstilstkin.gloomhavenhelper.domain.entity

data class TeamInfo(
    val id: Int,
    val name: String,
    val level: Int,
) {
    companion object {
        val EMPTY = TeamInfo(0, "", 0)
    }
}

data class TeamInfoForSave(
    val name: String,
    val characters: List<CharacterForSave>
)


