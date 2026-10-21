package ml.dev.kotlin.openotp.util

private const val UNRESERVED = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.~"

fun percentEncode(value: String): String = buildString {
    value.encodeToByteArray().forEach { byte ->
        val char = (byte.toInt() and 0xFF).toChar()
        if (char in UNRESERVED) {
            append(char)
        } else {
            append('%')
            append((byte.toInt() and 0xFF).toString(16).uppercase().padStart(2, '0'))
        }
    }
}
