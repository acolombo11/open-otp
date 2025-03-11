package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Twitch: ImageVector
    get() {
        if (_twitch != null) {
            return _twitch!!
        }
        _twitch = Builder(
            name = "Twitch", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF6441A5)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(20.5728f, 12.734f)
                lineTo(17.1434f, 16.1632f)
                horizontalLineTo(11.7563f)
                lineTo(8.8175f, 19.1015f)
                verticalLineTo(16.1632f)
                horizontalLineTo(4.4093f)
                verticalLineTo(1.9591f)
                horizontalLineTo(20.5728f)
                verticalLineTo(12.734f)
                close()
                moveTo(2.4494f, -0.0f)
                lineTo(1.47f, 3.9185f)
                verticalLineTo(21.5505f)
                horizontalLineTo(5.8786f)
                verticalLineTo(24.0f)
                horizontalLineTo(8.3269f)
                lineTo(10.7766f, 21.5505f)
                horizontalLineTo(14.6944f)
                lineTo(22.5309f, 13.715f)
                verticalLineTo(-0.0f)
                horizontalLineTo(2.4494f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF6441A5)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(9.7969f, 11.7552f)
                horizontalLineTo(11.756f)
                verticalLineTo(5.8768f)
                horizontalLineTo(9.7969f)
                verticalLineTo(11.7552f)
                close()
                moveTo(15.1842f, 11.7552f)
                horizontalLineTo(17.1434f)
                verticalLineTo(5.8768f)
                horizontalLineTo(15.1842f)
                verticalLineTo(11.7552f)
                close()
            }
        }
            .build()
        return _twitch!!
    }

private var _twitch: ImageVector? = null
