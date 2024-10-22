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

public val OtpIcons.Truenas: ImageVector
    get() {
        if (_truenas != null) {
            return _truenas!!
        }
        _truenas = Builder(name = "Truenas", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(24.0f, 10.049f)
                verticalLineTo(15.163f)
                lineTo(13.051f, 21.487f)
                verticalLineTo(16.373f)
                lineTo(24.0f, 10.049f)
                close()
                moveTo(0.0f, 10.049f)
                verticalLineTo(15.163f)
                lineTo(10.956f, 21.487f)
                verticalLineTo(16.373f)
                lineTo(0.0f, 10.049f)
                close()
                moveTo(12.004f, 9.444f)
                lineTo(7.571f, 12.003f)
                lineTo(12.004f, 14.562f)
                lineTo(16.433f, 12.003f)
                lineTo(12.004f, 9.444f)
                close()
                moveTo(22.956f, 8.237f)
                lineTo(13.051f, 2.514f)
                verticalLineTo(7.632f)
                lineTo(18.524f, 10.796f)
                lineTo(22.956f, 8.237f)
                close()
                moveTo(10.956f, 7.632f)
                verticalLineTo(2.513f)
                lineTo(1.044f, 8.236f)
                lineTo(5.476f, 10.791f)
                lineTo(10.956f, 7.632f)
                close()
            }
        }
        .build()
        return _truenas!!
    }

private var _truenas: ImageVector? = null
