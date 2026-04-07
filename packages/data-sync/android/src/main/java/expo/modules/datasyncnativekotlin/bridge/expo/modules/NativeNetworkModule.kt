package expo.modules.datasyncnativekotlin.bridge.expo.modules

import expo.modules.datasyncnativekotlin.bridge.expo.mapper.toJsMap
import expo.modules.datasyncnativekotlin.di.KoinInitializer
import expo.modules.datasyncnativekotlin.sdk.api.NetworkApi
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class NativeNetworkModule : Module(), KoinComponent {
    private val networkApi: NetworkApi by inject()
    private val moduleJob = SupervisorJob()

    private val moduleScope = CoroutineScope(Dispatchers.IO + moduleJob)

    override fun definition() = ModuleDefinition {
        Name("NativeNetworkModule")

        Events("networkChanged")

        OnCreate {
            KoinInitializer.start(appContext.reactContext!!)
        }

        Function("isConnected") {
            val isConnected = networkApi.isConnected()
            return@Function isConnected
        }

        AsyncFunction("getNetworkInfo") {
            networkApi.getNetworkStatus().toJsMap()
        }

        OnStartObserving {
            moduleScope.launch {
                try {
                    networkApi.observeStatus().collect { status ->
                        sendEvent("networkChanged", status.toJsMap())
                    }
                } catch (e: Exception) {
                    println("Error observing networkChanged: ${e.message}")
                }
            }
        }

        OnDestroy {
            moduleScope.cancel("Module destroyed, cancelling all sync tasks.")
        }
    }
}
