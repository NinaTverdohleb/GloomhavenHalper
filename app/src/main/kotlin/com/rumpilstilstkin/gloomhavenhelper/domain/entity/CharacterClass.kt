package com.rumpilstilstkin.gloomhavenhelper.domain.entity

data class CharacterClass(
    val id: Int,
    val type: CharacterClassType,
    val name: String
)

enum class CharacterClassType {
    Brute,
    BeastTyrant,
    Cragheart,
    Doomstalker,
    Elementalist,
    Soothsinger,
    Sawbones,
    Plagueherald,
    Tinkerer,
    Nightshroud,
    Spellweaver,
    Summoner,
    Sunkeeper,
    Mindthief,
    Scoundrel,
    Quartermaster,
    Diviner
}