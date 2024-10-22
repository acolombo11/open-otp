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

public val OtpIcons.LinkedIn: ImageVector
    get() {
        if (_linkedin != null) {
            return _linkedin!!
        }
        _linkedin = Builder(name = "LinkedIn", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(20.6667f, 20.6666f)
                horizontalLineTo(17.1052f)
                verticalLineTo(14.6007f)
                curveTo(17.1052f, 12.9376f, 16.4733f, 12.0082f, 15.1569f, 12.0082f)
                curveTo(13.7249f, 12.0082f, 12.9767f, 12.9754f, 12.9767f, 14.6007f)
                verticalLineTo(20.6666f)
                horizontalLineTo(9.5444f)
                verticalLineTo(9.1111f)
                horizontalLineTo(12.9767f)
                verticalLineTo(10.6676f)
                curveTo(12.9767f, 10.6676f, 14.0087f, 8.758f, 16.4609f, 8.758f)
                curveTo(18.9119f, 8.758f, 20.6667f, 10.2548f, 20.6667f, 13.3504f)
                verticalLineTo(20.6666f)
                close()
                moveTo(5.4498f, 7.598f)
                curveTo(4.2807f, 7.598f, 3.3333f, 6.6432f, 3.3333f, 5.4657f)
                curveTo(3.3333f, 4.2881f, 4.2807f, 3.3333f, 5.4498f, 3.3333f)
                curveTo(6.6189f, 3.3333f, 7.5657f, 4.2881f, 7.5657f, 5.4657f)
                curveTo(7.5657f, 6.6432f, 6.6189f, 7.598f, 5.4498f, 7.598f)
                close()
                moveTo(3.6775f, 20.6666f)
                horizontalLineTo(7.2565f)
                verticalLineTo(9.1111f)
                horizontalLineTo(3.6775f)
                verticalLineTo(20.6666f)
                close()
            }
        }
        .build()
        return _linkedin!!
    }

private var _linkedin: ImageVector? = null
