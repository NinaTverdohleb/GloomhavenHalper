package com.rumpilstilstkin.gloomhavenhelper.ui.icons.goods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rumpilstilstkin.gloomhavenhelper.ui.icons.GloomhavenIcons

public val GloomhavenIcons.GoodTypes.Head: ImageVector
    get() {
        if (_head != null) {
            return _head!!
        }
        _head = Builder(
            name = "Head",
            defaultWidth = 400.0.dp,
            defaultHeight = 400.0.dp,
            viewportWidth = 400.0f,
            viewportHeight = 400.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF141414)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(198.41f, 38.71f)
                curveToRelative(-4.2f, 3.36f, -10.37f, 16.17f, -13.4f, 27.82f)
                lineToRelative(-0.55f, 2.11f)
                lineToRelative(-0.77f, 0.11f)
                curveToRelative(-20.08f, 2.94f, -40.91f, 12.23f, -53.86f, 24.01f)
                curveToRelative(-14.37f, 13.07f, -23.67f, 27.94f, -28.06f, 44.91f)
                curveToRelative(-5.51f, 21.23f, -6.78f, 43.12f, -7.04f, 121.32f)
                lineToRelative(-0.1f, 32.26f)
                lineToRelative(2.99f, 4.83f)
                curveToRelative(15.33f, 24.79f, 31.24f, 48.02f, 43.19f, 63.05f)
                curveToRelative(2.1f, 2.64f, 2.26f, 2.78f, 2.4f, 2.16f)
                curveToRelative(0.05f, -0.21f, 0.54f, -1.8f, 1.09f, -3.54f)
                curveToRelative(10.56f, -33.29f, 16.77f, -76.16f, 15.06f, -103.92f)
                curveToRelative(-0.41f, -6.57f, -1.26f, -14.36f, -1.63f, -14.96f)
                curveToRelative(-0.67f, -1.06f, -6.0f, -3.11f, -12.66f, -4.87f)
                curveToRelative(-12.52f, -3.31f, -14.57f, -4.9f, -17.56f, -13.57f)
                curveToRelative(-0.84f, -2.45f, -0.96f, -2.2f, 1.51f, -3.22f)
                curveToRelative(18.66f, -7.67f, 42.33f, -12.65f, 57.98f, -12.18f)
                lineToRelative(1.75f, 0.05f)
                lineToRelative(0.08f, 46.0f)
                lineToRelative(0.09f, 46.0f)
                lineToRelative(0.36f, 0.68f)
                curveToRelative(3.84f, 7.17f, 17.4f, 7.32f, 21.3f, 0.23f)
                lineToRelative(0.5f, -0.91f)
                lineToRelative(0.09f, -46.0f)
                lineToRelative(0.08f, -46.0f)
                lineToRelative(1.75f, -0.05f)
                curveToRelative(15.15f, -0.45f, 38.54f, 4.35f, 56.57f, 11.62f)
                curveToRelative(4.05f, 1.63f, 3.76f, 1.32f, 3.01f, 3.21f)
                curveToRelative(-3.52f, 8.83f, -6.11f, 10.84f, -18.41f, 14.28f)
                curveToRelative(-6.21f, 1.74f, -11.28f, 3.76f, -11.9f, 4.74f)
                curveToRelative(-0.38f, 0.59f, -1.25f, 8.6f, -1.59f, 14.62f)
                curveToRelative(-1.62f, 28.2f, 3.42f, 64.63f, 13.92f, 100.67f)
                curveToRelative(1.04f, 3.55f, 2.22f, 7.22f, 2.39f, 7.39f)
                curveToRelative(0.25f, 0.25f, 6.68f, -8.05f, 13.08f, -16.87f)
                curveToRelative(10.54f, -14.53f, 21.33f, -30.81f, 33.35f, -50.27f)
                lineToRelative(1.95f, -3.17f)
                lineToRelative(-0.1f, -32.25f)
                curveToRelative(-0.15f, -45.27f, -0.43f, -61.38f, -1.36f, -78.08f)
                curveToRelative(-2.51f, -45.21f, -9.14f, -63.55f, -30.85f, -85.34f)
                curveToRelative(-13.55f, -13.59f, -33.37f, -23.0f, -56.4f, -26.76f)
                lineToRelative(-1.26f, -0.21f)
                lineToRelative(-0.56f, -2.01f)
                curveToRelative(-2.99f, -10.71f, -8.59f, -22.2f, -13.16f, -26.99f)
                curveToRelative(-1.53f, -1.6f, -2.17f, -1.78f, -3.27f, -0.9f)
            }
        }
            .build()
        return _head!!
    }

private var _head: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Head, contentDescription = null)
    }
}
