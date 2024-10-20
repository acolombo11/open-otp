import android.graphics.Color
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import com.arkivanov.decompose.defaultComponentContext
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import ml.dev.kotlin.openotp.OpenOtpApp
import ml.dev.kotlin.openotp.component.OpenOtpAppComponentContext
import ml.dev.kotlin.openotp.component.OpenOtpAppComponentImpl
import ml.dev.kotlin.openotp.initOpenOtpKoin
import ml.dev.kotlin.openotp.util.BiometryAuthenticator
import org.koin.compose.KoinContext
import org.koin.dsl.module

fun ComponentActivity.androidOpenOtpApp() {
    val activity = this@androidOpenOtpApp
    initOpenOtpKoin {
        modules(
            module {
                single { OpenOtpAppComponentContext(activity) }
                single { BiometryAuthenticator(activity.applicationContext) }
            }
        )
    }
    val component = OpenOtpAppComponentImpl(defaultComponentContext())
    setContent {
        KoinContext {
            val theme by component.theme.subscribeAsState()
            val child by component.stack.subscribeAsState()

            val invert = child.active.instance.hasAppBar
            val isDark = theme.isDarkTheme()
            enableEdgeToEdge(
                statusBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT) {
                    if (invert) !isDark else isDark
                },
                navigationBarStyle = SystemBarStyle.auto(Color.TRANSPARENT, Color.TRANSPARENT) {
                    isDark
                },
            )
            OpenOtpApp(component)
        }
    }
}
