package ml.dev.kotlin.openotp.otp

import ml.dev.kotlin.openotp.util.decodeBase32ToByteArray
import org.kotlincrypto.macs.hmac.sha1.HmacSHA1
import org.kotlincrypto.macs.hmac.sha2.HmacSHA256
import org.kotlincrypto.macs.hmac.sha2.HmacSHA512
import kotlin.math.pow

class HotpGenerator(
    secret: String,
    private val config: HotpConfig
) {
    private val secret: ByteArray = secret.decodeBase32ToByteArray()

    fun generate(count: HotpCounter): String {
        val message = ByteArray(8) { i ->
            ((count shr (56 - i * 8)) and 0xFF).toByte()
        }

        val hash = when (config.hmacAlgorithm) {
            HmacAlgorithm.SHA1 -> HmacSHA1(secret)
            HmacAlgorithm.SHA256 -> HmacSHA256(secret)
            HmacAlgorithm.SHA512 -> HmacSHA512(secret)
        }.doFinal(message)

        val offset = hash.last().toInt() and 0x0F

        val binary = ((hash[offset].toInt() and 0x7F) shl 24) or
                ((hash[offset + 1].toInt() and 0xFF) shl 16) or
                ((hash[offset + 2].toInt() and 0xFF) shl 8) or
                (hash[offset + 3].toInt() and 0xFF)

        val digits = config.codeDigits.number
        val codeInt = binary % 10.0.pow(digits).toInt()

        return codeInt.toString().padStart(digits, padChar = '0')
    }
}
