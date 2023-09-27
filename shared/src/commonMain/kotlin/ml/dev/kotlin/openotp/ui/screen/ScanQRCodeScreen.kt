package ml.dev.kotlin.openotp.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.*
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.component.ScanQRCodeComponent
import ml.dev.kotlin.openotp.qr.QRCodeScanner
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.ui.theme.Typography

@Composable
internal fun ScanQRCodeScreen(
    scanQRCodeComponent: ScanQRCodeComponent,
    holePercent: Float = 0.75f,
) {
    val isLoading = remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
    ) { innerPadding ->
        QRCodeScanner(
            onResult = scanQRCodeComponent::onQRCodeScanned,
            innerPadding = innerPadding,
            isLoading = isLoading,
        )
        QRCodeCameraHole(holePercent)
        ScanQRCodeScreenDescription(
            holePercent = holePercent,
            onCancel = scanQRCodeComponent::onCancelClick,
        )
        CoverErrorsLoadingAnimation(isLoading.value)
    }
}

@Composable
private fun CancelScanQRCodeButton(onCancel: () -> Unit) {
    val cancelText = stringResource(OpenOtpResources.strings.cancel_button_name)
    IconButton(
        onClick = onCancel,
        colors = IconButtonDefaults.iconButtonColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = contentColorFor(MaterialTheme.colorScheme.background),
        ),
        modifier = Modifier.size(44.dp)
    ) {
        Icon(
            imageVector = Icons.Outlined.Close,
            contentDescription = cancelText,
            modifier = Modifier.padding(8.dp).fillMaxSize()
        )
    }
}

@Composable
private fun ScanQRCodeScreenDescription(
    holePercent: Float,
    onCancel: () -> Unit,
    buttons: @Composable BoxWithConstraintsScope.() -> Unit = {
        CancelScanQRCodeButton(onCancel)
    }
) {
    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
    ) {
        val cameraSize = min(maxHeight, maxWidth) * holePercent
        if (maxHeight >= maxWidth) Column {
            val modifier = Modifier.weight(1f).fillMaxSize()
            Box(modifier, Alignment.Center) { ScanQRCodeIcon() }
            Box(Modifier.height(cameraSize).fillMaxWidth())
            BoxWithConstraints(modifier, Alignment.Center, false, buttons)
        } else Row {
            val modifier = Modifier.weight(1f).fillMaxSize()
            Box(modifier, Alignment.Center) { ScanQRCodeIcon() }
            Box(Modifier.width(cameraSize).fillMaxHeight())
            BoxWithConstraints(modifier, Alignment.Center, false, buttons)
        }
    }
}

@Composable
private fun CoverErrorsLoadingAnimation(isLoading: Boolean) {
    AnimatedVisibility(
        visible = isLoading,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
        ) {

            CircularProgressIndicator()
        }
    }
}

@Composable
private fun QRCodeCameraHole(
    holePercent: Float,
    border: Dp = 4.dp,
    backgroundAlpha: Float = 0.8f,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
) {
    Canvas(
        modifier = Modifier.fillMaxSize(),
        onDraw = {
            val holeSize = size.minDimension * holePercent
            val borderPx = border.roundToPx()
            val borderSize = holeSize + 2 * borderPx
            val halfBorderSize = borderSize / 2f
            clipPath(
                path = Path().apply {
                    addRoundRect(
                        RoundRect(
                            rect = Rect(center, holeSize / 2f),
                            cornerRadius = CornerRadius(holeSize / 20f)
                        )
                    )
                },
                clipOp = ClipOp.Difference
            ) {
                drawRect(
                    color = backgroundColor,
                    alpha = backgroundAlpha,
                )
                drawRoundRect(
                    color = backgroundColor,
                    size = Size(borderSize, borderSize),
                    topLeft = center.minus(Offset(halfBorderSize, halfBorderSize)),
                    cornerRadius = CornerRadius(borderSize / 20f)
                )
            }
        })
}

@Composable
private fun ScanQRCodeIcon() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        val text = stringResource(OpenOtpResources.strings.scan_qr_code)
        Icon(
            imageVector = Icons.Default.QrCodeScanner,
            contentDescription = text,
            modifier = Modifier
                .padding(12.dp)
                .size(48.dp)
        )
        Text(text, style = Typography.displayMedium)
    }
}
