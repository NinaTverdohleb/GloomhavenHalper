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

public val GloomhavenIcons.GoodTypes.Foot: ImageVector
    get() {
        if (_foot != null) {
            return _foot!!
        }
        _foot = Builder(
            name = "Foot",
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
                moveTo(103.42f, 38.26f)
                curveToRelative(-4.54f, 0.33f, -6.29f, 0.49f, -9.09f, 0.84f)
                curveToRelative(-9.59f, 1.2f, -17.87f, 3.08f, -30.56f, 6.93f)
                lineToRelative(-1.81f, 0.55f)
                lineToRelative(-0.47f, 0.93f)
                curveToRelative(-1.55f, 3.08f, -3.04f, 9.15f, -3.73f, 15.24f)
                curveToRelative(-3.23f, 28.61f, 4.81f, 70.63f, 23.42f, 122.31f)
                lineToRelative(2.45f, 6.8f)
                lineToRelative(-0.32f, 1.45f)
                curveToRelative(-5.02f, 22.75f, -13.06f, 69.99f, -16.3f, 95.77f)
                curveToRelative(-2.89f, 23.01f, -3.66f, 40.74f, -1.92f, 44.11f)
                curveToRelative(3.35f, 6.46f, 42.99f, 21.89f, 71.01f, 27.63f)
                curveToRelative(6.8f, 1.39f, 7.14f, 1.37f, 8.24f, -0.44f)
                curveToRelative(4.21f, -6.92f, 9.13f, -13.04f, 11.49f, -14.29f)
                lineToRelative(0.92f, -0.49f)
                lineToRelative(7.17f, -0.29f)
                curveToRelative(19.73f, -0.8f, 32.4f, -0.76f, 41.5f, 0.13f)
                curveToRelative(2.53f, 0.24f, 6.19f, 0.78f, 6.34f, 0.93f)
                curveToRelative(0.45f, 0.45f, 2.24f, 8.42f, 2.24f, 9.98f)
                curveToRelative(0.0f, 0.49f, 0.09f, 0.69f, 0.38f, 0.85f)
                curveToRelative(0.52f, 0.3f, 15.85f, 0.3f, 19.37f, 0.0f)
                curveToRelative(41.56f, -3.53f, 76.8f, -18.86f, 106.45f, -46.31f)
                lineToRelative(2.78f, -2.58f)
                lineToRelative(-0.08f, -1.45f)
                curveToRelative(-0.77f, -13.78f, -2.76f, -22.53f, -7.0f, -30.87f)
                curveToRelative(-2.31f, -4.55f, -6.0f, -9.51f, -8.09f, -10.88f)
                curveToRelative(-0.46f, -0.3f, -1.3f, -0.15f, -19.29f, 3.62f)
                lineToRelative(-3.56f, 0.74f)
                lineToRelative(-1.77f, -0.76f)
                curveToRelative(-15.59f, -6.67f, -41.57f, -10.87f, -67.23f, -10.88f)
                horizontalLineToRelative(-5.54f)
                lineToRelative(-0.66f, -1.21f)
                curveToRelative(-1.04f, -1.91f, -3.87f, -6.28f, -11.36f, -17.54f)
                curveToRelative(-9.43f, -14.16f, -13.5f, -20.58f, -17.58f, -27.7f)
                lineToRelative(-2.12f, -3.71f)
                lineToRelative(-23.72f, -0.04f)
                curveToRelative(-22.62f, -0.05f, -23.77f, -0.06f, -24.65f, -0.36f)
                curveToRelative(-8.23f, -2.78f, -8.5f, -13.76f, -0.41f, -16.81f)
                lineToRelative(1.0f, -0.38f)
                lineToRelative(20.38f, -0.04f)
                lineToRelative(20.38f, -0.05f)
                lineToRelative(-0.1f, -0.54f)
                curveToRelative(-0.12f, -0.65f, 0.15f, -4.33f, 0.59f, -8.12f)
                curveToRelative(0.18f, -1.51f, 0.33f, -2.92f, 0.33f, -3.12f)
                verticalLineToRelative(-0.38f)
                horizontalLineToRelative(-22.23f)
                curveToRelative(-23.81f, 0.0f, -23.27f, 0.02f, -25.19f, -0.89f)
                curveToRelative(-6.48f, -3.09f, -6.62f, -12.51f, -0.22f, -15.65f)
                curveToRelative(1.99f, -0.99f, 0.92f, -0.95f, 26.43f, -0.95f)
                curveToRelative(13.04f, 0.0f, 23.71f, -0.06f, 23.71f, -0.13f)
                reflectiveCurveToRelative(0.41f, -2.78f, 0.91f, -6.03f)
                curveToRelative(0.5f, -3.24f, 0.87f, -5.96f, 0.82f, -6.04f)
                curveToRelative(-0.04f, -0.08f, -12.03f, -0.14f, -26.63f, -0.14f)
                curveToRelative(-29.32f, 0.0f, -27.19f, 0.08f, -29.35f, -1.06f)
                curveToRelative(-5.9f, -3.1f, -5.96f, -12.13f, -0.1f, -15.25f)
                curveToRelative(2.27f, -1.21f, -0.7f, -1.1f, 30.67f, -1.19f)
                lineToRelative(28.25f, -0.08f)
                lineToRelative(0.87f, -5.5f)
                curveToRelative(0.48f, -3.03f, 0.92f, -5.75f, 0.98f, -6.04f)
                lineToRelative(0.09f, -0.55f)
                horizontalLineToRelative(-28.63f)
                curveToRelative(-31.68f, 0.0f, -29.86f, 0.06f, -32.05f, -1.09f)
                curveToRelative(-6.9f, -3.63f, -5.7f, -14.15f, 1.86f, -16.17f)
                curveToRelative(0.76f, -0.2f, 5.46f, -0.23f, 31.18f, -0.24f)
                horizontalLineToRelative(30.29f)
                lineToRelative(0.08f, -0.37f)
                curveToRelative(0.24f, -1.04f, 3.8f, -25.04f, 4.67f, -31.46f)
                curveToRelative(1.07f, -7.95f, 1.63f, -14.01f, 1.36f, -15.04f)
                curveToRelative(-0.21f, -0.87f, -0.29f, -0.88f, -13.85f, -0.88f)
                curveToRelative(-10.31f, -0.01f, -13.09f, -0.06f, -15.84f, -0.3f)
                curveToRelative(-10.93f, -0.93f, -18.82f, -2.57f, -26.83f, -5.57f)
                curveToRelative(-12.75f, -4.78f, -23.98f, -7.56f, -34.87f, -8.64f)
                curveToRelative(-2.45f, -0.24f, -13.35f, -0.46f, -15.46f, -0.31f)
            }
        }
            .build()
        return _foot!!
    }

private var _foot: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Foot, contentDescription = null)
    }
}
