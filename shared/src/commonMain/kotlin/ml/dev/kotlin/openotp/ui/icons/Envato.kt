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

public val OtpIcons.Envato: ImageVector
    get() {
        if (_envato != null) {
            return _envato!!
        }
        _envato = Builder(name = "Envato", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = EvenOdd) {
                moveTo(13.2191f, 16.2651f)
                lineTo(19.2614f, 15.62f)
                lineTo(19.2678f, 15.6264f)
                curveTo(20.3536f, 15.5178f, 20.9093f, 16.8847f, 20.0726f, 17.5809f)
                lineTo(15.3588f, 21.4579f)
                curveTo(14.8351f, 21.8411f, 14.2091f, 21.1833f, 14.5924f, 20.6914f)
                lineTo(16.0231f, 18.9222f)
                curveTo(16.087f, 18.8392f, 16.0103f, 18.7178f, 15.9081f, 18.7434f)
                lineTo(6.7298f, 21.0044f)
                curveTo(5.612f, 21.2791f, 4.4559f, 20.6148f, 4.2132f, 19.4651f)
                curveTo(3.9705f, 18.5901f, 4.3218f, 17.7214f, 5.0883f, 17.2296f)
                lineTo(11.2263f, 13.3015f)
                curveTo(11.3285f, 13.2312f, 11.2647f, 13.0715f, 11.1433f, 13.0971f)
                lineTo(5.612f, 14.2276f)
                curveTo(4.6667f, 14.4001f, 3.7214f, 13.7741f, 3.5489f, 12.8288f)
                curveTo(3.4467f, 12.2348f, 3.6192f, 11.6791f, 4.0024f, 11.2576f)
                lineTo(14.2794f, 0.8018f)
                curveTo(15.3269f, -0.2457f, 17.0003f, -0.2777f, 18.0478f, 0.7698f)
                curveTo(19.1975f, 1.8876f, 19.0953f, 3.8101f, 17.8371f, 4.7874f)
                lineTo(11.469f, 9.6544f)
                curveTo(11.3796f, 9.7247f, 11.4371f, 9.8716f, 11.5521f, 9.8524f)
                lineTo(17.9776f, 8.9135f)
                curveTo(18.8143f, 8.8049f, 19.4786f, 9.3287f, 19.5808f, 10.1334f)
                curveTo(19.6829f, 10.6572f, 19.4402f, 11.149f, 19.057f, 11.462f)
                lineTo(13.1425f, 16.0671f)
                curveTo(13.0531f, 16.1374f, 13.1105f, 16.2779f, 13.2191f, 16.2651f)
                close()
                moveTo(14.1708f, 22.9269f)
                curveTo(14.1708f, 23.5209f, 13.6918f, 24.0f, 13.0978f, 24.0f)
                curveTo(12.5038f, 24.0f, 12.0247f, 23.5209f, 12.0247f, 22.9269f)
                curveTo(12.0247f, 22.3329f, 12.5038f, 21.8539f, 13.0978f, 21.8539f)
                curveTo(13.6918f, 21.8539f, 14.1708f, 22.3329f, 14.1708f, 22.9269f)
                close()
            }
        }
        .build()
        return _envato!!
    }

private var _envato: ImageVector? = null
