package ml.dev.kotlin.openotp.ui.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.PathData
import androidx.compose.ui.graphics.vector.group
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import ml.dev.kotlin.openotp.ui.OtpIcons

public val OtpIcons.Subito: ImageVector
    get() {
        if (_subito != null) {
            return _subito!!
        }
        _subito = ImageVector.Builder(
            name = "Subito",
            defaultWidth = 24.dp,
            defaultHeight = 25.dp,
            viewportWidth = 24f,
            viewportHeight = 25f
        ).apply {
            group(
                clipPathData = PathData {
                    moveTo(0f, 0.5f)
                    horizontalLineToRelative(24f)
                    verticalLineToRelative(24f)
                    horizontalLineToRelative(-24f)
                    close()
                }
            ) {
                path(
                    fill = SolidColor(Color(0xFFF9423A)),
                    pathFillType = PathFillType.EvenOdd
                ) {
                    moveTo(18.706f, 12.447f)
                    curveTo(18.817f, 12.402f, 18.906f, 12.315f, 18.953f, 12.205f)
                    curveTo(19f, 12.094f, 19.001f, 11.97f, 18.956f, 11.859f)
                    lineTo(16.465f, 5.693f)
                    curveTo(16.42f, 5.582f, 16.332f, 5.493f, 16.222f, 5.446f)
                    curveTo(16.112f, 5.4f, 15.988f, 5.399f, 15.876f, 5.443f)
                    lineTo(14.275f, 6.09f)
                    curveTo(14.164f, 6.135f, 14.075f, 6.222f, 14.029f, 6.333f)
                    curveTo(13.982f, 6.443f, 13.98f, 6.567f, 14.025f, 6.678f)
                    lineTo(16.517f, 12.845f)
                    curveTo(16.562f, 12.956f, 16.649f, 13.044f, 16.76f, 13.091f)
                    curveTo(16.87f, 13.138f, 16.994f, 13.139f, 17.105f, 13.094f)
                    lineTo(18.706f, 12.447f)
                    close()
                    moveTo(15.157f, 14.431f)
                    curveTo(15.241f, 14.346f, 15.288f, 14.232f, 15.288f, 14.113f)
                    curveTo(15.288f, 13.995f, 15.241f, 13.881f, 15.157f, 13.796f)
                    lineTo(9.127f, 7.767f)
                    curveTo(9.043f, 7.683f, 8.929f, 7.636f, 8.81f, 7.636f)
                    curveTo(8.691f, 7.636f, 8.577f, 7.683f, 8.493f, 7.767f)
                    lineTo(7.267f, 8.993f)
                    curveTo(7.183f, 9.077f, 7.136f, 9.191f, 7.136f, 9.31f)
                    curveTo(7.136f, 9.429f, 7.183f, 9.543f, 7.267f, 9.627f)
                    lineTo(13.296f, 15.657f)
                    curveTo(13.471f, 15.831f, 13.756f, 15.831f, 13.931f, 15.657f)
                    lineTo(15.157f, 14.431f)
                    close()
                    moveTo(12.594f, 17.605f)
                    curveTo(12.639f, 17.494f, 12.638f, 17.37f, 12.591f, 17.26f)
                    curveTo(12.545f, 17.149f, 12.456f, 17.062f, 12.345f, 17.017f)
                    lineTo(6.178f, 14.526f)
                    curveTo(6.067f, 14.481f, 5.942f, 14.482f, 5.832f, 14.529f)
                    curveTo(5.722f, 14.576f, 5.635f, 14.664f, 5.59f, 14.775f)
                    lineTo(4.942f, 16.377f)
                    curveTo(4.898f, 16.488f, 4.899f, 16.612f, 4.946f, 16.722f)
                    curveTo(4.993f, 16.832f, 5.082f, 16.919f, 5.192f, 16.964f)
                    lineTo(11.359f, 19.456f)
                    curveTo(11.47f, 19.501f, 11.594f, 19.5f, 11.705f, 19.453f)
                    curveTo(11.815f, 19.406f, 11.902f, 19.317f, 11.947f, 19.207f)
                    lineTo(12.594f, 17.605f)
                    close()
                    moveTo(12f, 0.5f)
                    curveTo(18.627f, 0.5f, 24f, 5.873f, 24f, 12.5f)
                    curveTo(24f, 19.128f, 18.627f, 24.5f, 12f, 24.5f)
                    curveTo(5.373f, 24.5f, 0f, 19.128f, 0f, 12.5f)
                    curveTo(0f, 5.873f, 5.373f, 0.5f, 12f, 0.5f)
                    close()
                }
            }
        }.build()
        return _subito!!
    }

private var _subito: ImageVector? = null
