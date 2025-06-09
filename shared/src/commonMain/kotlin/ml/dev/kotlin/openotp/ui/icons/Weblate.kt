package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush.Companion.linearGradient
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.EvenOdd
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Weblate: ImageVector
    get() {
        if (_weblate != null) {
            return _weblate!!
        }
        _weblate = Builder(
            name = "Weblate", defaultWidth = 24.0.dp, defaultHeight = 25.0.dp,
            viewportWidth = 24.0f, viewportHeight = 25.0f
        ).apply {
            path(
                fill = linearGradient(
                    0.0f to Color(0xFF00D2E6), 1.0f to Color(0xFF2ECCAA), start =
                        Offset(-0.0f, 10.379f), end = Offset(11.726f, 10.379f)
                ), stroke = null,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(15.375f, 17.094f)
                curveTo(15.025f, 17.092f, 14.676f, 17.021f, 14.347f, 16.878f)
                curveTo(13.607f, 16.555f, 12.955f, 15.946f, 12.424f, 15.121f)
                curveTo(12.575f, 14.852f, 12.712f, 14.574f, 12.833f, 14.29f)
                curveTo(13.367f, 13.049f, 13.621f, 11.689f, 13.641f, 10.34f)
                curveTo(13.638f, 10.313f, 13.636f, 10.286f, 13.634f, 10.259f)
                lineTo(13.632f, 10.19f)
                curveTo(13.631f, 9.661f, 13.551f, 9.125f, 13.369f, 8.626f)
                curveTo(13.159f, 8.051f, 12.825f, 7.475f, 12.294f, 7.25f)
                curveTo(12.198f, 7.21f, 12.096f, 7.193f, 11.995f, 7.195f)
                curveTo(11.328f, 5.948f, 11.307f, 4.753f, 11.995f, 3.615f)
                curveTo(12.008f, 3.615f, 12.021f, 3.615f, 12.033f, 3.615f)
                curveTo(12.845f, 3.624f, 13.65f, 3.875f, 14.338f, 4.312f)
                curveTo(16.213f, 5.504f, 17.148f, 7.827f, 17.168f, 10.108f)
                curveTo(17.169f, 10.135f, 17.168f, 10.162f, 17.168f, 10.188f)
                horizontalLineTo(17.178f)
                curveTo(17.175f, 12.599f, 16.596f, 15.043f, 15.375f, 17.094f)
                close()
                moveTo(11.218f, 20.878f)
                curveTo(9.467f, 21.598f, 7.433f, 21.559f, 5.697f, 20.753f)
                curveTo(3.701f, 19.826f, 2.175f, 18.025f, 1.235f, 15.968f)
                curveTo(-0.372f, 12.451f, -0.409f, 8.246f, 1.115f, 4.675f)
                curveTo(2.26f, 5.133f, 3.278f, 4.403f, 3.278f, 4.403f)
                curveTo(3.278f, 4.403f, 3.276f, 5.526f, 4.363f, 6.089f)
                curveTo(3.247f, 8.701f, 3.274f, 11.805f, 4.392f, 14.351f)
                curveTo(4.93f, 15.576f, 5.752f, 16.717f, 6.891f, 17.362f)
                curveTo(7.297f, 17.592f, 7.744f, 17.741f, 8.204f, 17.797f)
                curveTo(8.206f, 17.799f, 8.207f, 17.802f, 8.209f, 17.805f)
                curveTo(9.021f, 19.071f, 10.043f, 20.126f, 11.218f, 20.878f)
                close()
            }
            path(
                fill = linearGradient(
                    0.0f to Color(0x00000000), 0.514f to Color(0xFF000000), 1.0f
                            to Color(0x00000000), start = Offset(6.862f, 17.936f), end =
                        Offset(13.082f, 13.972f)
                ), stroke = null, fillAlpha = 0.3f, strokeAlpha = 0.3f,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = EvenOdd
            ) {
                moveTo(15.375f, 17.095f)
                curveTo(15.025f, 17.093f, 14.676f, 17.022f, 14.347f, 16.879f)
                curveTo(13.607f, 16.556f, 12.954f, 15.946f, 12.424f, 15.122f)
                curveTo(12.575f, 14.852f, 12.712f, 14.574f, 12.833f, 14.29f)
                curveTo(12.994f, 13.916f, 13.13f, 13.531f, 13.241f, 13.139f)
                curveTo(13.499f, 12.23f, 16.923f, 13.384f, 16.401f, 14.881f)
                curveTo(16.132f, 15.653f, 15.79f, 16.397f, 15.375f, 17.095f)
                close()
                moveTo(11.217f, 20.878f)
                curveTo(9.466f, 21.598f, 7.433f, 21.559f, 5.697f, 20.753f)
                curveTo(3.701f, 19.826f, 5.752f, 16.717f, 6.891f, 17.362f)
                curveTo(7.297f, 17.592f, 7.744f, 17.741f, 8.203f, 17.797f)
                curveTo(8.205f, 17.8f, 8.207f, 17.802f, 8.209f, 17.806f)
                curveTo(9.02f, 19.072f, 10.042f, 20.127f, 11.217f, 20.878f)
                close()
            }
            path(
                fill = linearGradient(
                    0.0f to Color(0xFF1FA385), 1.0f to Color(0xFF2ECCAA), start =
                        Offset(24.0f, 10.675f), end = Offset(12.294f, 10.675f)
                ), stroke = null,
                strokeLineWidth = 0.0f, strokeLineCap = Butt, strokeLineJoin = Miter,
                strokeLineMiter = 4.0f, pathFillType = NonZero
            ) {
                moveTo(6.832f, 10.188f)
                curveTo(6.832f, 10.162f, 6.831f, 10.135f, 6.832f, 10.108f)
                curveTo(6.852f, 7.827f, 7.787f, 5.504f, 9.662f, 4.312f)
                curveTo(10.35f, 3.875f, 11.155f, 3.624f, 11.967f, 3.615f)
                curveTo(11.979f, 3.615f, 11.992f, 3.615f, 12.005f, 3.615f)
                verticalLineTo(7.195f)
                curveTo(11.904f, 7.193f, 11.802f, 7.21f, 11.706f, 7.25f)
                curveTo(11.175f, 7.475f, 10.841f, 8.051f, 10.631f, 8.626f)
                curveTo(10.449f, 9.125f, 10.369f, 9.661f, 10.368f, 10.19f)
                lineTo(10.366f, 10.259f)
                curveTo(10.364f, 10.286f, 10.362f, 10.313f, 10.359f, 10.34f)
                curveTo(10.379f, 11.689f, 10.633f, 13.049f, 11.167f, 14.29f)
                curveTo(11.765f, 15.681f, 12.715f, 16.96f, 14.057f, 17.545f)
                curveTo(15.069f, 17.986f, 16.191f, 17.882f, 17.109f, 17.362f)
                curveTo(18.248f, 16.717f, 19.07f, 15.576f, 19.608f, 14.351f)
                curveTo(20.726f, 11.805f, 20.753f, 8.701f, 19.637f, 6.089f)
                curveTo(20.724f, 5.526f, 20.722f, 4.403f, 20.722f, 4.403f)
                curveTo(20.722f, 4.403f, 21.74f, 5.133f, 22.885f, 4.675f)
                curveTo(24.409f, 8.246f, 24.372f, 12.451f, 22.765f, 15.968f)
                curveTo(21.825f, 18.025f, 20.299f, 19.826f, 18.302f, 20.753f)
                curveTo(16.525f, 21.579f, 14.435f, 21.599f, 12.656f, 20.824f)
                curveTo(11.057f, 20.127f, 9.757f, 18.872f, 8.821f, 17.412f)
                curveTo(7.466f, 15.298f, 6.825f, 12.724f, 6.822f, 10.188f)
                horizontalLineTo(6.832f)
                close()
            }
        }
            .build()
        return _weblate!!
    }

private var _weblate: ImageVector? = null
