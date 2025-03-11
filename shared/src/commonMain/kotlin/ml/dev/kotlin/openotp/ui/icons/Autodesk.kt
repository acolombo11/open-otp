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

public val OtpIcons.Autodesk: ImageVector
    get() {
        if (_autodesk != null) {
            return _autodesk!!
        }
        _autodesk = Builder(
            name = "Autodesk", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(14.6591f, 3.785f)
                lineTo(0.0f, 12.8968f)
                verticalLineTo(20.2165f)
                horizontalLineTo(0.1267f)
                lineTo(14.825f, 11.0654f)
                horizontalLineTo(22.4531f)
                curveTo(22.6884f, 11.0654f, 22.9038f, 11.2512f, 22.9038f, 11.5161f)
                curveTo(22.9038f, 11.7313f, 22.806f, 11.8199f, 22.6888f, 11.8883f)
                lineTo(15.4712f, 16.2189f)
                curveTo(15.0011f, 16.5029f, 14.8349f, 17.0614f, 14.8349f, 17.4827f)
                lineTo(14.8243f, 20.2165f)
                horizontalLineTo(24.0f)
                verticalLineTo(4.3535f)
                curveTo(24.0f, 4.0499f, 23.7652f, 3.785f, 23.4128f, 3.785f)
                lineTo(14.6591f, 3.785f)
                close()
            }
        }
            .build()
        return _autodesk!!
    }

private var _autodesk: ImageVector? = null
