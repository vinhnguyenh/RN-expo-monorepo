package expo.modules.datasyncnativekotlin.bridge.expo.exception

import expo.modules.kotlin.exception.CodedException

class CurrentActivityUnavailableException : CodedException(
    "The current Activity screen was not found. Please restart the application."
)
