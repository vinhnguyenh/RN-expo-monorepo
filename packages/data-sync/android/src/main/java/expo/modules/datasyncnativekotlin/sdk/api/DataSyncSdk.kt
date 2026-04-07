package expo.modules.datasyncnativekotlin.sdk.api

interface DataSyncSdk {
    suspend fun fetchPokemons(limit: Int): SdkPokemonPage
}
