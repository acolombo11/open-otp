package ml.dev.kotlin.openotp.util

import com.russhwolf.settings.Settings
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.updateAndGet
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import ml.dev.kotlin.openotp.component.OpenOtpAppComponentContext


private val SecureStoredMutableValueJson: Json = Json {
    encodeDefaults = true
    ignoreUnknownKeys = true
}

class StateFlowSettings<T : Any>(
    private val name: String,
    context: OpenOtpAppComponentContext,
    private val serializer: KSerializer<T>,
    private val default: T,
    dispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    private val settings: Settings = createSettings(name, context)

    private fun readStoredValue(): T = settings.getStringOrNull(name)?.let { readEncoded ->
        SecureStoredMutableValueJson.decodeFromString(serializer, readEncoded)
    } ?: default

    private fun writeStoredValue(value: T) {
        val encoded = SecureStoredMutableValueJson.encodeToString(serializer, value)
        settings.putString(name, encoded)
    }

    private val _stateFlow: MutableStateFlow<T> = MutableStateFlow(runBlocking(dispatcher) { readStoredValue() })
    val stateFlow: StateFlow<T> = _stateFlow.asStateFlow()

    fun update(function: (oldValue: T) -> T): T =
        _stateFlow.updateAndGet { current ->
            function(current).also { writeStoredValue(it) }
        }
}