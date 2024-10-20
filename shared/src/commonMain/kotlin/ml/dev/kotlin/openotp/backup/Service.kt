package ml.dev.kotlin.openotp.backup

import io.ktor.util.encodeBase64
import org.kotlincrypto.SecureRandom
import org.kotlincrypto.hash.sha2.SHA256

private fun ByteArray.encodeBase64Rep(): String = encodeBase64()
    .replace('+', '-')
    .replace('/', '_')
    .replace("=", "")

data class AccessData(
    val codeVerifier: String,
    val codeChallenge: String,
)

internal fun getAccessData(): AccessData? {
    val bytes = try {
        ByteArray(32).apply(SecureRandom()::nextBytesCopyTo)
    } catch (e: Exception) {
        return null
    }
    val codeVerifier = bytes.encodeBase64Rep()
    val codeChallenge = SHA256().digest(codeVerifier.encodeToByteArray()).encodeBase64Rep()
    return AccessData(codeVerifier, codeChallenge)
}