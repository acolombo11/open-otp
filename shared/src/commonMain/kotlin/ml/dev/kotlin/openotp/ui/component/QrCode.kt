package ml.dev.kotlin.openotp.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import qrcode.QRCode

@Composable
internal fun QrCode(
    data: String,
    modifier: Modifier = Modifier,
    color: Color = Color.Black,
) {
    val modules = remember(data) {
        QRCode.ofSquares().build(data).rawData.map { row -> row.map { it.dark } }
    }
    Canvas(modifier) {
        val cell = size.minDimension / modules.size
        modules.forEachIndexed { y, row ->
            row.forEachIndexed { x, dark ->
                if (dark) {
                    drawRect(
                        color = color,
                        topLeft = Offset(x * cell, y * cell),
                        // slight overlap avoids hairline gaps between modules
                        size = Size(cell + 0.5f, cell + 0.5f),
                    )
                }
            }
        }
    }
}
