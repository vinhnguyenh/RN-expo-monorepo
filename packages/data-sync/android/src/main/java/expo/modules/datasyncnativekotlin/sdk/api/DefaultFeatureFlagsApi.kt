package expo.modules.datasyncnativekotlin.sdk.api

import expo.modules.datasyncnativekotlin.sdk.domain.manager.FeatureFlagManager

class DefaultFeatureFlagsApi(
    private val featureFlagManager: FeatureFlagManager
) : FeatureFlagsApi {

    override fun isFeatureEnabled(featureKey: String, defaultValue: Boolean): Boolean {
        return featureFlagManager.isFeatureEnabled(featureKey, defaultValue)
    }

    override fun getAllFlags(): Map<String, Boolean> {
        return featureFlagManager.getAllFlags()
    }

    override suspend fun syncFlags() {
        featureFlagManager.syncFlagsFromServer()
    }
}
