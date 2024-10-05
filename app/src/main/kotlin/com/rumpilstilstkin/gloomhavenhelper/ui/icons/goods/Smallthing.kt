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

public val GloomhavenIcons.GoodTypes.Smallthing: ImageVector
    get() {
        if (_smallthing != null) {
            return _smallthing!!
        }
        _smallthing = Builder(
            name = "Smallthing",
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
                moveTo(259.08f, 40.06f)
                curveToRelative(-8.66f, 1.45f, -18.94f, 9.04f, -41.16f, 30.42f)
                curveToRelative(-10.19f, 9.8f, -11.48f, 11.0f, -14.8f, 13.71f)
                curveToRelative(-2.31f, 1.89f, -3.97f, 3.01f, -5.59f, 3.78f)
                lineToRelative(-1.28f, 0.61f)
                lineToRelative(-2.5f, -0.01f)
                curveToRelative(-6.99f, -0.03f, -20.0f, -3.29f, -30.3f, -7.59f)
                curveToRelative(-5.72f, -2.39f, -10.32f, -4.84f, -19.95f, -10.61f)
                curveToRelative(-3.44f, -2.06f, -7.54f, -4.46f, -9.13f, -5.33f)
                curveToRelative(-15.12f, -8.31f, -23.31f, -7.25f, -30.09f, 3.89f)
                curveToRelative(-11.39f, 18.73f, -3.43f, 48.03f, 21.1f, 77.62f)
                curveToRelative(1.27f, 1.55f, 2.28f, 2.85f, 2.23f, 2.89f)
                curveToRelative(-0.04f, 0.05f, -2.62f, -0.11f, -5.72f, -0.34f)
                curveToRelative(-5.49f, -0.42f, -10.17f, -0.73f, -16.64f, -1.11f)
                curveToRelative(-8.88f, -0.52f, -25.46f, -0.37f, -32.0f, 0.27f)
                curveToRelative(-15.34f, 1.53f, -20.98f, 4.91f, -20.08f, 12.04f)
                curveToRelative(0.54f, 4.35f, 1.84f, 7.51f, 8.75f, 21.28f)
                curveToRelative(7.39f, 14.74f, 9.28f, 20.85f, 8.25f, 26.62f)
                curveToRelative(-0.26f, 1.48f, -0.49f, 1.49f, 2.5f, -0.14f)
                curveToRelative(7.01f, -3.84f, 11.74f, -6.99f, 21.25f, -14.15f)
                curveToRelative(10.8f, -8.15f, 15.3f, -10.67f, 21.17f, -11.85f)
                curveToRelative(2.72f, -0.55f, 10.13f, -0.27f, 10.77f, 0.4f)
                curveToRelative(0.13f, 0.15f, -0.86f, 7.61f, -1.36f, 10.26f)
                curveToRelative(-1.7f, 8.95f, -5.21f, 16.11f, -13.25f, 27.03f)
                curveToRelative(-5.52f, 7.49f, -9.08f, 14.6f, -12.6f, 25.12f)
                curveToRelative(-13.28f, 39.79f, -7.88f, 75.09f, 14.22f, 92.91f)
                curveToRelative(8.64f, 6.95f, 18.96f, 11.27f, 39.21f, 16.38f)
                curveToRelative(25.1f, 6.34f, 38.5f, 6.75f, 59.68f, 1.85f)
                curveToRelative(19.43f, -4.49f, 28.08f, -4.46f, 49.99f, 0.18f)
                curveToRelative(22.25f, 4.71f, 31.4f, 5.1f, 42.37f, 1.81f)
                curveToRelative(11.68f, -3.51f, 23.78f, -13.7f, 31.54f, -26.58f)
                curveToRelative(23.62f, -39.19f, 8.73f, -116.94f, -32.05f, -167.32f)
                curveToRelative(-1.82f, -2.25f, -1.75f, -2.05f, -1.19f, -3.56f)
                curveToRelative(0.8f, -2.12f, 2.68f, -4.98f, 8.06f, -12.27f)
                curveToRelative(5.42f, -7.35f, 7.7f, -10.62f, 10.07f, -14.47f)
                curveToRelative(10.07f, -16.3f, 12.14f, -28.96f, 6.62f, -40.39f)
                curveToRelative(-2.8f, -5.8f, -10.03f, -7.71f, -38.5f, -10.16f)
                curveToRelative(-7.34f, -0.63f, -12.33f, -1.19f, -12.55f, -1.4f)
                curveToRelative(-0.08f, -0.08f, 0.16f, -1.03f, 0.52f, -2.12f)
                curveToRelative(2.41f, -7.23f, 2.89f, -16.29f, 1.25f, -23.31f)
                curveToRelative(-2.67f, -11.37f, -10.07f, -17.81f, -18.81f, -16.36f)
                moveToRelative(-108.33f, 115.7f)
                curveToRelative(10.49f, 0.76f, 26.12f, 2.16f, 32.67f, 2.92f)
                curveToRelative(2.38f, 0.28f, 5.08f, 0.59f, 6.0f, 0.68f)
                curveToRelative(2.2f, 0.24f, 14.32f, 0.07f, 20.0f, -0.27f)
                curveToRelative(2.38f, -0.14f, 9.13f, -0.56f, 15.0f, -0.92f)
                curveToRelative(43.39f, -2.69f, 49.97f, -2.25f, 56.31f, 3.82f)
                curveToRelative(5.71f, 5.47f, 5.16f, 14.84f, -0.75f, 12.75f)
                curveToRelative(-3.71f, -1.31f, -14.82f, 0.05f, -36.73f, 4.52f)
                curveToRelative(-3.3f, 0.67f, -10.27f, 2.09f, -15.5f, 3.16f)
                curveToRelative(-14.6f, 2.98f, -19.62f, 3.87f, -23.75f, 4.23f)
                curveToRelative(-11.54f, 1.0f, -30.57f, -0.48f, -56.75f, -4.41f)
                curveToRelative(-5.16f, -0.77f, -4.75f, -0.66f, -4.75f, -1.31f)
                curveToRelative(0.0f, -0.31f, 0.45f, -4.52f, 0.99f, -9.37f)
                curveToRelative(0.55f, -4.84f, 1.15f, -10.16f, 1.33f, -11.81f)
                curveToRelative(0.19f, -1.65f, 0.38f, -3.32f, 0.44f, -3.72f)
                lineToRelative(0.1f, -0.73f)
                lineToRelative(0.94f, 0.1f)
                curveToRelative(0.52f, 0.06f, 2.52f, 0.22f, 4.45f, 0.36f)
            }
        }
            .build()
        return _smallthing!!
    }

private var _smallthing: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Smallthing, contentDescription = null)
    }
}
