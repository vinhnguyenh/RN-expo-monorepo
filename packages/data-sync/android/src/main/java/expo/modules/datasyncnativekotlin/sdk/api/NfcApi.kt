package expo.modules.datasyncnativekotlin.sdk.api

import android.app.Activity

interface NfcApi {
    fun startSession(activity: Activity, onTagRead: (String) -> Unit): Boolean
    fun stopSession(activity: Activity)
}