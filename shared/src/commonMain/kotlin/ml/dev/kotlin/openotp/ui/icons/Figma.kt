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

public val OtpIcons.Figma: ImageVector
    get() {
        if (_figma != null) {
            return _figma!!
        }
        _figma = Builder(name = "Figma", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF0ACF83)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(8.0008f, 24.0f)
                curveTo(10.2084f, 24.0f, 12.0f, 22.208f, 12.0f, 20.0f)
                verticalLineTo(16.0f)
                horizontalLineTo(8.0008f)
                curveTo(5.7932f, 16.0f, 4.0016f, 17.792f, 4.0016f, 20.0f)
                curveTo(4.0016f, 22.208f, 5.7932f, 24.0f, 8.0008f, 24.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFA259FF)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0016f, 12.0f)
                curveTo(4.0016f, 9.792f, 5.7932f, 8.0f, 8.0008f, 8.0f)
                horizontalLineTo(12.0f)
                verticalLineTo(16.0f)
                horizontalLineTo(8.0008f)
                curveTo(5.7932f, 16.0f, 4.0016f, 14.208f, 4.0016f, 12.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFF24E1E)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(4.0016f, 4.0f)
                curveTo(4.0016f, 1.792f, 5.7932f, 0.0f, 8.0008f, 0.0f)
                horizontalLineTo(12.0f)
                verticalLineTo(8.0f)
                horizontalLineTo(8.0008f)
                curveTo(5.7932f, 8.0f, 4.0016f, 6.208f, 4.0016f, 4.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFFFF7262)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(12.0f, 0.0f)
                horizontalLineTo(15.9992f)
                curveTo(18.2068f, 0.0f, 19.9984f, 1.792f, 19.9984f, 4.0f)
                curveTo(19.9984f, 6.208f, 18.2068f, 8.0f, 15.9992f, 8.0f)
                horizontalLineTo(12.0f)
                verticalLineTo(0.0f)
                close()
            }
            path(fill = SolidColor(Color(0xFF1ABCFE)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(19.9984f, 12.0f)
                curveTo(19.9984f, 14.208f, 18.2068f, 16.0f, 15.9992f, 16.0f)
                curveTo(13.7916f, 16.0f, 12.0f, 14.208f, 12.0f, 12.0f)
                curveTo(12.0f, 9.792f, 13.7916f, 8.0f, 15.9992f, 8.0f)
                curveTo(18.2068f, 8.0f, 19.9984f, 9.792f, 19.9984f, 12.0f)
                close()
            }
        }
        .build()
        return _figma!!
    }

private var _figma: ImageVector? = null
