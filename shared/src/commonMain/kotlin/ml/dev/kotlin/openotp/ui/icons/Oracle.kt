package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Oracle: ImageVector
    get() {
        if (_oracle != null) {
            return _oracle!!
        }
        _oracle = ImageVector.Builder(
            name = "Oracle",
            defaultWidth = 24.dp,
            defaultHeight = 24.dp,
            viewportWidth = 24f,
            viewportHeight = 24f
        ).apply {
            path(fill = SolidColor(Color(0xFFC74634))) {
                moveTo(20.994f, 12.277f)
                curveTo(20.939f, 11.165f, 20.473f, 10.109f, 19.682f, 9.318f)
                curveTo(18.838f, 8.474f, 17.694f, 8f, 16.5f, 8f)
                horizontalLineTo(7.5f)
                curveTo(6.307f, 8f, 5.162f, 8.474f, 4.318f, 9.318f)
                curveTo(3.474f, 10.162f, 3f, 11.307f, 3f, 12.5f)
                lineTo(3.006f, 12.723f)
                curveTo(3.061f, 13.835f, 3.527f, 14.891f, 4.318f, 15.682f)
                curveTo(5.162f, 16.526f, 6.307f, 17f, 7.5f, 17f)
                horizontalLineTo(16.5f)
                lineTo(16.723f, 16.994f)
                curveTo(17.836f, 16.939f, 18.89f, 16.473f, 19.682f, 15.682f)
                curveTo(20.526f, 14.838f, 21f, 13.693f, 21f, 12.5f)
                lineTo(20.994f, 12.277f)
                close()
                moveTo(23.99f, 12.872f)
                curveTo(23.899f, 14.726f, 23.122f, 16.485f, 21.803f, 17.803f)
                curveTo(20.397f, 19.21f, 18.489f, 20f, 16.5f, 20f)
                horizontalLineTo(7.5f)
                curveTo(5.511f, 20f, 3.603f, 19.21f, 2.197f, 17.803f)
                curveTo(0.878f, 16.485f, 0.102f, 14.726f, 0.01f, 12.872f)
                lineTo(0f, 12.5f)
                curveTo(0f, 10.511f, 0.79f, 8.603f, 2.197f, 7.197f)
                curveTo(3.603f, 5.79f, 5.511f, 5f, 7.5f, 5f)
                horizontalLineTo(16.5f)
                curveTo(18.489f, 5f, 20.397f, 5.79f, 21.803f, 7.197f)
                curveTo(23.21f, 8.603f, 24f, 10.511f, 24f, 12.5f)
                lineTo(23.99f, 12.872f)
                close()
            }
        }.build()
        return _oracle!!
    }

private var _oracle: ImageVector? = null
