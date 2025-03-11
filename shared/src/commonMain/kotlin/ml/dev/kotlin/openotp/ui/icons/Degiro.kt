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

public val OtpIcons.Degiro: ImageVector
    get() {
        if (_degiro != null) {
            return _degiro!!
        }
        _degiro = Builder(
            name = "Degiro", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(20.2f, 11.0f)
                horizontalLineTo(3.8f)
                verticalLineTo(7.1f)
                horizontalLineTo(20.2f)
                verticalLineTo(11.0f)
                close()
                moveTo(20.2f, 16.9f)
                horizontalLineTo(3.8f)
                verticalLineTo(12.9f)
                horizontalLineTo(20.2f)
                verticalLineTo(16.9f)
                close()
            }
        }
            .build()
        return _degiro!!
    }

private var _degiro: ImageVector? = null
