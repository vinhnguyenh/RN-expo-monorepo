package expo.modules.datasyncnativekotlin.presentation.modules


import expo.modules.datasyncnativekotlin.core.network.AndroidNetworkMonitor
import expo.modules.datasyncnativekotlin.core.network.NetworkMonitor
import expo.modules.kotlin.modules.Module
import expo.modules.kotlin.modules.ModuleDefinition
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class NetworkModule: Module()
{
    private val networkMonitor: NetworkMonitor by lazy {
        val context = appContext.reactContext ?: throw IllegalStateException("React Context bị null")
        // Khởi tạo Implementation và gán vào Interface
        AndroidNetworkMonitor(context)
    }
    private val moduleJob = SupervisorJob()

    private val moduleScope = CoroutineScope(Dispatchers.IO + moduleJob)

    override fun definition() = ModuleDefinition {
        Name("NetworkModule")

        Events("networkChanged")
        
        Function("isConnected") {
            val isConnected = networkMonitor.isConnected()
            return@Function isConnected
        }

        AsyncFunction("getNetworkInfo") {
            val info = networkMonitor.getNetworkInfo()

            mapOf(
                "isConnected" to info.isConnected,
                "isValidated" to info.isValidated,
                "type" to info.type.name
            )
        }

        OnStartObserving {
            moduleScope.launch {
                try {
                    networkMonitor.observeInfo().collect { info ->
                        sendEvent(
                            "networkChanged", mapOf(
                                "isConnected" to info.isConnected,
                                "isValidated" to info.isValidated,
                                "type" to info.type.name
                            )
                        )
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