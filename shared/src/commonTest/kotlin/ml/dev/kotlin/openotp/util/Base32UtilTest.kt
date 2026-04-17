package ml.dev.kotlin.openotp.util

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class Base32UtilTest {

    @Test
    fun testDecodeBase32ToByteArray() {
        val testCases = mapOf(
            "" to "",
            "MY======" to "f",
            "MZXQ====" to "fo",
            "MZXW6===" to "foo",
            "MZXW6YQ=" to "foob",
            "MZXW6YTB" to "fooba",
            "MZXW6YTBOI======" to "foobar",
            "JBSWY3DPEBLW64TMMQ" to "Hello World"
        )

        for ((encoded, expected) in testCases) {
            val decoded = encoded.decodeBase32ToByteArray()
            assertContentEquals(expected.encodeToByteArray(), decoded, "Decoding $encoded failed")
        }
    }

    @Test
    fun testIsValidBase32Secret() {
        assertTrue("JBSWY3DPEBLW64TMMQ".isValidBase32Secret)
        assertFalse("invalid base32!@#".isValidBase32Secret)
        assertFalse("".isValidBase32Secret)
        assertFalse("   ".isValidBase32Secret)
    }
}
