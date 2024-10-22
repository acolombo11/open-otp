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

public val OtpIcons.Coinbase: ImageVector
    get() {
        if (_coinbase != null) {
            return _coinbase!!
        }
        _coinbase = Builder(
            name = "Coinbase", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            group {
                path(
                    fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero
                ) {
                    moveTo(12.0074f, 17.9963f)
                    curveTo(8.6909f, 17.9963f, 6.0111f, 15.3091f, 6.0111f, 12.0f)
                    curveTo(6.0111f, 8.6909f, 8.6983f, 6.0037f, 12.0074f, 6.0037f)
                    curveTo(14.9759f, 6.0037f, 17.4411f, 8.1653f, 17.9149f, 11.0006f)
                    horizontalLineTo(23.9556f)
                    curveTo(23.4448f, 4.8415f, 18.2924f, 0.0f, 12.0f, 0.0f)
                    curveTo(5.3745f, 0.0f, 0.0f, 5.3745f, 0.0f, 12.0f)
                    curveTo(0.0f, 18.6255f, 5.3745f, 24.0f, 12.0f, 24.0f)
                    curveTo(18.2924f, 24.0f, 23.4448f, 19.1585f, 23.9556f, 12.9994f)
                    horizontalLineTo(17.9075f)
                    curveTo(17.4337f, 15.8347f, 14.9759f, 17.9963f, 12.0074f, 17.9963f)
                    close()
                }
            }
        }
            .build()
        return _coinbase!!
    }

private var _coinbase: ImageVector? = null
