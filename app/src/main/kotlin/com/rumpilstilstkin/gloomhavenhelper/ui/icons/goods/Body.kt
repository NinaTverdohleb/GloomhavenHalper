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

public val GloomhavenIcons.GoodTypes.Body: ImageVector
    get() {
        if (_body2 != null) {
            return _body2!!
        }
        _body2 = Builder(
            name = "Body2",
            defaultWidth = 400.0.dp,
            defaultHeight = 400.0.dp,
            viewportWidth = 400.0f,
            viewportHeight = 400.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF140c0c)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(129.17f, 38.5f)
                curveToRelative(-8.32f, 2.38f, -32.22f, 18.2f, -68.0f, 45.01f)
                curveToRelative(-13.54f, 10.14f, -27.3f, 20.7f, -27.44f, 21.06f)
                curveToRelative(-0.16f, 0.42f, 1.63f, 5.89f, 3.99f, 12.18f)
                curveToRelative(8.91f, 23.77f, 28.49f, 50.19f, 48.2f, 65.02f)
                lineToRelative(1.25f, 0.94f)
                verticalLineToRelative(77.13f)
                curveToRelative(0.0f, 42.42f, 0.04f, 77.25f, 0.1f, 77.4f)
                curveToRelative(0.7f, 1.83f, 11.62f, 7.85f, 20.56f, 11.34f)
                curveToRelative(45.66f, 17.8f, 138.68f, 17.8f, 184.34f, 0.0f)
                curveToRelative(8.94f, -3.49f, 19.86f, -9.51f, 20.56f, -11.34f)
                curveToRelative(0.06f, -0.15f, 0.1f, -34.98f, 0.1f, -77.4f)
                verticalLineToRelative(-77.13f)
                lineToRelative(1.25f, -0.94f)
                curveToRelative(19.71f, -14.83f, 39.29f, -41.25f, 48.21f, -65.02f)
                curveToRelative(2.35f, -6.29f, 4.14f, -11.76f, 3.98f, -12.18f)
                curveToRelative(-0.14f, -0.35f, -14.01f, -11.0f, -27.36f, -21.0f)
                curveToRelative(-30.09f, -22.54f, -51.16f, -36.93f, -62.49f, -42.65f)
                curveToRelative(-8.93f, -4.51f, -10.83f, -4.07f, -21.74f, 5.05f)
                curveToRelative(-8.96f, 7.49f, -14.44f, 10.94f, -22.26f, 14.02f)
                curveToRelative(-18.69f, 7.34f, -46.15f, 7.34f, -64.84f, 0.0f)
                curveToRelative(-7.82f, -3.08f, -13.3f, -6.53f, -22.26f, -14.02f)
                curveToRelative(-8.82f, -7.38f, -11.74f, -8.73f, -16.15f, -7.47f)
                moveToRelative(55.29f, 82.53f)
                curveToRelative(3.02f, 1.43f, 4.15f, 8.09f, 3.69f, 21.8f)
                curveToRelative(-0.7f, 21.36f, -4.85f, 36.63f, -11.53f, 42.51f)
                curveToRelative(-7.18f, 6.31f, -28.43f, 11.89f, -48.98f, 12.85f)
                curveToRelative(-12.6f, 0.59f, -18.14f, -1.35f, -18.14f, -6.36f)
                curveToRelative(0.0f, -4.23f, 3.32f, -5.92f, 39.08f, -19.9f)
                curveToRelative(2.75f, -1.08f, 6.33f, -2.49f, 7.95f, -3.13f)
                lineToRelative(2.94f, -1.17f)
                lineToRelative(0.37f, -0.94f)
                curveToRelative(0.2f, -0.52f, 1.14f, -2.96f, 2.08f, -5.44f)
                curveToRelative(9.11f, -23.87f, 14.38f, -35.98f, 16.88f, -38.77f)
                curveToRelative(1.66f, -1.85f, 3.71f, -2.38f, 5.66f, -1.45f)
                moveToRelative(36.39f, 0.07f)
                curveToRelative(2.57f, 1.29f, 5.86f, 7.8f, 12.76f, 25.23f)
                curveToRelative(3.05f, 7.7f, 3.64f, 9.22f, 5.05f, 12.92f)
                curveToRelative(0.81f, 2.11f, 1.86f, 4.86f, 2.35f, 6.11f)
                lineToRelative(0.87f, 2.28f)
                lineToRelative(2.94f, 1.16f)
                curveToRelative(1.61f, 0.64f, 4.99f, 1.97f, 7.51f, 2.96f)
                curveToRelative(36.28f, 14.19f, 39.5f, 15.83f, 39.5f, 20.07f)
                curveToRelative(0.0f, 4.59f, -4.15f, 6.42f, -14.5f, 6.4f)
                curveToRelative(-18.37f, -0.03f, -41.14f, -5.15f, -50.5f, -11.35f)
                curveToRelative(-7.53f, -4.99f, -11.73f, -16.9f, -13.37f, -37.88f)
                curveToRelative(-0.34f, -4.39f, -0.28f, -17.46f, 0.09f, -20.5f)
                curveToRelative(0.55f, -4.52f, 1.12f, -5.91f, 3.0f, -7.33f)
                curveToRelative(0.96f, -0.72f, 2.95f, -0.76f, 4.3f, -0.07f)
                moveToRelative(-18.59f, 82.75f)
                curveToRelative(3.43f, 0.62f, 4.98f, 2.93f, 8.27f, 12.4f)
                curveToRelative(3.39f, 9.71f, 5.78f, 14.52f, 8.39f, 16.89f)
                curveToRelative(1.62f, 1.46f, 7.61f, 4.78f, 13.91f, 7.7f)
                curveToRelative(13.65f, 6.32f, 15.14f, 7.12f, 16.38f, 8.78f)
                curveToRelative(1.83f, 2.43f, 0.77f, 5.76f, -2.26f, 7.13f)
                curveToRelative(-5.9f, 2.67f, -28.22f, 0.04f, -37.53f, -4.41f)
                curveToRelative(-3.8f, -1.83f, -5.13f, -3.11f, -7.63f, -7.38f)
                curveToRelative(-0.57f, -0.98f, -1.08f, -1.78f, -1.12f, -1.78f)
                curveToRelative(-0.05f, 0.0f, -0.56f, 0.81f, -1.14f, 1.79f)
                curveToRelative(-2.52f, 4.28f, -3.59f, 5.35f, -7.11f, 7.1f)
                curveToRelative(-9.38f, 4.66f, -31.94f, 7.44f, -38.03f, 4.68f)
                curveToRelative(-3.24f, -1.46f, -4.16f, -4.95f, -1.95f, -7.41f)
                curveToRelative(1.39f, -1.54f, 4.02f, -2.98f, 12.39f, -6.79f)
                curveToRelative(8.9f, -4.04f, 16.12f, -7.97f, 17.84f, -9.7f)
                curveToRelative(2.62f, -2.63f, 4.73f, -6.87f, 7.81f, -15.72f)
                curveToRelative(4.2f, -12.03f, 6.21f, -14.29f, 11.78f, -13.28f)
                moveToRelative(1.47f, 64.29f)
                curveToRelative(2.55f, 1.26f, 4.03f, 3.83f, 6.77f, 11.78f)
                curveToRelative(3.27f, 9.5f, 5.46f, 14.01f, 8.08f, 16.67f)
                curveToRelative(1.71f, 1.73f, 8.55f, 5.48f, 17.25f, 9.46f)
                curveToRelative(10.79f, 4.92f, 12.75f, 6.07f, 13.75f, 8.03f)
                curveToRelative(1.3f, 2.53f, 0.0f, 5.51f, -2.88f, 6.59f)
                curveToRelative(-6.26f, 2.35f, -26.95f, -0.01f, -36.54f, -4.16f)
                curveToRelative(-4.11f, -1.78f, -5.88f, -3.45f, -8.51f, -7.97f)
                curveToRelative(-1.05f, -1.81f, -0.94f, -1.76f, -1.55f, -0.66f)
                curveToRelative(-2.62f, 4.78f, -4.74f, 6.83f, -8.87f, 8.61f)
                curveToRelative(-9.77f, 4.19f, -30.32f, 6.54f, -36.6f, 4.18f)
                curveToRelative(-3.14f, -1.18f, -4.34f, -4.59f, -2.53f, -7.19f)
                curveToRelative(0.99f, -1.43f, 4.91f, -3.61f, 13.48f, -7.48f)
                curveToRelative(6.37f, -2.87f, 13.5f, -6.63f, 16.03f, -8.43f)
                curveToRelative(2.87f, -2.05f, 5.4f, -6.72f, 8.64f, -15.99f)
                curveToRelative(3.37f, -9.63f, 4.71f, -12.12f, 7.21f, -13.39f)
                curveToRelative(1.74f, -0.89f, 4.52f, -0.91f, 6.27f, -0.05f)
            }
        }
            .build()
        return _body2!!
    }

private var _body2: ImageVector? = null

@Preview
@Composable
private fun Preview() {
    Box(modifier = Modifier.padding(12.dp)) {
        Image(imageVector = GloomhavenIcons.GoodTypes.Body, contentDescription = null)
    }
}
