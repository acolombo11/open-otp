package ml.dev.kotlin.openotp.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector
import ml.dev.kotlin.openotp.otp.OtpData
import ml.dev.kotlin.openotp.ui.icons.*

object OtpIcons

val OtpData.issuerIcon: ImageVector
    get() = (issuer ?: accountName)?.let { name ->
        listOf(
            OtpIcons.Adobe,
            OtpIcons.Amazon,
            OtpIcons.Autodesk,
            OtpIcons.BambooHr,
            OtpIcons.Bitwarden,
            OtpIcons.Canada,
            OtpIcons.Carta,
            OtpIcons.Cloudflare,
            OtpIcons.Coinbase,
            OtpIcons.Degiro,
            OtpIcons.Dropbox,
            OtpIcons.Envato,
            OtpIcons.Facebook,
            OtpIcons.Figma,
            OtpIcons.Firefox,
            OtpIcons.Fresco,
            OtpIcons.Gaijin,
            OtpIcons.Github,
            OtpIcons.Gitlab,
            OtpIcons.Google,
            OtpIcons.Instagram,
            OtpIcons.LinkedIn,
            OtpIcons.Microsoft,
            OtpIcons.Paypal,
            OtpIcons.Reddit,
            OtpIcons.Samsung,
            OtpIcons.Truenas,
            OtpIcons.Twitch,
            OtpIcons.Twitter,
            OtpIcons.Wise,
            OtpIcons.Ynab,
        ).find { name.contains(it.name, ignoreCase = true) }
    } ?: Icons.Filled.Lock
