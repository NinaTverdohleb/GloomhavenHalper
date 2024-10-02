package com.rumpilstilstkin.gloomhavenhelper.screens.models

import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClass
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.CharacterClassType

data class CharacterClassUI(
    val name: String,
    val id: Int,
    val imageRes: Int,
)

fun CharacterClass.toUI() = CharacterClassUI(
    name = this.name,
    id = this.id,
    imageRes = this.type.toImage(),
)


fun CharacterClassType.toImage() = when(this) {
    CharacterClassType.Brute -> R.drawable.br
    CharacterClassType.BeastTyrant -> R.drawable.bt
    CharacterClassType.Cragheart -> R.drawable.ch
    CharacterClassType.Doomstalker -> R.drawable.ds
    CharacterClassType.Elementalist -> R.drawable.el
    CharacterClassType.Soothsinger -> R.drawable.ss
    CharacterClassType.Sawbones -> R.drawable.sb
    CharacterClassType.Plagueherald -> R.drawable.ph
    CharacterClassType.Tinkerer -> R.drawable.ti
    CharacterClassType.Nightshroud -> R.drawable.ns
    CharacterClassType.Spellweaver -> R.drawable.sw
    CharacterClassType.Summoner-> R.drawable.su
    CharacterClassType.Sunkeeper -> R.drawable.sk
    CharacterClassType.Mindthief -> R.drawable.mt
    CharacterClassType.Scoundrel -> R.drawable.sc
    CharacterClassType.Quartermaster -> R.drawable.qm
    CharacterClassType.Diviner -> R.drawable.dr
}
