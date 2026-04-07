package expo.modules.datasyncnativekotlin.bridge.expo.modules

import expo.modules.datasyncnativekotlin.bridge.expo.exception.CurrentActivityUnavailableException
import expo.modules.datasyncnativekotlin.di.KoinInitializer
import expo.modules.datasyncnativekotlin.sdk.api.NfcApi
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NativeNfcModule : Module(), KoinComponent {

    private val nfcApi: NfcApi by inject()

    override fun definition() = ModuleDefinition {
        Name("NativeNfcModule")

        Events("onNfcTagScanned")

        OnCreate {
            KoinInitializer.start(appContext.reactContext!!)
        }

        AsyncFunction("startNfcReader") {
            val activity = appContext.currentActivity ?: throw CurrentActivityUnavailableException()
            val result = nfcApi.startSession(activity) { tagData ->
                sendEvent(
                    "onNfcTagScanned", mapOf(
                        "tagId" to tagData,
                        "timestamp" to System.currentTimeMillis()
                    )
                )
            }

            return@AsyncFunction result
        }

        Function("stopNfcReader") {
            val activity = appContext.currentActivity ?: throw CurrentActivityUnavailableException()

            nfcApi.stopSession(activity)
        }
    }
}
