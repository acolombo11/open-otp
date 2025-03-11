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

public val OtpIcons.Gaijin: ImageVector
    get() {
        if (_gaijin != null) {
            return _gaijin!!
        }
        _gaijin = Builder(
            name = "Gaijin", defaultWidth = 24.0.dp, defaultHeight = 24.0.dp,
            viewportWidth = 24.0f, viewportHeight = 24.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF000000)), stroke = null, strokeLineWidth = 0.0f,
                strokeLineCap = Butt, strokeLineJoin = Miter, strokeLineMiter = 4.0f,
                pathFillType = EvenOdd
            ) {
                moveTo(19.2422f, 2.0671f)
                curveTo(19.1833f, 1.7343f, 19.5884f, 1.6009f, 19.5633f, 0.9461f)
                curveTo(19.5299f, -0.5583f, 17.5528f, -0.2f, 18.0347f, 1.535f)
                curveTo(18.764f, 4.3741f, 18.3409f, 6.3474f, 17.8798f, 7.3421f)
                curveTo(17.6505f, 7.8396f, 17.2103f, 7.2462f, 17.1376f, 6.8808f)
                curveTo(16.5817f, 4.0744f, 15.3551f, 3.3404f, 16.0187f, 1.4164f)
                curveTo(16.5412f, -0.0965f, 14.3502f, -0.7065f, 14.4901f, 1.445f)
                curveTo(14.5039f, 1.9108f, 15.1592f, 4.6979f, 15.1091f, 6.3353f)
                curveTo(15.1037f, 6.5332f, 14.6367f, 6.6694f, 14.43f, 6.5856f)
                curveTo(13.4786f, 6.2009f, 12.5255f, 6.0567f, 11.5741f, 6.0132f)
                curveTo(7.3938f, 6.0132f, 4.0f, 9.6526f, 4.0f, 14.1353f)
                curveTo(4.0f, 17.4974f, 5.562f, 20.16f, 8.1093f, 21.2806f)
                curveTo(7.5559f, 22.1199f, 7.6674f, 22.9453f, 7.1758f, 24.0f)
                curveTo(11.3394f, 23.6198f, 12.2014f, 20.9151f, 14.8155f, 20.9241f)
                curveTo(17.2299f, 20.9214f, 17.075f, 20.9438f, 19.4919f, 20.9061f)
                curveTo(19.9781f, 20.8972f, 19.763f, 19.8259f, 19.654f, 19.6087f)
                curveTo(16.9785f, 14.2795f, 19.9572f, 10.207f, 19.9923f, 8.7985f)
                curveTo(20.0495f, 6.4311f, 19.788f, 5.1891f, 19.2422f, 2.0671f)
                close()
                moveTo(16.3286f, 18.5253f)
                curveTo(14.4943f, 18.1209f, 11.4638f, 20.6097f, 9.5761f, 20.2406f)
                curveTo(8.5662f, 20.0328f, 7.7572f, 16.1404f, 7.0877f, 14.3798f)
                curveTo(6.8768f, 13.8509f, 6.5832f, 13.6485f, 6.3543f, 13.2606f)
                curveTo(6.1446f, 12.9037f, 6.3038f, 12.4589f, 6.2482f, 12.2341f)
                curveTo(5.917f, 10.8977f, 9.6421f, 8.8182f, 12.9394f, 8.2714f)
                lineTo(15.8116f, 8.4255f)
                lineTo(16.0171f, 9.3019f)
                lineTo(16.91f, 9.5133f)
                lineTo(16.6753f, 11.2139f)
                lineTo(12.541f, 10.5801f)
                curveTo(11.0027f, 11.226f, 9.9227f, 11.3679f, 8.742f, 12.5369f)
                curveTo(8.9934f, 12.9502f, 8.8356f, 13.5226f, 9.0958f, 13.936f)
                curveTo(9.1864f, 14.0816f, 9.6249f, 14.1326f, 9.7143f, 14.2688f)
                curveTo(9.5581f, 14.6974f, 10.1115f, 15.7266f, 10.1658f, 15.9993f)
                lineTo(10.4744f, 18.0429f)
                curveTo(11.8915f, 17.5064f, 13.758f, 16.5583f, 14.8673f, 16.4427f)
                curveTo(15.7097f, 16.4593f, 15.0585f, 14.9639f, 14.8882f, 14.1353f)
                curveTo(14.6802f, 13.0958f, 13.2117f, 14.0274f, 11.9512f, 14.5912f)
                lineTo(12.5773f, 16.0235f)
                lineTo(12.0744f, 16.8055f)
                lineTo(11.8452f, 16.2331f)
                lineTo(11.5043f, 16.5417f)
                lineTo(10.5613f, 13.7551f)
                lineTo(11.2763f, 12.811f)
                lineTo(12.087f, 13.0703f)
                curveTo(12.949f, 12.6672f, 14.2554f, 11.5645f, 15.2741f, 12.0335f)
                curveTo(15.4946f, 12.1351f, 15.5088f, 12.3479f, 15.5965f, 12.7241f)
                lineTo(16.0747f, 12.9471f)
                curveTo(16.3524f, 14.5997f, 18.4219f, 18.987f, 16.3286f, 18.5253f)
                close()
            }
        }
            .build()
        return _gaijin!!
    }

private var _gaijin: ImageVector? = null
