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

public val OtpIcons.BambooHr: ImageVector
    get() {
        if (_bamboohr != null) {
            return _bamboohr!!
        }
        _bamboohr = Builder(
            name = "BambooHr", defaultWidth = 24.0.dp, defaultHeight = 25.0.dp,
            viewportWidth = 24.0f, viewportHeight = 25.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF45483D)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(17.5228f, 8.8233f)
                curveTo(15.2099f, 8.8233f, 13.9699f, 9.6172f, 13.1004f, 10.4803f)
                lineTo(12.8633f, 10.7291f)
                lineTo(12.8626f, 2.9775f)
                horizontalLineTo(10.8645f)
                verticalLineTo(15.664f)
                curveTo(10.8645f, 19.5678f, 13.8714f, 22.0f, 17.3217f, 22.0f)
                curveTo(21.1226f, 22.0f, 24.0f, 19.075f, 24.0f, 15.315f)
                curveTo(24.0f, 11.8239f, 20.9987f, 8.8233f, 17.5228f, 8.8233f)
                close()
                moveTo(9.9221f, 11.3978f)
                lineTo(9.0353f, 8.4919f)
                curveTo(8.506f, 6.9635f, 8.3493f, 6.0837f, 6.8581f, 4.5091f)
                curveTo(6.3474f, 3.9689f, 4.4139f, 2.7802f, 4.654f, 3.0396f)
                curveTo(7.104f, 5.6843f, 8.357f, 8.8888f, 8.8404f, 9.7789f)
                curveTo(8.3965f, 9.2399f, 7.8761f, 8.7559f, 7.2826f, 8.1538f)
                curveTo(6.7771f, 7.6412f, 6.2492f, 7.1786f, 5.7473f, 6.8687f)
                curveTo(5.4172f, 6.6641f, 5.2318f, 6.5514f, 4.8969f, 6.378f)
                curveTo(3.3874f, 5.5938f, 1.9241f, 5.1191f, 1.3624f, 4.9789f)
                curveTo(0.6763f, 4.8081f, 0.0f, 4.7635f, 0.0f, 4.7635f)
                curveTo(0.0f, 4.7635f, 2.1875f, 6.6102f, 3.1245f, 7.7858f)
                curveTo(4.0619f, 8.9607f, 5.0181f, 10.0145f, 6.0751f, 10.4452f)
                curveTo(7.132f, 10.8762f, 7.4998f, 10.9996f, 8.3309f, 11.1254f)
                curveTo(9.0477f, 11.2335f, 9.9221f, 11.3978f, 9.9221f, 11.3978f)
                close()
                moveTo(17.3217f, 20.179f)
                curveTo(14.8119f, 20.179f, 12.6879f, 18.2f, 12.6879f, 15.5494f)
                curveTo(12.6879f, 12.8972f, 14.4788f, 10.719f, 17.3667f, 10.719f)
                curveTo(20.2552f, 10.719f, 21.957f, 13.0543f, 21.957f, 15.5004f)
                curveTo(21.957f, 18.1615f, 20.1561f, 20.179f, 17.3217f, 20.179f)
                close()
            }
        }
            .build()
        return _bamboohr!!
    }

private var _bamboohr: ImageVector? = null
