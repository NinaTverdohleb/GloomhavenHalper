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
                fill = SolidColor(Color(0xFF241c1c)), stroke = null, strokeLineWidth = 0.0f,
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
            path(
                fill = SolidColor(Color(0xFFfbfbfb)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(0.0f, 200.0f)
                verticalLineToRelative(200.0f)
                horizontalLineToRelative(400.0f)
                verticalLineTo(0.0f)
                horizontalLineTo(0.0f)
                verticalLineToRelative(200.0f)
                moveTo(264.83f, 40.26f)
                curveToRelative(11.9f, 3.02f, 17.6f, 22.09f, 11.81f, 39.47f)
                curveToRelative(-0.36f, 1.09f, -0.6f, 2.04f, -0.52f, 2.12f)
                curveToRelative(0.22f, 0.21f, 5.21f, 0.77f, 12.55f, 1.4f)
                curveToRelative(21.84f, 1.88f, 30.08f, 3.36f, 35.15f, 6.34f)
                curveToRelative(3.9f, 2.28f, 6.61f, 10.02f, 6.29f, 17.91f)
                curveToRelative(-0.46f, 11.3f, -5.29f, 21.34f, -19.63f, 40.77f)
                curveToRelative(-5.38f, 7.29f, -7.26f, 10.15f, -8.06f, 12.27f)
                curveToRelative(-0.56f, 1.51f, -0.63f, 1.31f, 1.19f, 3.56f)
                curveToRelative(40.78f, 50.38f, 55.67f, 128.13f, 32.05f, 167.32f)
                curveToRelative(-7.76f, 12.88f, -19.86f, 23.07f, -31.54f, 26.58f)
                curveToRelative(-10.97f, 3.29f, -20.12f, 2.9f, -42.37f, -1.81f)
                curveToRelative(-21.91f, -4.64f, -30.56f, -4.67f, -49.99f, -0.18f)
                curveToRelative(-11.44f, 2.65f, -15.97f, 3.24f, -24.84f, 3.24f)
                curveToRelative(-6.04f, 0.0f, -7.51f, -0.1f, -13.59f, -0.85f)
                curveToRelative(-13.54f, -1.68f, -36.63f, -7.81f, -47.25f, -12.55f)
                curveToRelative(-31.07f, -13.86f, -42.27f, -49.68f, -29.48f, -94.31f)
                curveToRelative(4.02f, -14.02f, 8.13f, -22.94f, 14.65f, -31.79f)
                curveToRelative(8.04f, -10.92f, 11.55f, -18.08f, 13.25f, -27.03f)
                curveToRelative(0.5f, -2.65f, 1.49f, -10.11f, 1.36f, -10.26f)
                curveToRelative(-0.64f, -0.67f, -8.05f, -0.95f, -10.77f, -0.4f)
                curveToRelative(-5.87f, 1.18f, -10.37f, 3.7f, -21.17f, 11.85f)
                curveToRelative(-9.51f, 7.16f, -14.24f, 10.31f, -21.25f, 14.15f)
                curveToRelative(-2.99f, 1.63f, -2.76f, 1.62f, -2.5f, 0.14f)
                curveToRelative(1.03f, -5.77f, -0.86f, -11.88f, -8.25f, -26.62f)
                curveToRelative(-6.91f, -13.77f, -8.21f, -16.93f, -8.75f, -21.28f)
                curveToRelative(-0.9f, -7.13f, 4.74f, -10.51f, 20.08f, -12.04f)
                curveToRelative(6.54f, -0.64f, 23.12f, -0.79f, 32.0f, -0.27f)
                curveToRelative(6.47f, 0.38f, 11.15f, 0.69f, 16.64f, 1.11f)
                curveToRelative(3.1f, 0.23f, 5.68f, 0.39f, 5.72f, 0.34f)
                curveToRelative(0.05f, -0.04f, -0.96f, -1.34f, -2.23f, -2.89f)
                curveToRelative(-24.53f, -29.59f, -32.49f, -58.89f, -21.1f, -77.62f)
                curveToRelative(6.78f, -11.14f, 14.97f, -12.2f, 30.09f, -3.89f)
                curveToRelative(1.59f, 0.87f, 5.69f, 3.27f, 9.13f, 5.33f)
                curveToRelative(9.63f, 5.77f, 14.23f, 8.22f, 19.95f, 10.61f)
                curveToRelative(10.3f, 4.3f, 23.31f, 7.56f, 30.3f, 7.59f)
                lineToRelative(2.5f, 0.01f)
                lineToRelative(1.28f, -0.61f)
                curveToRelative(1.62f, -0.77f, 3.28f, -1.89f, 5.59f, -3.78f)
                curveToRelative(3.32f, -2.71f, 4.61f, -3.91f, 14.8f, -13.71f)
                curveToRelative(26.53f, -25.53f, 37.52f, -32.6f, 46.91f, -30.22f)
                moveTo(145.26f, 156.03f)
                curveToRelative(-0.06f, 0.4f, -0.25f, 2.07f, -0.44f, 3.72f)
                curveToRelative(-0.18f, 1.65f, -0.78f, 6.97f, -1.33f, 11.81f)
                curveToRelative(-0.54f, 4.85f, -0.99f, 9.06f, -0.99f, 9.37f)
                curveToRelative(0.0f, 0.65f, -0.41f, 0.54f, 4.75f, 1.31f)
                curveToRelative(26.18f, 3.93f, 45.21f, 5.41f, 56.75f, 4.41f)
                curveToRelative(4.13f, -0.36f, 9.15f, -1.25f, 23.75f, -4.23f)
                curveToRelative(5.23f, -1.07f, 12.2f, -2.49f, 15.5f, -3.16f)
                curveToRelative(21.91f, -4.47f, 33.02f, -5.83f, 36.73f, -4.52f)
                curveToRelative(5.91f, 2.09f, 6.46f, -7.28f, 0.75f, -12.75f)
                curveToRelative(-6.34f, -6.07f, -12.92f, -6.51f, -56.31f, -3.82f)
                curveToRelative(-5.87f, 0.36f, -12.62f, 0.78f, -15.0f, 0.92f)
                curveToRelative(-5.68f, 0.34f, -17.8f, 0.51f, -20.0f, 0.27f)
                curveToRelative(-0.92f, -0.09f, -3.62f, -0.4f, -6.0f, -0.68f)
                curveToRelative(-6.55f, -0.76f, -22.18f, -2.16f, -32.67f, -2.92f)
                curveToRelative(-1.93f, -0.14f, -3.93f, -0.3f, -4.45f, -0.36f)
                lineToRelative(-0.94f, -0.1f)
                lineToRelative(-0.1f, 0.73f)
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
