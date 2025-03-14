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

public val OtpIcons.OpenOtp: ImageVector
    get() {
        if (_openOtp != null) {
            return _openOtp!!
        }
        _openOtp = Builder(
            name = "Icon", defaultWidth = 108.0.dp, defaultHeight = 108.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF466800)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(18.0f, 11.0f)
                    curveToRelative(0.7f, 0.0f, 1.37f, 0.1f, 2.0f, 0.29f)
                    verticalLineTo(10.0f)
                    curveToRelative(0.0f, -1.1f, -0.9f, -2.0f, -2.0f, -2.0f)
                    horizontalLineToRelative(-1.0f)
                    verticalLineTo(6.0f)
                    curveToRelative(0.0f, -2.76f, -2.24f, -5.0f, -5.0f, -5.0f)
                    reflectiveCurveTo(7.0f, 3.24f, 7.0f, 6.0f)
                    verticalLineToRelative(2.0f)
                    horizontalLineTo(6.0f)
                    curveToRelative(-1.1f, 0.0f, -2.0f, 0.9f, -2.0f, 2.0f)
                    verticalLineToRelative(10.0f)
                    curveToRelative(0.0f, 1.1f, 0.9f, 2.0f, 2.0f, 2.0f)
                    horizontalLineToRelative(6.26f)
                    curveTo(11.47f, 20.87f, 11.0f, 19.49f, 11.0f, 18.0f)
                    curveTo(11.0f, 14.13f, 14.13f, 11.0f, 18.0f, 11.0f)
                    close()
                    moveTo(8.9f, 6.0f)
                    curveToRelative(0.0f, -1.71f, 1.39f, -3.1f, 3.1f, -3.1f)
                    reflectiveCurveToRelative(3.1f, 1.39f, 3.1f, 3.1f)
                    verticalLineToRelative(2.0f)
                    horizontalLineTo(8.9f)
                    verticalLineTo(6.0f)
                    close()
                }
                path(
                    fill = SolidColor(Color(0xFF466800)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(18.0f, 13.0f)
                    curveToRelative(-2.76f, 0.0f, -5.0f, 2.24f, -5.0f, 5.0f)
                    reflectiveCurveToRelative(2.24f, 5.0f, 5.0f, 5.0f)
                    reflectiveCurveToRelative(5.0f, -2.24f, 5.0f, -5.0f)
                    reflectiveCurveTo(20.76f, 13.0f, 18.0f, 13.0f)
                    close()
                    moveTo(18.0f, 15.0f)
                    curveToRelative(0.83f, 0.0f, 1.5f, 0.67f, 1.5f, 1.5f)
                    reflectiveCurveTo(18.83f, 18.0f, 18.0f, 18.0f)
                    reflectiveCurveToRelative(-1.5f, -0.67f, -1.5f, -1.5f)
                    reflectiveCurveTo(17.17f, 15.0f, 18.0f, 15.0f)
                    close()
                    moveTo(18.0f, 21.0f)
                    curveToRelative(-1.03f, 0.0f, -1.94f, -0.52f, -2.48f, -1.32f)
                    curveTo(16.25f, 19.26f, 17.09f, 19.0f, 18.0f, 19.0f)
                    reflectiveCurveToRelative(1.75f, 0.26f, 2.48f, 0.68f)
                    curveTo(19.94f, 20.48f, 19.03f, 21.0f, 18.0f, 21.0f)
                    close()
                }
            }
        }
            .build()
        return _openOtp!!
    }

private var _openOtp: ImageVector? = null
