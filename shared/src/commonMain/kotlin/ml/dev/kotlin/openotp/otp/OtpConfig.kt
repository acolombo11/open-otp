package ml.dev.kotlin.openotp.otp

import kotlinx.serialization.Serializable

@Serializable
data class HotpConfig(
    val codeDigits: OtpDigits = OtpDigits.Six,
    val hmacAlgorithm: HmacAlgorithm = HmacAlgorithm.SHA1,
) {
    companion object {
        val DEFAULT: HotpConfig get() = HotpConfig()
    }
}

@Serializable
data class TotpConfig(
    val period: TotpPeriod = TotpPeriod.Thirty,
    val codeDigits: OtpDigits = OtpDigits.Six,
    val hmacAlgorithm: HmacAlgorithm = HmacAlgorithm.SHA1,
) {
    companion object {
        val DEFAULT: TotpConfig get() = TotpConfig()
    }
}

fun TotpConfig.toHotpConfig(): HotpConfig = HotpConfig(codeDigits, hmacAlgorithm)
