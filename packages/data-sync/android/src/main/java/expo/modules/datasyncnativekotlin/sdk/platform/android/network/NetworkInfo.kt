package expo.modules.datasyncnativekotlin.core.network

data class NetworkInfo(  val isConnected: Boolean,
                         val isValidated: Boolean,
                         val type: NetworkType
)

enum class NetworkType {
    WIFI,
    CELLULAR,
    UNKNOWN
}