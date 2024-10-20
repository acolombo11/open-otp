package ml.dev.kotlin.openotp.util

import androidx.compose.runtime.Composable
import ml.dev.kotlin.openotp.component.OpenOtpAppComponentContext
import org.koin.compose.koinInject

interface Named {
    val OpenOtpAppComponentContext.presentableName: String

    @Composable
    fun presentableName(): String {
        val context = koinInject<OpenOtpAppComponentContext>()
        return context.presentableName
    }
}
