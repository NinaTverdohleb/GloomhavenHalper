package com.rumpilstilstkin.gloomhavenhelper.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.vector.ImageVector
import com.rumpilstilstkin.gloomhavenhelper.R
import com.rumpilstilstkin.gloomhavenhelper.domain.entity.EffectType
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.GloomhavenIcons
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Confuse
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Disarm
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Next
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Probitie
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Rana
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Stun
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.effects.Target

fun EffectType.toImageVector(): ImageVector = when(this) {
    EffectType.NEXT -> GloomhavenIcons.Effect.Next
    EffectType.PUSH -> Icons.Default.Warning
    EffectType.PROBOY -> GloomhavenIcons.Effect.Probitie
    EffectType.STUN -> GloomhavenIcons.Effect.Stun
    EffectType.DISARM -> GloomhavenIcons.Effect.Disarm
    EffectType.CONFUSE -> GloomhavenIcons.Effect.Confuse
    EffectType.TARGET -> GloomhavenIcons.Effect.Target
    EffectType.WOUND -> GloomhavenIcons.Effect.Rana
    else -> Icons.Default.Warning
}

fun EffectType.toImageResource(): Int = when(this) {
    EffectType.MINUS1 -> R.drawable.minus1
    EffectType.MINUS2 -> R.drawable.minus2
    EffectType.PLUS1 -> R.drawable.plus1
    EffectType.PLUS2 -> R.drawable.plus2
    EffectType.PLUS3 -> R.drawable.plus3
    EffectType.PLUS4 -> R.drawable.plus4
    else -> R.drawable.br
}