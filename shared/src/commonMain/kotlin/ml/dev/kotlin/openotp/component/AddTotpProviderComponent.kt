package ml.dev.kotlin.openotp.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.Value
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ml.dev.kotlin.openotp.otp.*
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.shared.authenticate_request_title
import ml.dev.kotlin.openotp.shared.counter_field
import ml.dev.kotlin.openotp.shared.qr_code_authenticate_request_description
import ml.dev.kotlin.openotp.shared.invalid_field_name_provided_formatted
import ml.dev.kotlin.openotp.shared.secret_field
import ml.dev.kotlin.openotp.util.BiometryAuthenticator
import ml.dev.kotlin.openotp.util.isValidBase32Secret
import ml.dev.kotlin.openotp.util.percentEncode
import org.koin.core.component.get

interface AddOtpProviderComponent {

    val issuer: Value<String>
    val accountName: Value<String>
    val secret: Value<String>
    val secretIsError: Value<Boolean>
    val algorithm: Value<HmacAlgorithm>
    val digits: Value<OtpDigits>
    /** `otpauth://` URI of the revealed QR code, empty while it is hidden. */
    val qrCodeUri: Value<String>

    fun onIssuerChanged(issuer: String)
    fun onAccountNameChanged(accountName: String)
    fun onSecretChanged(secret: String)
    fun onAlgorithmSelected(algorithm: HmacAlgorithm)
    fun onDigitsSelected(digits: OtpDigits)
    fun onRevealQrCodeClicked()
    fun onHideQrCodeClicked()
    fun onSaveClicked()
    fun onCancelClicked()
}

interface AddTotpProviderComponent : AddOtpProviderComponent {

    val period: Value<TotpPeriod>

    fun onPeriodSelected(period: TotpPeriod)
}

interface AddHotpProviderComponent : AddOtpProviderComponent {

    val counter: Value<String>
    val counterIsError: Value<Boolean>

    fun onCounterChanged(counter: String)
}

abstract class AddOtpProviderComponentImpl(
    componentContext: ComponentContext,
    private val originalData: OtpData?,
    private val navigateOnSaveClicked: () -> Unit,
    private val navigateOnCancelClicked: () -> Unit,
) : AbstractBackupComponent(componentContext), AddOtpProviderComponent {

    private val authenticator: BiometryAuthenticator = get()

    private val _qrCodeUri: MutableStateFlow<String> = MutableStateFlow("")

    override /** `otpauth://` URI of the revealed QR code, empty while it is hidden. */
    val qrCodeUri: Value<String> = _qrCodeUri.asValue()

    /** `otpauth://` URI for the current form values, or `null` if they are not valid yet. */
    protected abstract fun otpAuthUri(): String?

    override fun onRevealQrCodeClicked() {
        val uri = otpAuthUri() ?: return notifyInvalidSecret()
        scope.launch {
            val authenticated = try {
                authenticator.checkBiometryAuthentication(
                    requestTitle = stringResource(OpenOtpResources.strings.authenticate_request_title),
                    requestReason = stringResource(OpenOtpResources.strings.qr_code_authenticate_request_description),
                )
            } catch (_: Exception) {
                false
            }
            if (authenticated) _qrCodeUri.value = uri
        }
    }

    override fun onHideQrCodeClicked() {
        _qrCodeUri.value = ""
    }

    protected fun otpAuthUri(
        type: String,
        issuer: String,
        accountName: String,
        secret: String,
        algorithm: HmacAlgorithm,
        digits: OtpDigits,
        extraParameters: String,
    ): String? {
        if (!secret.isValidBase32Secret) return null
        val label = if (issuer.isBlank()) percentEncode(accountName)
        else "${percentEncode(issuer)}:${percentEncode(accountName)}"
        val issuerParameter = if (issuer.isBlank()) "" else "&issuer=${percentEncode(issuer)}"
        return "otpauth://$type/$label?secret=${percentEncode(secret.filterNot { it.isWhitespace() })}$issuerParameter&algorithm=${algorithm.name}&digits=${digits.number}&$extraParameters"
    }

    protected fun notifyInvalid(fieldName: String) {
        toast(message = stringResource(OpenOtpResources.strings.invalid_field_name_provided_formatted, fieldName))
    }

    protected fun notifyInvalidSecret() =
        notifyInvalid(fieldName = stringResource(OpenOtpResources.strings.secret_field))

    override fun onCancelClicked() {
        navigateOnCancelClicked()
    }

    protected fun update(codeData: OtpData) {
        _userOtpCodeData
            .updateInScope { list ->
                originalData?.let { old ->
                    list.map { if (it == old ) codeData else it }
                } ?: (list + codeData)
            }
            .invokeOnCompletion {
                navigateOnSaveClicked()
            }
    }
}

class AddTotpProviderComponentImpl(
    componentContext: ComponentContext,
    originalData: OtpData? = null,
    navigateOnSaveClicked: () -> Unit,
    navigateOnCancelClicked: () -> Unit,
) : AddOtpProviderComponentImpl(
    componentContext = componentContext,
    navigateOnSaveClicked = navigateOnSaveClicked,
    navigateOnCancelClicked = navigateOnCancelClicked,
    originalData = originalData,
), AddTotpProviderComponent {

    private data class TotpModel(
        val issuer: String = "",
        val accountName: String = "",
        val secret: String = "",
        val secretIsError: Boolean = true,
        val algorithm: HmacAlgorithm = TotpConfig().hmacAlgorithm,
        val digits: OtpDigits = TotpConfig().codeDigits,
        val period: TotpPeriod = TotpConfig().period,
    )

    private val model: MutableStateFlow<TotpModel> = MutableStateFlow(TotpModel())

    override val issuer: Value<String> = model.map { it.issuer }.asValue()
    override val accountName: Value<String> = model.map { it.accountName }.asValue()
    override val secret: Value<String> = model.map { it.secret }.asValue()
    override val secretIsError: Value<Boolean> = model.map { it.secretIsError }.asValue()
    override val algorithm: Value<HmacAlgorithm> = model.map { it.algorithm }.asValue()
    override val digits: Value<OtpDigits> = model.map { it.digits }.asValue()
    override val period: Value<TotpPeriod> = model.map { it.period }.asValue()

    override fun onIssuerChanged(issuer: String) {
        onHideQrCodeClicked()
        model.update { it.copy(issuer = issuer) }
    }

    override fun onAccountNameChanged(accountName: String) {
        onHideQrCodeClicked()
        model.update { it.copy(accountName = accountName) }
    }

    override fun onSecretChanged(secret: String) {
        onHideQrCodeClicked()
        val secretIsError = !secret.isValidBase32Secret
        model.update {
            it.copy(
                secret = secret,
                secretIsError = secretIsError,
            )
        }
    }

    override fun onAlgorithmSelected(algorithm: HmacAlgorithm) {
        onHideQrCodeClicked()
        model.update { it.copy(algorithm = algorithm) }
    }

    override fun onDigitsSelected(digits: OtpDigits) {
        onHideQrCodeClicked()
        model.update { it.copy(digits = digits) }
    }

    override fun onPeriodSelected(period: TotpPeriod) {
        onHideQrCodeClicked()
        model.update { it.copy(period = period) }
    }

    override fun otpAuthUri(): String? = with(model.value) {
        otpAuthUri("totp", issuer, accountName, secret, algorithm, digits, "period=${period.millis / 1000}")
    }

    override fun onSaveClicked() = with(model.value) {
        val secret = secret
        if (!secret.isValidBase32Secret) {
            notifyInvalidSecret()
            return@with
        }

        val config = TotpConfig(period, digits, algorithm)
        val codeData = TotpData(issuer, accountName, secret, config)
        update(codeData)
    }
}

class AddHotpProviderComponentImpl(
    componentContext: ComponentContext,
    originalData: OtpData? = null,
    navigateOnSaveClicked: () -> Unit,
    navigateOnCancelClicked: () -> Unit,
) : AddOtpProviderComponentImpl(
    componentContext = componentContext,
    navigateOnSaveClicked = navigateOnSaveClicked,
    navigateOnCancelClicked = navigateOnCancelClicked,
    originalData = originalData,
), AddHotpProviderComponent {

    private data class HotpModel(
        val issuer: String = "",
        val accountName: String = "",
        val secret: String = "",
        val secretIsError: Boolean = true,
        val algorithm: HmacAlgorithm = HotpConfig().hmacAlgorithm,
        val digits: OtpDigits = HotpConfig().codeDigits,
        val counter: String = "0",
        val counterIsError: Boolean = false,
    )

    private val model: MutableStateFlow<HotpModel> = MutableStateFlow(HotpModel())

    override val issuer: Value<String> = model.map { it.issuer }.asValue()
    override val accountName: Value<String> = model.map { it.accountName }.asValue()
    override val secret: Value<String> = model.map { it.secret }.asValue()
    override val secretIsError: Value<Boolean> = model.map { it.secretIsError }.asValue()
    override val algorithm: Value<HmacAlgorithm> = model.map { it.algorithm }.asValue()
    override val digits: Value<OtpDigits> = model.map { it.digits }.asValue()
    override val counter: Value<String> = model.map { it.counter }.asValue()
    override val counterIsError: Value<Boolean> = model.map { it.counterIsError }.asValue()

    override fun onIssuerChanged(issuer: String) {
        onHideQrCodeClicked()
        model.update { it.copy(issuer = issuer) }
    }

    override fun onAccountNameChanged(accountName: String) {
        onHideQrCodeClicked()
        model.update { it.copy(accountName = accountName) }
    }

    override fun onSecretChanged(secret: String) {
        onHideQrCodeClicked()
        val secretIsError = !secret.isValidBase32Secret
        model.update {
            it.copy(
                secret = secret,
                secretIsError = secretIsError,
            )
        }
    }

    override fun onAlgorithmSelected(algorithm: HmacAlgorithm) {
        onHideQrCodeClicked()
        model.update { it.copy(algorithm = algorithm) }
    }

    override fun onDigitsSelected(digits: OtpDigits) {
        onHideQrCodeClicked()
        model.update { it.copy(digits = digits) }
    }

    override fun onCounterChanged(counter: String) {
        onHideQrCodeClicked()
        val counterIsValid = counter.toLongOrNull().isValid()
        val canUpdateCounter = counterIsValid || counter.isBlank()
        if (!canUpdateCounter) {
            return
        }
        model.update {
            it.copy(
                counter = counter,
                counterIsError = !counterIsValid,
            )
        }
    }

    override fun otpAuthUri(): String? = with(model.value) {
        val counter = counter.toLongOrNull().takeIf { it.isValid() } ?: return null
        otpAuthUri(
            type = "hotp",
            issuer = issuer,
            accountName = accountName,
            secret = secret,
            algorithm = algorithm,
            digits = digits,
            extraParameters = "counter=$counter",
        )
    }

    override fun onSaveClicked() = with(model.value) {
        val secret = secret
        if (!secret.isValidBase32Secret) {
            notifyInvalidSecret()
            return@with
        }
        val counter = counter.toLongOrNull()
        if (!counter.isValid()) {
            notifyInvalidCounter()
            return@with
        }

        val config = HotpConfig(digits, algorithm)
        val codeData = HotpData(issuer, accountName, secret, counter, config)
        update(codeData)
    }

    private fun notifyInvalidCounter() =
        notifyInvalid(fieldName = stringResource(OpenOtpResources.strings.counter_field))
}
