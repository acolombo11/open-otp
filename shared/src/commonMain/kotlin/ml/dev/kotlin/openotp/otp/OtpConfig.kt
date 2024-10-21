package ml.dev.kotlin.openotp.otp

import kotlinx.serialization.Serializable

@Serializable
data class HotpConfig(
    val codeDigits: OtpDigits = OtpDigits.Six,
    val hmacAlgorithm: HmacAlgorithm = HmacAlgorithm.SHA1,
)

@Serializable
data class TotpConfig(
    val period: TotpPeriod = TotpPeriod.Thirty,
    val codeDigits: OtpDigits = OtpDigits.Six,
    val hmacAlgorithm: HmacAlgorithm = HmacAlgorithm.SHA1,
)

fun TotpConfig.toHotpConfig(): HotpConfig = HotpConfig(codeDigits, hmacAlgorithm)
