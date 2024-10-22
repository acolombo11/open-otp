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

val OtpIcons.Canada: ImageVector
    get() {
        if (_canada != null) {
            return _canada!!
        }
        _canada = Builder(name = "Canada", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
                viewportWidth = 24.0f, viewportHeight = 24.0f).apply {
            path(fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                    strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                    pathFillType = NonZero) {
                moveTo(1.8276f, 11.8621f)
                lineTo(1.0f, 12.1379f)
                curveTo(1.0f, 12.1379f, 5.9655f, 16.2759f, 5.9655f, 16.5517f)
                curveTo(6.2414f, 16.8276f, 6.5172f, 16.8276f, 6.2414f, 17.6552f)
                curveTo(5.9655f, 18.4828f, 5.6897f, 19.3103f, 5.6897f, 19.3103f)
                curveTo(5.6897f, 19.3103f, 10.1034f, 18.4828f, 10.6552f, 18.2069f)
                curveTo(11.2069f, 18.2069f, 11.4827f, 18.2069f, 11.4827f, 18.7586f)
                curveTo(11.4827f, 19.3103f, 11.2069f, 24.0f, 11.2069f, 24.0f)
                horizontalLineTo(12.5862f)
                curveTo(12.5862f, 24.0f, 12.3103f, 19.0345f, 12.3103f, 18.7586f)
                curveTo(12.3103f, 18.2069f, 12.5862f, 18.2069f, 13.1379f, 18.2069f)
                curveTo(13.6896f, 18.2069f, 18.1034f, 19.3103f, 18.1034f, 19.3103f)
                curveTo(18.1034f, 19.3103f, 17.8276f, 18.2069f, 17.5517f, 17.6552f)
                curveTo(17.2759f, 16.8276f, 17.5517f, 16.8276f, 17.8276f, 16.5517f)
                curveTo(18.1034f, 16.2759f, 22.7931f, 12.1379f, 22.7931f, 12.1379f)
                lineTo(21.9655f, 11.8621f)
                curveTo(21.4138f, 11.5862f, 21.6897f, 11.3103f, 21.6897f, 11.0345f)
                curveTo(21.6897f, 10.7586f, 22.5172f, 8.0f, 22.5172f, 8.0f)
                curveTo(22.5172f, 8.0f, 20.3103f, 8.5517f, 20.0345f, 8.5517f)
                curveTo(19.7586f, 8.5517f, 19.4827f, 8.5517f, 19.4827f, 8.2759f)
                curveTo(19.4827f, 8.0f, 18.931f, 6.8966f, 18.931f, 6.8966f)
                curveTo(18.931f, 6.8966f, 16.4483f, 9.6552f, 16.1724f, 9.931f)
                curveTo(15.6207f, 10.4828f, 15.069f, 9.931f, 15.3448f, 9.3793f)
                curveTo(15.3448f, 8.8276f, 16.7241f, 3.0345f, 16.7241f, 3.0345f)
                curveTo(16.7241f, 3.0345f, 15.3448f, 3.8621f, 14.7931f, 4.1379f)
                curveTo(14.2414f, 4.4138f, 13.9655f, 4.4138f, 13.9655f, 3.8621f)
                curveTo(13.6896f, 3.3103f, 12.0345f, 0.2759f, 12.0345f, 0.0f)
                curveTo(12.0345f, 0.0f, 10.3793f, 3.3103f, 10.1034f, 3.8621f)
                curveTo(9.8275f, 4.4138f, 9.5517f, 4.4138f, 9.2759f, 4.1379f)
                curveTo(8.7241f, 3.8621f, 7.3448f, 3.0345f, 7.3448f, 3.0345f)
                curveTo(7.3448f, 3.0345f, 8.7241f, 8.8276f, 8.7241f, 9.3793f)
                curveTo(8.7241f, 9.931f, 8.4483f, 10.2069f, 7.8966f, 9.931f)
                lineTo(5.1379f, 6.8966f)
                curveTo(5.1379f, 6.8966f, 4.862f, 7.7241f, 4.5862f, 8.0f)
                curveTo(4.5862f, 8.2759f, 4.3103f, 8.5517f, 4.0345f, 8.2759f)
                curveTo(3.4827f, 8.2759f, 1.2758f, 7.7241f, 1.2758f, 7.7241f)
                curveTo(1.2758f, 7.7241f, 2.1035f, 10.4828f, 2.3793f, 10.7586f)
                curveTo(2.3793f, 11.0345f, 2.3793f, 11.5862f, 1.8276f, 11.8621f)
                close()
            }
        }
        .build()
        return _canada!!
    }

private var _canada: ImageVector? = null
