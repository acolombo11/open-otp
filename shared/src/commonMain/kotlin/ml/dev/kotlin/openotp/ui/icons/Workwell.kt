package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Workwell: ImageVector
    get() {
        if (_workwell != null) {
            return _workwell!!
        }
        _workwell = ImageVector.Builder(
            name = "Workwell",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f,
        ).apply {
            path(fill = SolidColor(Color.Black)) {
                moveTo(16.584f, 13.833f)
                lineTo(19.917f, 5.5f)
                lineTo(19.974f, 5.519f)
                horizontalLineTo(24f)
                lineTo(18.029f, 18.5f)
                horizontalLineTo(13.772f)
                lineTo(12.751f, 10.583f)
                horizontalLineTo(12.597f)
                lineTo(8.533f, 18.5f)
                horizontalLineTo(4.276f)
                lineTo(3.525f, 9.279f)
                lineTo(3.486f, 8.826f)
                curveTo(3.101f, 9.015f, 2.754f, 9.26f, 2.465f, 9.525f)
                lineTo(0f, 7.843f)
                curveTo(1.406f, 6.407f, 3.332f, 5.557f, 4.892f, 5.538f)
                lineTo(7.242f, 5.5f)
                lineTo(7.396f, 13.833f)
                horizontalLineTo(7.589f)
                lineTo(11.692f, 5.5f)
                horizontalLineTo(15.467f)
                lineTo(16.392f, 13.833f)
                horizontalLineTo(16.584f)
                close()
            }
        }.build()

        return _workwell!!
    }

@Suppress("ObjectPropertyName")
private var _workwell: ImageVector? = null
