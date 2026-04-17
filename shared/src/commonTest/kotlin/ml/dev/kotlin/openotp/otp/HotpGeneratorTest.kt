package ml.dev.kotlin.openotp.otp

import kotlin.test.Test
import kotlin.test.assertEquals

class HotpGeneratorTest {

    @Test
    fun testGenerateSha1() {
        val secret = "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQ" // "12345678901234567890" in base32
        val config = HotpConfig(codeDigits = OtpDigits.Six, hmacAlgorithm = HmacAlgorithm.SHA1)
        val generator = HotpGenerator(secret, config)

        val expected = mapOf(
            0L to "755224",
            1L to "287082",
            2L to "359152",
            3L to "969429",
            4L to "338314",
            5L to "254676",
            6L to "287922",
            7L to "162583",
            8L to "399871",
            9L to "520489"
        )

        for ((counter, code) in expected) {
            val actual = generator.generate(counter)
            assertEquals(code, actual, "Failed for counter $counter. Expected $code, but got $actual")
        }
    }

    @Test
    fun testGenerateSha256() {
        val secret = "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZA====" // "12345678901234567890123456789012" in base32
        val config = HotpConfig(codeDigits = OtpDigits.Six, hmacAlgorithm = HmacAlgorithm.SHA256)
        val generator = HotpGenerator(secret, config)

        val expected = mapOf(
            0L to "920136",
            1L to "119246",
            2L to "882438",
            3L to "975832",
            4L to "791148",
            5L to "744399",
            6L to "668833",
            7L to "276785",
            8L to "778880",
            9L to "242340"
        )

        for ((counter, code) in expected) {
            val actual = generator.generate(counter)
            assertEquals(code, actual, "Failed for counter $counter. Expected $code, but got $actual")
        }
    }

    @Test
    fun testGenerateSha512() {
        val secret = "GEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNBVGY3TQOJQGEZDGNA=" // "1234567890123456789012345678901234567890123456789012345678901234" in base32
        val config = HotpConfig(codeDigits = OtpDigits.Six, hmacAlgorithm = HmacAlgorithm.SHA512)
        val generator = HotpGenerator(secret, config)

        val expected = mapOf(
            0L to "550594",
            1L to "693936",
            2L to "765371",
            3L to "628588",
            4L to "977270",
            5L to "407012",
            6L to "383831",
            7L to "656234",
            8L to "504704",
            9L to "467051"
        )

        for ((counter, code) in expected) {
            val actual = generator.generate(counter)
            assertEquals(code, actual, "Failed for counter $counter. Expected $code, but got $actual")
        }
    }
}
