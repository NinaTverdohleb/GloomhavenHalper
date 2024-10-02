package com.rumpilstilstkin.gloomhavenhelper.ui.icons.goods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
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

public val GloomhavenIcons.GoodTypes.Arm: ImageVector
    get() {
        if (_arm != null) {
            return _arm!!
        }
        _arm = Builder(
            name = "Arm",
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
                moveTo(239.58f, 39.93f)
                curveToRelative(-2.17f, 0.33f, -2.84f, 0.49f, -3.72f, 0.9f)
                curveToRelative(-3.12f, 1.48f, -9.12f, 6.45f, -19.61f, 16.25f)
                curveToRelative(-3.71f, 3.46f, -13.73f, 13.12f, -16.3f, 15.71f)
                lineToRelative(-2.13f, 2.15f)
                lineToRelative(1.71f, 0.63f)
                curveToRelative(12.54f, 4.61f, 22.92f, 9.69f, 25.65f, 12.55f)
                curveToRelative(9.64f, 10.06f, 26.38f, 38.79f, 34.66f, 59.46f)
                curveToRelative(5.7f, 14.23f, 9.39f, 31.74f, 7.9f, 37.51f)
                curveToRelative(-2.27f, 8.84f, -20.74f, 19.32f, -43.74f, 24.81f)
                curveToRelative(-10.94f, 2.61f, -15.48f, 2.81f, -19.44f, 0.87f)
                curveToRelative(-13.55f, -6.65f, -27.46f, -23.15f, -39.48f, -46.83f)
                curveToRelative(-2.58f, -5.09f, -0.32f, -8.34f, 8.42f, -12.08f)
                curveToRelative(2.88f, -1.23f, 2.52f, -1.27f, 3.43f, 0.42f)
                curveToRelative(8.41f, 15.62f, 19.78f, 30.76f, 27.4f, 36.51f)
                curveToRelative(5.65f, 4.25f, 8.97f, 5.13f, 14.5f, 3.82f)
                curveToRelative(17.03f, -4.04f, 28.05f, -8.98f, 30.43f, -13.64f)
                curveToRelative(1.91f, -3.73f, -1.62f, -19.04f, -7.59f, -32.97f)
                curveToRelative(-4.61f, -10.76f, -15.04f, -28.15f, -22.21f, -37.05f)
                lineToRelative(-0.38f, -0.46f)
                lineToRelative(-2.41f, 1.44f)
                curveToRelative(-11.85f, 7.08f, -26.29f, 14.93f, -28.75f, 15.62f)
                curveToRelative(-1.04f, 0.3f, -2.1f, 0.07f, -3.14f, -0.67f)
                curveToRelative(-2.44f, -1.75f, -5.35f, -7.31f, -5.57f, -10.66f)
                lineToRelative(-0.09f, -1.37f)
                lineToRelative(2.51f, -1.63f)
                curveToRelative(4.11f, -2.68f, 12.93f, -8.15f, 21.62f, -13.42f)
                curveToRelative(4.0f, -2.42f, 4.52f, -2.76f, 4.4f, -2.85f)
                curveToRelative(-0.03f, -0.03f, -2.17f, -0.87f, -4.73f, -1.87f)
                curveToRelative(-4.71f, -1.82f, -9.98f, -3.88f, -15.5f, -6.03f)
                curveToRelative(-1.65f, -0.65f, -5.44f, -1.94f, -8.42f, -2.88f)
                curveToRelative(-2.98f, -0.94f, -5.5f, -1.74f, -5.6f, -1.78f)
                curveToRelative(-0.22f, -0.09f, -7.02f, 4.42f, -10.48f, 6.95f)
                curveToRelative(-14.38f, 10.49f, -22.99f, 19.59f, -26.15f, 27.62f)
                curveToRelative(-3.24f, 8.24f, -3.84f, 22.71f, -1.54f, 36.87f)
                curveToRelative(0.41f, 2.49f, 0.39f, 3.58f, -0.14f, 11.67f)
                curveToRelative(-0.96f, 14.33f, -2.54f, 24.23f, -4.29f, 26.81f)
                curveToRelative(-4.46f, 6.58f, -39.17f, 30.15f, -82.13f, 55.77f)
                curveToRelative(-1.52f, 0.9f, -2.79f, 1.67f, -2.83f, 1.71f)
                curveToRelative(-0.43f, 0.36f, 5.4f, 14.36f, 8.87f, 21.29f)
                curveToRelative(4.56f, 9.13f, 12.36f, 22.02f, 16.77f, 27.74f)
                lineToRelative(0.31f, 0.4f)
                lineToRelative(4.48f, -1.54f)
                curveToRelative(2.47f, -0.85f, 7.07f, -2.43f, 10.23f, -3.52f)
                curveToRelative(3.16f, -1.08f, 8.82f, -3.03f, 12.58f, -4.33f)
                curveToRelative(6.87f, -2.36f, 14.62f, -5.03f, 20.86f, -7.18f)
                curveToRelative(3.61f, -1.23f, 4.21f, -1.34f, 4.73f, -0.82f)
                curveToRelative(0.7f, 0.71f, 0.48f, 1.21f, -1.81f, 4.17f)
                curveToRelative(-4.44f, 5.74f, -23.4f, 30.26f, -26.48f, 34.25f)
                curveToRelative(-1.77f, 2.29f, -3.21f, 4.21f, -3.21f, 4.27f)
                curveToRelative(0.0f, 0.7f, 14.06f, 13.58f, 20.83f, 19.08f)
                curveToRelative(7.88f, 6.4f, 21.23f, 15.89f, 23.14f, 16.44f)
                curveToRelative(0.15f, 0.04f, 2.7f, -2.27f, 14.36f, -13.04f)
                curveToRelative(36.06f, -33.3f, 53.18f, -49.31f, 59.23f, -55.38f)
                curveToRelative(4.18f, -4.2f, 5.3f, -4.53f, 25.52f, -7.37f)
                curveToRelative(13.69f, -1.93f, 18.23f, -2.76f, 21.25f, -3.93f)
                curveToRelative(4.43f, -1.71f, 16.95f, -10.01f, 48.33f, -32.07f)
                curveToRelative(1.33f, -0.93f, 3.88f, -2.71f, 5.67f, -3.94f)
                curveToRelative(1.79f, -1.24f, 4.45f, -3.08f, 5.92f, -4.09f)
                curveToRelative(4.04f, -2.8f, 9.76f, -6.54f, 12.0f, -7.85f)
                curveToRelative(4.67f, -2.75f, 4.94f, -2.94f, 6.75f, -4.7f)
                curveToRelative(4.21f, -4.12f, 7.37f, -8.9f, 13.53f, -20.5f)
                curveToRelative(1.15f, -2.16f, 2.43f, -4.45f, 2.85f, -5.1f)
                curveToRelative(3.1f, -4.79f, 1.82f, -11.69f, -2.79f, -14.98f)
                curveToRelative(-1.43f, -1.03f, -6.52f, -4.04f, -9.2f, -5.45f)
                curveToRelative(-1.23f, -0.64f, -2.23f, -1.23f, -2.23f, -1.3f)
                curveToRelative(0.0f, -0.07f, 0.67f, -1.62f, 1.48f, -3.44f)
                curveToRelative(4.05f, -9.1f, 6.36f, -15.84f, 6.36f, -18.6f)
                curveToRelative(0.0f, -3.02f, -5.06f, -14.17f, -9.05f, -19.93f)
                curveToRelative(-2.89f, -4.19f, -4.97f, -5.22f, -14.09f, -6.97f)
                curveToRelative(-0.27f, -0.06f, -0.36f, -0.16f, -0.3f, -0.36f)
                curveToRelative(0.26f, -0.88f, 1.93f, -12.52f, 2.53f, -17.62f)
                curveToRelative(1.0f, -8.51f, 0.81f, -10.88f, -1.04f, -13.3f)
                curveToRelative(-3.81f, -4.96f, -20.5f, -18.89f, -23.69f, -19.78f)
                curveToRelative(-2.43f, -0.68f, -8.47f, 0.34f, -15.57f, 2.61f)
                curveToRelative(-1.63f, 0.52f, -2.98f, 0.91f, -3.02f, 0.87f)
                curveToRelative(-0.03f, -0.04f, -0.19f, -1.72f, -0.34f, -3.74f)
                curveToRelative(-1.22f, -16.16f, -3.77f, -27.99f, -6.64f, -30.78f)
                curveToRelative(-4.29f, -4.17f, -28.04f, -10.46f, -35.38f, -9.37f)
            }
        }
            .build()
        return _arm!!
    }

private var _arm: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Arm, contentDescription = null)
    }
}
