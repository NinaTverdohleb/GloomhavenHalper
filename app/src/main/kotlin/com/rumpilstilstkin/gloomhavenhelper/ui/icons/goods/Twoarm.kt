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

public val GloomhavenIcons.GoodTypes.Twoarm: ImageVector
    get() {
        if (_twoarm != null) {
            return _twoarm!!
        }
        _twoarm = Builder(
            name = "Twoarm",
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
                moveTo(198.42f, 48.0f)
                curveToRelative(-1.8f, 0.23f, -3.08f, 0.7f, -4.61f, 1.69f)
                curveToRelative(-5.18f, 3.38f, -16.86f, 14.1f, -34.91f, 32.02f)
                curveToRelative(-4.5f, 4.47f, -8.26f, 8.12f, -8.35f, 8.12f)
                curveToRelative(-0.1f, 0.0f, -2.67f, -0.78f, -5.71f, -1.75f)
                curveToRelative(-3.04f, -0.96f, -5.68f, -1.75f, -5.86f, -1.75f)
                curveToRelative(-0.17f, 0.0f, -1.69f, 0.92f, -3.36f, 2.03f)
                curveToRelative(-13.54f, 9.04f, -23.58f, 18.22f, -27.88f, 25.5f)
                curveToRelative(-4.27f, 7.23f, -5.53f, 20.72f, -3.28f, 35.14f)
                curveToRelative(1.11f, 7.13f, -1.05f, 30.51f, -3.3f, 35.63f)
                curveToRelative(-2.29f, 5.22f, -29.44f, 23.86f, -73.47f, 50.45f)
                curveToRelative(-1.96f, 1.18f, -3.59f, 2.24f, -3.63f, 2.35f)
                curveToRelative(-0.24f, 0.63f, 4.24f, 11.48f, 7.46f, 18.07f)
                curveToRelative(4.94f, 10.1f, 12.51f, 22.45f, 17.05f, 27.81f)
                curveToRelative(0.75f, 0.88f, 3.19f, 3.78f, 5.43f, 6.44f)
                lineToRelative(5.83f, 6.92f)
                curveToRelative(0.97f, 1.14f, 2.97f, 3.5f, 4.45f, 5.25f)
                curveToRelative(7.22f, 8.53f, 21.01f, 20.6f, 33.47f, 29.3f)
                curveToRelative(3.38f, 2.36f, 8.54f, 5.66f, 8.74f, 5.58f)
                curveToRelative(0.12f, -0.04f, 8.12f, -7.4f, 21.18f, -19.47f)
                curveToRelative(7.39f, -6.83f, 9.11f, -8.42f, 15.92f, -14.76f)
                curveToRelative(1.46f, -1.37f, 4.2f, -3.91f, 6.07f, -5.65f)
                curveToRelative(10.19f, -9.47f, 19.55f, -18.32f, 22.91f, -21.65f)
                curveToRelative(4.19f, -4.17f, 4.23f, -4.18f, 26.6f, -7.35f)
                curveToRelative(16.07f, -2.28f, 15.83f, -2.18f, 29.91f, -11.59f)
                curveToRelative(5.76f, -3.85f, 8.93f, -6.03f, 22.84f, -15.76f)
                curveToRelative(17.9f, -12.52f, 25.42f, -17.6f, 29.22f, -19.74f)
                curveToRelative(6.01f, -3.38f, 9.82f, -8.28f, 16.78f, -21.52f)
                curveToRelative(0.98f, -1.86f, 2.16f, -3.97f, 2.61f, -4.67f)
                curveToRelative(2.15f, -3.35f, 2.33f, -7.22f, 0.5f, -10.71f)
                curveToRelative(-1.23f, -2.36f, -3.4f, -3.96f, -10.78f, -7.93f)
                curveToRelative(-0.73f, -0.39f, -1.57f, -0.85f, -1.86f, -1.03f)
                lineToRelative(-0.53f, -0.31f)
                lineToRelative(0.92f, -2.04f)
                curveToRelative(3.8f, -8.45f, 6.21f, -15.38f, 6.22f, -17.9f)
                curveToRelative(0.01f, -3.05f, -5.68f, -14.93f, -9.28f, -19.37f)
                curveToRelative(-1.96f, -2.42f, -5.18f, -3.84f, -10.61f, -4.7f)
                lineToRelative(-1.31f, -0.2f)
                lineToRelative(0.1f, -0.48f)
                curveToRelative(0.81f, -4.08f, 2.58f, -18.41f, 2.71f, -21.98f)
                curveToRelative(0.12f, -3.28f, 0.0f, -3.8f, -1.31f, -5.57f)
                curveToRelative(-3.63f, -4.92f, -19.01f, -17.54f, -22.07f, -18.11f)
                curveToRelative(-2.37f, -0.44f, -10.25f, 1.12f, -15.22f, 3.0f)
                curveToRelative(-1.12f, 0.43f, -0.96f, 0.79f, -1.26f, -2.91f)
                curveToRelative(-1.25f, -15.42f, -3.36f, -25.26f, -5.99f, -27.96f)
                curveToRelative(-3.75f, -3.85f, -24.9f, -9.37f, -32.34f, -8.44f)
                moveToRelative(72.66f, 15.4f)
                curveToRelative(-1.77f, 0.36f, -3.07f, 1.1f, -6.2f, 3.5f)
                curveToRelative(-1.8f, 1.38f, -1.73f, 1.24f, -0.84f, 1.75f)
                curveToRelative(4.88f, 2.75f, 16.24f, 11.94f, 21.8f, 17.62f)
                curveToRelative(9.12f, 9.33f, 10.62f, 14.64f, 8.72f, 30.99f)
                lineToRelative(-0.1f, 0.84f)
                lineToRelative(0.98f, 0.73f)
                curveToRelative(4.09f, 3.06f, 8.02f, 8.48f, 12.12f, 16.67f)
                curveToRelative(6.74f, 13.47f, 7.57f, 19.52f, 4.12f, 29.99f)
                lineToRelative(-0.52f, 1.57f)
                lineToRelative(1.56f, 1.59f)
                curveToRelative(9.3f, 9.51f, 10.94f, 24.55f, 3.87f, 35.52f)
                curveToRelative(-0.38f, 0.59f, -1.51f, 2.62f, -2.5f, 4.5f)
                curveToRelative(-8.48f, 16.06f, -14.59f, 23.38f, -23.59f, 28.33f)
                curveToRelative(-2.86f, 1.56f, -8.96f, 5.68f, -24.08f, 16.23f)
                curveToRelative(-40.68f, 28.37f, -41.94f, 29.11f, -53.59f, 31.43f)
                curveToRelative(-3.13f, 0.62f, -5.98f, 1.06f, -16.5f, 2.51f)
                curveToRelative(-2.7f, 0.37f, -6.26f, 0.91f, -7.91f, 1.19f)
                lineToRelative(-3.0f, 0.52f)
                lineToRelative(-1.6f, 1.52f)
                curveToRelative(-8.31f, 7.92f, -11.97f, 11.37f, -18.67f, 17.61f)
                curveToRelative(-4.27f, 3.98f, -10.24f, 9.53f, -13.27f, 12.32f)
                curveToRelative(-3.04f, 2.8f, -5.52f, 5.17f, -5.53f, 5.27f)
                curveToRelative(-0.02f, 0.23f, 3.13f, 3.19f, 6.91f, 6.5f)
                curveToRelative(7.94f, 6.94f, 16.91f, 13.72f, 24.32f, 18.36f)
                curveToRelative(2.84f, 1.77f, 2.61f, 1.72f, 3.55f, 0.85f)
                curveToRelative(0.43f, -0.4f, 3.07f, -2.83f, 5.86f, -5.39f)
                curveToRelative(2.8f, -2.57f, 6.58f, -6.06f, 8.41f, -7.75f)
                curveToRelative(1.84f, -1.7f, 3.83f, -3.53f, 4.43f, -4.08f)
                curveToRelative(0.6f, -0.55f, 1.65f, -1.52f, 2.34f, -2.17f)
                curveToRelative(0.68f, -0.65f, 3.72f, -3.46f, 6.74f, -6.26f)
                curveToRelative(17.29f, -15.97f, 32.09f, -29.86f, 37.0f, -34.71f)
                curveToRelative(4.63f, -4.56f, 5.11f, -4.71f, 24.01f, -7.36f)
                curveToRelative(17.94f, -2.52f, 18.53f, -2.7f, 26.41f, -7.73f)
                curveToRelative(6.5f, -4.14f, 12.68f, -8.37f, 31.96f, -21.84f)
                curveToRelative(3.25f, -2.27f, 7.85f, -5.47f, 12.41f, -8.62f)
                curveToRelative(5.05f, -3.51f, 10.33f, -6.99f, 12.82f, -8.46f)
                curveToRelative(4.19f, -2.47f, 4.68f, -2.82f, 6.48f, -4.61f)
                curveToRelative(3.58f, -3.55f, 6.42f, -7.83f, 11.47f, -17.27f)
                curveToRelative(1.38f, -2.58f, 2.77f, -5.1f, 3.1f, -5.59f)
                curveToRelative(2.35f, -3.54f, 1.91f, -8.88f, -1.0f, -12.12f)
                curveToRelative(-1.17f, -1.29f, -4.15f, -3.21f, -9.9f, -6.35f)
                curveToRelative(-1.06f, -0.58f, -1.94f, -1.06f, -1.96f, -1.08f)
                curveToRelative(-0.02f, -0.01f, 0.53f, -1.3f, 1.22f, -2.85f)
                curveToRelative(3.62f, -8.15f, 5.9f, -14.75f, 5.9f, -17.1f)
                curveToRelative(0.01f, -2.79f, -5.28f, -14.11f, -8.73f, -18.69f)
                curveToRelative(-2.19f, -2.91f, -4.65f, -4.17f, -10.11f, -5.18f)
                curveToRelative(-1.2f, -0.22f, -2.22f, -0.44f, -2.26f, -0.48f)
                curveToRelative(-0.04f, -0.04f, 0.16f, -1.49f, 0.43f, -3.22f)
                curveToRelative(2.03f, -12.84f, 2.75f, -21.72f, 1.89f, -23.34f)
                curveToRelative(-1.81f, -3.37f, -11.85f, -12.41f, -20.04f, -18.04f)
                curveToRelative(-3.32f, -2.28f, -6.27f, -2.13f, -15.93f, 0.82f)
                curveToRelative(-1.56f, 0.48f, -2.94f, 0.9f, -3.09f, 0.94f)
                curveToRelative(-0.21f, 0.06f, -0.28f, -0.37f, -0.46f, -2.98f)
                curveToRelative(-1.01f, -14.88f, -3.37f, -25.75f, -6.12f, -28.29f)
                curveToRelative(-4.55f, -4.2f, -26.4f, -9.51f, -33.33f, -8.11f)
                moveToRelative(-87.16f, 17.69f)
                curveToRelative(3.51f, 0.92f, 19.65f, 13.42f, 30.75f, 23.83f)
                curveToRelative(27.18f, 25.51f, 47.33f, 53.07f, 60.53f, 82.83f)
                curveToRelative(3.71f, 8.35f, 4.36f, 10.34f, 3.99f, 12.2f)
                curveToRelative(-0.94f, 4.71f, -6.12f, 7.02f, -10.07f, 4.5f)
                curveToRelative(-1.62f, -1.04f, -2.01f, -1.63f, -3.61f, -5.52f)
                curveToRelative(-6.21f, -15.01f, -15.49f, -31.75f, -24.43f, -44.01f)
                curveToRelative(-17.96f, -24.65f, -40.63f, -47.27f, -61.2f, -61.06f)
                curveToRelative(-1.91f, -1.28f, -2.75f, -2.14f, -3.43f, -3.52f)
                curveToRelative(-2.4f, -4.87f, 2.24f, -10.61f, 7.47f, -9.25f)
            }
        }
            .build()
        return _twoarm!!
    }

private var _twoarm: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Twoarm, contentDescription = null)
    }
}
