package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Bitwarden: ImageVector
    get() {
        if (_bitwarden != null) {
            return _bitwarden!!
        }
        _bitwarden = Builder(name = "Bitwarden", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(21.7004f, 0.2965f)
                curveTo(21.5058f, 0.1019f, 21.2649f, 0.0f, 20.9961f, 0.0f)
                horizontalLineTo(3.0008f)
                curveTo(2.732f, 0.0f, 2.4911f, 0.1019f, 2.2965f, 0.2965f)
                curveTo(2.1019f, 0.4911f, 2.0f, 0.732f, 2.0f, 1.0008f)
                verticalLineTo(13.0008f)
                curveTo(2.0f, 13.8996f, 2.1761f, 14.7799f, 2.5189f, 15.6602f)
                curveTo(2.871f, 16.5405f, 3.2973f, 17.3189f, 3.8162f, 18.0046f)
                curveTo(4.3351f, 18.6903f, 4.9467f, 19.3483f, 5.6602f, 19.9969f)
                curveTo(6.3737f, 20.6456f, 7.0317f, 21.183f, 7.634f, 21.6093f)
                curveTo(8.2363f, 22.0355f, 8.8664f, 22.4432f, 9.5243f, 22.8232f)
                curveTo(10.1822f, 23.2031f, 10.6456f, 23.4625f, 10.9236f, 23.5923f)
                curveTo(11.2015f, 23.7313f, 11.4239f, 23.8332f, 11.5907f, 23.9073f)
                curveTo(11.7112f, 23.9722f, 11.8502f, 24.0f, 11.9985f, 24.0f)
                curveTo(12.1467f, 24.0f, 12.2765f, 23.9722f, 12.4062f, 23.9073f)
                curveTo(12.573f, 23.8332f, 12.7954f, 23.7313f, 13.0734f, 23.5923f)
                curveTo(13.3514f, 23.4533f, 13.8147f, 23.2031f, 14.4726f, 22.8232f)
                curveTo(15.1305f, 22.4432f, 15.7606f, 22.0355f, 16.3629f, 21.6093f)
                curveTo(16.9653f, 21.183f, 17.6232f, 20.6456f, 18.3367f, 19.9969f)
                curveTo(19.0502f, 19.3483f, 19.6618f, 18.6903f, 20.1807f, 18.0046f)
                curveTo(20.6996f, 17.3189f, 21.1259f, 16.5405f, 21.478f, 15.6602f)
                curveTo(21.8301f, 14.7799f, 21.9969f, 13.8903f, 21.9969f, 13.0008f)
                verticalLineTo(1.0008f)
                curveTo(21.9969f, 0.732f, 21.895f, 0.5004f, 21.7004f, 0.2965f)
                close()
                moveTo(19.3838f, 13.112f)
                curveTo(19.3838f, 17.4579f, 12.0077f, 21.1923f, 12.0077f, 21.1923f)
                verticalLineTo(2.5668f)
                horizontalLineTo(19.3838f)
                curveTo(19.3838f, 2.5761f, 19.3838f, 8.766f, 19.3838f, 13.112f)
                close()
            }
        }
        .build()
        return _bitwarden!!
    }

private var _bitwarden: ImageVector? = null
