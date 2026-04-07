package expo.modules.datasyncnativekotlin.sdk.api

import expo.modules.datasyncnativekotlin.bridge.expo.dto.PokemonPageJSDto

interface DataSyncSdk {
    suspend fun fetchPokemons(limit: Int): PokemonPageJSDto
}