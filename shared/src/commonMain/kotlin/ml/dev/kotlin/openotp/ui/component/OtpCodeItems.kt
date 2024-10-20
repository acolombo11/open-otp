package ml.dev.kotlin.openotp.ui.component

import androidx.compose.animation.VectorConverter
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.DismissDirection.EndToStart
import androidx.compose.material.DismissDirection.StartToEnd
import androidx.compose.material.DismissState
import androidx.compose.material.DismissValue.*
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cached
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.rememberDismissState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.colorspace.ColorSpaces
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.icerock.moko.resources.compose.stringResource
import kotlinx.coroutines.isActive
import ml.dev.kotlin.openotp.otp.HotpData
import ml.dev.kotlin.openotp.otp.OtpData
import ml.dev.kotlin.openotp.otp.PresentedOtpCodeData
import ml.dev.kotlin.openotp.otp.TotpData
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.ui.issuerIcon
import ml.dev.kotlin.openotp.util.currentEpochMilliseconds
import ml.dev.kotlin.openotp.util.letTrue
import kotlin.math.roundToInt

@Composable
internal fun OtpCodeItems(
    codeData: PresentedOtpCodeData,
    timestamp: Long,
    confirmCodeDismiss: Boolean,
    isDragAndDropEnabled: Boolean,
    showSortedGroupsHeaders: Boolean,
    onOtpCodeDataDismiss: (OtpData) -> Boolean,
    onRestartCode: (OtpData) -> Unit,
    dragDropState: DragDropState,
    copyOtpCode: ClipboardManager.(item: OtpData, timestamp: Long) -> Unit,
) {
    val currentTimestamp by rememberUpdatedState(timestamp)
    var dismissedCode by remember { mutableStateOf<OtpData?>(null) }

    DragDropList(
        items = codeData,
        key = { it.uuid },
        dragDropState = dragDropState,
        enabled = isDragAndDropEnabled,
        showHeaders = showSortedGroupsHeaders,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 12.dp),
    ) { item, modifier ->
        val currentItem by rememberUpdatedState(item)
        val localClipboardManager = LocalClipboardManager.current
        val dismissState = rememberDismissState(
            confirmStateChange = {
                when (it) {
                    DismissedToEnd -> localClipboardManager.copyOtpCode(currentItem, currentTimestamp).letTrue()
                    DismissedToStart -> when (confirmCodeDismiss) {
                        true -> true.also { dismissedCode = currentItem }
                        false -> onOtpCodeDataDismiss(currentItem)
                    }

                    else -> false
                }
            },
        )
        if (dismissState.isDismissed(StartToEnd) || dismissState.isDismissed(EndToStart)) {
            LaunchedEffect(true) { dismissState.reset() }
        }
        SwipeToDismiss(
            state = dismissState,
            modifier = modifier,
            background = { DismissBackground(dismissState) },
            dismissContent = {
                OtpCodeItem(
                    timestamp = currentTimestamp,
                    item = currentItem,
                    onClick = { localClipboardManager.copyOtpCode(currentItem, currentTimestamp) },
                    onRestartCode = { onRestartCode(currentItem) },
                )
            }
        )
    }
    dismissedCode?.let { dismissed ->
        ConfirmDialog(
            onDismissRequest = { dismissedCode = null },
            onConfirmation = {
                dismissedCode = null
                onOtpCodeDataDismiss(dismissed)
            },
            text = when (val presentation = dismissed.namePresentation) {
                null -> stringResource(OpenOtpResources.strings.confirm_delete_item_prompt)
                else -> stringResource(OpenOtpResources.strings.confirm_delete_specific_item_prompt, presentation)
            },
            icon = Icons.Default.Delete,
            imageDescription = stringResource(OpenOtpResources.strings.question_icon_name),
        )
    }
}

@Composable
private fun OtpCodeItem(
    timestamp: Long,
    item: OtpData,
    onClick: () -> Unit,
    onRestartCode: () -> Unit,
) {
    ElevatedCard(
        modifier = Modifier.padding(
            top = 0.dp,
            bottom = 12.dp,
            start = 12.dp,
            end = 12.dp,
        ),
        onClick = onClick,
    ) {
        val trailingData = when (item) {
            is HotpData -> TrailingData.Restart
            is TotpData -> {
                val initialColor = MaterialTheme.colorScheme.primary
                val targetColor = MaterialTheme.colorScheme.error
                val color = remember(item, initialColor) {
                    Animatable(
                        initialValue = initialColor,
                        typeConverter = Color.VectorConverter(ColorSpaces.LinearSrgb),
                    )
                }
                LaunchedEffect(item, initialColor, targetColor) {
                    while (isActive) {
                        val left = item.timeslotLeft(currentEpochMilliseconds())
                        val offsetMillis = ((1.0 - left) * item.periodMillis).roundToInt()
                        color.animateTo(
                            targetValue = targetColor,
                            animationSpec = repeatable(
                                iterations = SINGLE_COLOR_REPEAT_ITERATIONS,
                                animation = tween(
                                    durationMillis = item.periodMillis,
                                    easing = LinearEasing,
                                ),
                                repeatMode = RepeatMode.Restart,
                                initialStartOffset = StartOffset(
                                    offsetMillis = offsetMillis,
                                    offsetType = StartOffsetType.FastForward,
                                )
                            )
                        )
                        color.snapTo(initialColor)
                    }
                }
                TrailingData.CountDown(
                    percent = item.timeslotLeft(timestamp).toFloat(),
                    color = color,
                )
            }
        }
        val itemIcon = remember(item) { item.issuer.issuerIcon }
        ListItem(
            overlineContent = overlineContent@{
                Text(
                    text = item.namePresentation ?: return@overlineContent,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            },
            headlineContent = {
                when (trailingData) {
                    is TrailingData.CountDown -> Text(
                        text = item.codePresentation(timestamp),
                        color = trailingData.color.value,
                        fontSize = 24.sp
                    )

                    is TrailingData.Restart -> Text(
                        text = item.codePresentation(timestamp),
                        fontSize = 24.sp
                    )
                }
            },
            leadingContent = {
                Icon(
                    imageVector = itemIcon,
                    contentDescription = stringResource(OpenOtpResources.strings.issuer_icon_name),
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.surfaceVariant,
                            shape = CircleShape,
                        )
                        .padding(12.dp),
                )
            },
            trailingContent = {
                when (trailingData) {
                    is TrailingData.CountDown -> CountDownStatusCircle(
                        percent = trailingData.percent,
                        color = trailingData.color.value,
                    )

                    TrailingData.Restart -> RestartButton(
                        onClick = {
                            onClick()
                            onRestartCode()
                        }
                    )
                }
            },
        )
    }
}

private sealed interface TrailingData {
    data object Restart : TrailingData
    data class CountDown(
        val percent: Float,
        val color: Animatable<Color, AnimationVector4D>,
    ) : TrailingData
}

@Composable
private fun RestartButton(
    onClick: () -> Unit,
    size: Dp = 36.dp,
) {
    ClickableIconButton(
        onClick = onClick,
        modifier = Modifier.size(size),
    ) {
        Icon(
            imageVector = Icons.Default.Cached,
            contentDescription = stringResource(OpenOtpResources.strings.restart_icon_name),
            modifier = Modifier.fillMaxSize(),
        )
    }
}

@Composable
private fun CountDownStatusCircle(
    percent: Float,
    color: Color,
    size: Dp = 28.dp,
    borderSize: Dp = 2.dp,
    padding: PaddingValues = PaddingValues(horizontal = 3.dp, vertical = 5.dp),
) = with(LocalDensity.current) {
    val sizePx = remember(size) { size.toPx() }
    val borderSizePx = remember(borderSize) { borderSize.toPx() }
    Box(
        modifier = Modifier
            .padding(padding)
            .size(size)
            .drawBehind {
                drawCircle(
                    color = color,
                    style = Stroke(borderSizePx),
                )
                drawArc(
                    color = color,
                    startAngle = 270f,
                    sweepAngle = percent * 360f,
                    useCenter = true,
                    size = Size(sizePx, sizePx),
                )
            }
    )
}

private fun OtpData.codePresentation(timestamp: Long): String {
    val code = code(timestamp)
    val length = code.length
    val halfLength = length / 2
    return code.substring(0..<halfLength) + " " + code.substring(halfLength..<length)
}

@Composable
private fun DismissBackground(dismissState: DismissState) {
    val direction = dismissState.dismissDirection ?: return

    val color by animateColorAsState(
        when (dismissState.targetValue) {
            Default -> MaterialTheme.colorScheme.surface
            DismissedToEnd -> MaterialTheme.colorScheme.secondaryContainer
            DismissedToStart -> MaterialTheme.colorScheme.errorContainer
        }
    )
    val alignment = when (direction) {
        StartToEnd -> Alignment.CenterStart
        EndToStart -> Alignment.CenterEnd
    }
    val icon = when (direction) {
        StartToEnd -> Icons.Default.ContentCopy
        EndToStart -> Icons.Default.Delete
    }
    val contentDescription = when (direction) {
        StartToEnd -> stringResource(OpenOtpResources.strings.copy_icon_name)
        EndToStart -> stringResource(OpenOtpResources.strings.delete_icon_name)
    }
    val scale by animateFloatAsState(
        targetValue = if (dismissState.targetValue == Default) 0.75f else 1f
    )
    Box(
        Modifier
            .fillMaxSize()
            .padding(bottom = 12.dp)
            .background(color)
            .padding(horizontal = 36.dp),
        contentAlignment = alignment
    ) {
        Icon(icon, contentDescription, Modifier.scale(scale))
    }
}

private const val SINGLE_COLOR_REPEAT_ITERATIONS: Int = 2 * 10
