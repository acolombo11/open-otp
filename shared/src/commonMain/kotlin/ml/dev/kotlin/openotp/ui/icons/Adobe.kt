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

public val OtpIcons.Adobe: ImageVector
    get() {
        if (_adobe != null) {
            return _adobe!!
        }
        _adobe = Builder(name = "Adobe", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.8814f, 1.38f)
                horizontalLineTo(0.0f)
                verticalLineTo(22.6201f)
                lineTo(8.8814f, 1.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(15.1302f, 1.38f)
                horizontalLineTo(24.0f)
                verticalLineTo(22.6201f)
                lineTo(15.1302f, 1.38f)
                close()
            }
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0058f, 9.2084f)
                lineTo(17.6586f, 22.6201f)
                horizontalLineTo(13.9499f)
                lineTo(12.2604f, 18.3501f)
                horizontalLineTo(8.1234f)
                lineTo(12.0058f, 9.2084f)
                close()
            }
        }
        .build()
        return _adobe!!
    }

private var _adobe: ImageVector? = null
