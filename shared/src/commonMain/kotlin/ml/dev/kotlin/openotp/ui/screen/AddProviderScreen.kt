package ml.dev.kotlin.openotp.ui.screen

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pin
import androidx.compose.material.icons.filled.QrCode2
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import kotlinx.coroutines.delay
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import dev.icerock.moko.resources.compose.stringResource
import ml.dev.kotlin.openotp.component.AddHotpProviderComponent
import ml.dev.kotlin.openotp.component.AddOtpProviderComponent
import ml.dev.kotlin.openotp.component.AddTotpProviderComponent
import ml.dev.kotlin.openotp.otp.HmacAlgorithm
import ml.dev.kotlin.openotp.otp.OtpDigits
import ml.dev.kotlin.openotp.otp.OtpType
import ml.dev.kotlin.openotp.otp.OtpType.HOTP
import ml.dev.kotlin.openotp.otp.OtpType.TOTP
import ml.dev.kotlin.openotp.otp.TotpPeriod
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.shared.account_details_group_name
import ml.dev.kotlin.openotp.shared.account_name_field_name
import ml.dev.kotlin.openotp.shared.advanced_settings_group_name
import ml.dev.kotlin.openotp.shared.algorithm_field_name
import ml.dev.kotlin.openotp.shared.counter_field_name
import ml.dev.kotlin.openotp.shared.digits_field_name
import ml.dev.kotlin.openotp.shared.issuer_field_name
import ml.dev.kotlin.openotp.shared.authenticator_key_group_name
import ml.dev.kotlin.openotp.shared.copied
import ml.dev.kotlin.openotp.shared.qr_code_tap_to_hide
import ml.dev.kotlin.openotp.shared.qr_code_tap_to_reveal
import ml.dev.kotlin.openotp.shared.period_field_name
import ml.dev.kotlin.openotp.shared.secret_field_name
import androidx.compose.foundation.shape.RoundedCornerShape
import ml.dev.kotlin.openotp.ui.component.*

@Composable
internal fun AddProviderScreen(
    totpComponent: AddTotpProviderComponent,
    hotpComponent: AddHotpProviderComponent,
    otpType: OtpType = OtpType.entries.first(),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .windowInsetsPadding(WindowInsets.statusBars),
    ) {
        var selected by remember { mutableStateOf(otpType) }
        TabRow(selectedTabIndex = selected.ordinal) {
            OtpType.entries.forEach { type ->
                Tab(
                    text = { Text(type.presentableName()) },
                    selected = type == selected,
                    onClick = { selected = type },
                    icon = {
                        when (type) {
                            TOTP -> Icon(
                                imageVector = Icons.Default.Update,
                                contentDescription = type.presentableName()
                            )

                            HOTP -> Icon(
                                imageVector = Icons.Default.Pin,
                                contentDescription = type.presentableName()
                            )
                        }
                    }
                )
            }
        }
        BoxWithConstraints {
            val totpOffset by animateDpAsState(
                targetValue = when (selected) {
                    TOTP -> 0.dp
                    HOTP -> -maxWidth
                }
            )
            val hotpOffset by animateDpAsState(
                targetValue = when (selected) {
                    TOTP -> maxWidth
                    HOTP -> 0.dp
                }
            )
            Box(modifier = Modifier.offset(x = totpOffset)) {
                AddTotpProviderScreen(totpComponent)
            }
            Box(modifier = Modifier.offset(x = hotpOffset)) {
                AddHotpProviderScreen(hotpComponent)
            }
            AddProviderFormConfirmButtons(
                component = when (selected) {
                    TOTP -> totpComponent
                    HOTP -> hotpComponent
                }
            )
        }
    }
}

@Composable
private fun AddProviderFormConfirmButtons(component: AddOtpProviderComponent) {
    SaveCancelFormConfirmButtons(
        modifier = Modifier.windowInsetsPadding(WindowInsets.navigationBars),
        onSaveClicked = component::onSaveClicked,
        onCancelClicked = component::onCancelClicked,
    )
}

@Composable
private fun AddTotpProviderScreen(component: AddTotpProviderComponent) {
    AddOtpProviderScreen(component) {
        val selectedAlgorithm by component.algorithm.subscribeAsState()
        NamedDropdownMenu(
            name = stringResource(OpenOtpResources.strings.algorithm_field_name),
            selected = selectedAlgorithm,
            anyItems = HmacAlgorithm.entries,
            onSelected = component::onAlgorithmSelected,
        )

        val selectedDigits by component.digits.subscribeAsState()
        NamedDropdownMenu(
            name = stringResource(OpenOtpResources.strings.digits_field_name),
            selected = selectedDigits,
            anyItems = OtpDigits.entries,
            onSelected = component::onDigitsSelected,
        )

        val selectedPeriod by component.period.subscribeAsState()
        NamedDropdownMenu(
            name = stringResource(OpenOtpResources.strings.period_field_name),
            selected = selectedPeriod,
            anyItems = TotpPeriod.entries,
            onSelected = component::onPeriodSelected,
        )
    }
}

@Composable
private fun AddHotpProviderScreen(component: AddHotpProviderComponent) {
    AddOtpProviderScreen(component) {
        val counter by component.counter.subscribeAsState()
        val counterIsError by component.counterIsError.subscribeAsState()
        FormField(
            name = stringResource(OpenOtpResources.strings.counter_field_name),
            text = counter,
            onTextChange = component::onCounterChanged,
            isError = counterIsError,
            buttonType = FormFieldButtonType.Done,
        )

        val selectedAlgorithm by component.algorithm.subscribeAsState()
        NamedDropdownMenu(
            name = stringResource(OpenOtpResources.strings.algorithm_field_name),
            selected = selectedAlgorithm,
            anyItems = HmacAlgorithm.entries,
            onSelected = component::onAlgorithmSelected,
        )

        val selectedDigits by component.digits.subscribeAsState()
        NamedDropdownMenu(
            name = stringResource(OpenOtpResources.strings.digits_field_name),
            selected = selectedDigits,
            anyItems = OtpDigits.entries,
            onSelected = component::onDigitsSelected,
        )
    }
}

@Composable
private fun AddOtpProviderScreen(
    component: AddOtpProviderComponent,
    advancedSettingsContent: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .windowInsetsPadding(WindowInsets.navigationBars)
            .padding(18.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        AccountDetails(component)
        AuthenticatorKey(component)
        FormGroup(
            groupName = stringResource(OpenOtpResources.strings.advanced_settings_group_name),
            content = advancedSettingsContent,
        )
        Spacer(Modifier.height(FormButtonsStandardHeight))
    }
}

@Composable
private fun AccountDetails(component: AddOtpProviderComponent) {
    FormGroup(
        groupName = stringResource(OpenOtpResources.strings.account_details_group_name)
    ) {
        val issuer by component.issuer.subscribeAsState()
        FormField(
            name = stringResource(OpenOtpResources.strings.issuer_field_name),
            text = issuer,
            onTextChange = component::onIssuerChanged,
        )

        val accountName by component.accountName.subscribeAsState()
        FormField(
            name = stringResource(OpenOtpResources.strings.account_name_field_name),
            text = accountName,
            onTextChange = component::onAccountNameChanged,
        )

        val secret by component.secret.subscribeAsState()
        val secretIsError by component.secretIsError.subscribeAsState()
        FormField(
            name = stringResource(OpenOtpResources.strings.secret_field_name),
            text = secret,
            isError = secretIsError,
            onTextChange = component::onSecretChanged,
            buttonType = when (component) {
                is AddTotpProviderComponent -> FormFieldButtonType.Done
                is AddHotpProviderComponent -> FormFieldButtonType.Next
                else -> FormFieldButtonType.Done
            },
            password = true,
        )
    }
}

@Composable
private fun AuthenticatorKey(component: AddOtpProviderComponent) {
    FormGroup(
        groupName = stringResource(OpenOtpResources.strings.authenticator_key_group_name)
    ) {
        val qrCodeUri by component.qrCodeUri.subscribeAsState()
        val secret by component.secret.subscribeAsState()
        val revealed = qrCodeUri.isNotEmpty()
        val toggle = if (revealed) component::onHideQrCodeClicked else component::onRevealQrCodeClicked
        val clipboardManager = LocalClipboardManager.current
        var copied by remember { mutableStateOf(false) }
        LaunchedEffect(copied, revealed) {
            if (copied) {
                delay(2000)
                copied = false
            }
        }
        LaunchedEffect(revealed) {
            if (!revealed) copied = false
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier
                    .size(QrCodeSize)
                    .clip(RoundedCornerShape(12.dp))
                    .background(if (revealed) Color.White else MaterialTheme.colorScheme.surfaceVariant)
                    .clickable(onClick = toggle),
                contentAlignment = Alignment.Center,
            ) {
                if (revealed) {
                    QrCode(data = qrCodeUri, modifier = Modifier.fillMaxSize().padding(12.dp))
                } else {
                    Icon(
                        imageVector = Icons.Default.QrCode2,
                        contentDescription = null,
                        modifier = Modifier.size(QrCodeSize / 2),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                    )
                }
            }
            Text(
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .clickable(enabled = revealed) {
                        clipboardManager.setText(AnnotatedString(secret))
                        copied = true
                    },
                text = if (revealed) secret else "\u2022".repeat(secret.length),
                style = MaterialTheme.typography.bodySmall.copy(fontFamily = FontFamily.Monospace),
                maxLines = 1,
                softWrap = false,
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier.clip(RoundedCornerShape(4.dp)).clickable(onClick = toggle),
                text = stringResource(
                    when {
                        !revealed -> OpenOtpResources.strings.qr_code_tap_to_reveal
                        copied -> OpenOtpResources.strings.copied
                        else -> OpenOtpResources.strings.qr_code_tap_to_hide
                    }
                ),
                style = MaterialTheme.typography.bodySmall,
                textAlign = TextAlign.Center,
            )
        }
    }
}

private val QrCodeSize = 220.dp
