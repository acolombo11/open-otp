package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

val OtpIcons.Register: ImageVector
    get() {
        if (_Register != null) {
            return _Register!!
        }
        _Register = ImageVector.Builder(
            name = "Register",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFF303435))) {
                moveTo(6.522f, 3.87f)
                curveTo(3.938f, 5.626f, 2.24f, 8.59f, 2.24f, 11.95f)
                curveTo(2.24f, 15.371f, 4.002f, 18.378f, 6.666f, 20.121f)
                lineTo(5.055f, 21.732f)
                curveTo(1.997f, 19.557f, 0f, 15.988f, 0f, 11.95f)
                curveTo(0f, 7.972f, 1.936f, 4.448f, 4.916f, 2.265f)
                lineTo(6.522f, 3.87f)
                close()
                moveTo(19.22f, 2.365f)
                curveTo(22.123f, 4.555f, 24f, 8.033f, 24f, 11.95f)
                curveTo(24f, 15.927f, 22.063f, 19.451f, 19.083f, 21.634f)
                lineTo(17.477f, 20.028f)
                curveTo(20.061f, 18.272f, 21.76f, 15.31f, 21.76f, 11.95f)
                curveTo(21.76f, 8.65f, 20.121f, 5.736f, 17.615f, 3.969f)
                lineTo(19.22f, 2.365f)
                close()
            }
        }.build()

        return _Register!!
    }

@Suppress("ObjectPropertyName")
private var _Register: ImageVector? = null
