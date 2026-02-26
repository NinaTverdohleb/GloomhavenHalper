package com.rumpilstilstkin.gloomhavenhelper.screens.scenario.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rumpilstilstkin.gloomhavenhelper.screens.models.ActionUi
import com.rumpilstilstkin.gloomhavenhelper.screens.models.EffectItem
import com.rumpilstilstkin.gloomhavenhelper.screens.models.MonsterAbilityCard
import com.rumpilstilstkin.gloomhavenhelper.ui.perks.perkEffectsInlineContentMap
import com.rumpilstilstkin.gloomhavenhelper.ui.perks.replacePerkTextWithIcons
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.CardColors
import com.rumpilstilstkin.gloomhavenhelper.ui.theme.GloomhavenHalperTheme

@Composable
fun MonsterActionCard(
    card: MonsterAbilityCard?,
    modifier: Modifier = Modifier
) {
    val weight = card?.initiative?.toString() ?: "?"
    val actionLines = card?.lines ?: listOf(
        EffectItem.Text(
            "Карта действия"
        )
    )

    Card(
        modifier = modifier,
        colors = cardColors(
            containerColor = CardColors.ActionCardBg,
        ),
        border = BorderStroke(
            0.5.dp,
            CardColors.CardBorder
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box(
                modifier = Modifier.size(64.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = weight,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }

            VerticalDivider(
                modifier = Modifier.height(64.dp),
                thickness = 1.dp,
                color = CardColors.CardBorder
            )

            Column {
                actionLines.forEachIndexed { index, line ->
                    CardEffectItem(line)
                    line.subLines?.forEach {
                        CardEffectItem(it, true)
                    }
                    if (index != actionLines.lastIndex) {
                        Spacer(modifier = Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}

@Composable
private fun CardEffectItem(line: EffectItem, isSubLine: Boolean = false) {
    val fontSize = if (isSubLine) 14.sp else 22.sp
    val iconSize = if (isSubLine) 18.dp else 24.dp
    val fontColor = if (isSubLine) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.onSurface
    when (line) {
        is EffectItem.Action -> {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = line.type.title,
                    fontSize = fontSize,
                    color = fontColor
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    modifier = Modifier.size(iconSize),
                    painter = painterResource(id = line.type.iconRes),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onSurface
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = line.modifier,
                    fontSize = fontSize,
                    color = fontColor
                )
            }
        }

        is EffectItem.Text -> {
            val textWithIcons = replacePerkTextWithIcons(line.content)
            Text(
                text = textWithIcons,
                inlineContent = perkEffectsInlineContentMap,
                color = fontColor,
                fontSize = fontSize,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview
@Composable
private fun MonsterActionCardPreview() {
    GloomhavenHalperTheme {
        MonsterActionCard(
            card = MonsterAbilityCard(
                id = 524,
                initiative = 15,
                lines = listOf(
                    EffectItem.Action(ActionUi.MOVE, "-1"),
                    EffectItem.Action(
                        ActionUi.STRENGTH,
                        "",
                        listOf(EffectItem.Text("Себя"))
                    ),
                    EffectItem.Text("#23")
                ),
                needsShuffle = true
            )
        )
    }
}