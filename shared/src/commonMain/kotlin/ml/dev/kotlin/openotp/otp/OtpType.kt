package ml.dev.kotlin.openotp.otp

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import ml.dev.kotlin.openotp.component.OpenOtpAppComponentContext
import ml.dev.kotlin.openotp.shared.OpenOtpResources
import ml.dev.kotlin.openotp.shared.hotp_presentation
import ml.dev.kotlin.openotp.shared.totp_presentation
import ml.dev.kotlin.openotp.util.Named

@Serializable
enum class OtpType : Named {
    TOTP, HOTP;

    @Transient
    override val OpenOtpAppComponentContext.presentableName: String
        get() = stringResource(
            when (this@OtpType) {
                TOTP -> OpenOtpResources.strings.totp_presentation
                HOTP -> OpenOtpResources.strings.hotp_presentation
            }
        )
}
