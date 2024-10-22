package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Wise: ImageVector
    get() {
        if (_wise != null) {
            return _wise!!
        }
        _wise = Builder(name = "Wise", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            group {
                path(fill = SolidColor(Color(0xFF00B9FF)), stroke = null, strokeLineWidth = 0.0f,
                        strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                        pathFillType = NonZero) {
                    moveTo(7.3767f, 6.3656f)
                    lineTo(0.71f, 12.7312f)
                    horizontalLineTo(12.0433f)
                    lineTo(13.2261f, 9.957f)
                    horizontalLineTo(7.4842f)
                    lineTo(11.0756f, 6.3656f)
                    lineTo(8.9896f, 2.7742f)
                    horizontalLineTo(18.7315f)
                    lineTo(9.7423f, 24.0f)
                    horizontalLineTo(13.1186f)
                    lineTo(23.2907f, 0.0f)
                    horizontalLineTo(3.6347f)
                    lineTo(7.3767f, 6.3656f)
                    close()
                }
            }
        }
        .build()
        return _wise!!
    }

private var _wise: ImageVector? = null
