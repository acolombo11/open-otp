package ml.dev.kotlin.openotp.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Cancel
import androidx.compose.material.icons.outlined.Save
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.shared.OpenOtpResources

@Composable
internal fun FormConfirmButtons(
    confirm: FormConfirmButtonData,
    cancel: FormConfirmButtonData,
    modifier: Modifier = Modifier,
    buttonPadding: PaddingValues = FormButtonStandardPadding,
    iconPadding: Dp = FormButtonIconSpacing,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            FilledTonalButton(
                onClick = cancel.onClick,
                contentPadding = buttonPadding,
            ) {
                Icon(imageVector = cancel.imageVector, contentDescription = cancel.contentDescription)
                Spacer(Modifier.width(iconPadding))
                Text(
                    text = cancel.text,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
            Button(
                onClick = confirm.onClick,
                contentPadding = buttonPadding
            ) {
                Icon(imageVector = confirm.imageVector, contentDescription = confirm.contentDescription)
                Spacer(Modifier.width(iconPadding))
                Text(
                    text = confirm.text,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}

internal val FormButtonStandardPadding = PaddingValues(
    horizontal = 20.dp,
    vertical = 12.dp,
)

internal val FormButtonIconSpacing = 8.dp

internal val FormButtonsStandardHeight: Dp = 48.dp

internal class FormConfirmButtonData(
    val text: String,
    val contentDescription: String?,
    val imageVector: ImageVector,
    val onClick: () -> Unit,
)

@Composable
internal fun SaveCancelFormConfirmButtons(
    modifier: Modifier = Modifier,
    onSaveClicked: () -> Unit,
    onCancelClicked: () -> Unit,
) {
    val saveText = stringResource(OpenOtpResources.strings.save_button_name)
    val cancelText = stringResource(OpenOtpResources.strings.cancel_button_name)
    FormConfirmButtons(
        modifier = modifier.padding(16.dp),
        confirm = FormConfirmButtonData(
            text = saveText,
            contentDescription = saveText,
            imageVector = Icons.Outlined.Save,
            onClick = onSaveClicked,
        ),
        cancel = FormConfirmButtonData(
            text = cancelText,
            contentDescription = cancelText,
            imageVector = Icons.Outlined.Cancel,
            onClick = onCancelClicked,
        )
    )
}
