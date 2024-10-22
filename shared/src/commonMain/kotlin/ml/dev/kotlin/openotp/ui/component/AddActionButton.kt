package ml.dev.kotlin.openotp.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.EditNote
import androidx.compose.material.icons.filled.QrCodeScanner
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.shared.OpenOtpResources

@Composable
internal fun AddActionButton(
    modifier: Modifier = Modifier,
    dragDropState: DragDropState,
    visible: Boolean,
    onScanQRCodeClick: (() -> Unit)?,
    onAddWithTextClick: () -> Unit,
) {
    AnimatedVisibility(
        visible = visible,
        enter = fadeIn(),
        exit = fadeOut(),
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd,
        ) {
            val fabState = rememberMultiFabState()
            val buttonText = stringResource(OpenOtpResources.strings.add_button_name)

            val expanded by remember {
                derivedStateOf {
                    val listState = dragDropState.listState
                    when (listState.firstVisibleItemIndex) {
                        0 -> true
                        1 -> {
                            val draggedItemIndex = dragDropState.currentDraggedItemIndex
                            draggedItemIndex == 0 || draggedItemIndex == 1
                        }
                        else -> false
                    }
                }
            }
            MultiFloatingActionButton(
                items = listOfNotNull(
                    onScanQRCodeClick?.let {
                        MultiFabItem(
                            id = FabItem.ScanQRCode,
                            icon = Icons.Default.QrCodeScanner,
                        )
                    },
                    MultiFabItem(
                        id = FabItem.AddWithText,
                        icon = Icons.Default.EditNote,
                    ),
                ),
                fabIcon = FabIcon(
                    icon = Icons.Default.Add,
                    iconRotate = 45f,
                    text = { buttonText }
                ),
                expanded = expanded && !fabState.value.isExpanded(),
                containerColor = MaterialTheme.colorScheme.tertiary,
                onFabItemClicked = {
                    when (it) {
                        FabItem.ScanQRCode -> onScanQRCodeClick?.invoke()
                        FabItem.AddWithText -> onAddWithTextClick()
                    }
                    fabState.value = MultiFabState.Collapsed
                },
                fabState = fabState,
            )
        }
    }
}

private enum class FabItem {
    ScanQRCode, AddWithText,
}
