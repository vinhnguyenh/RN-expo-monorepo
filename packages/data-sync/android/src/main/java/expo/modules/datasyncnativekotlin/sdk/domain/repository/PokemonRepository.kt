package expo.modules.datasyncnativekotlin.sdk.domain.repository

import expo.modules.datasyncnativekotlin.sdk.domain.model.PokemonPage

interface PokemonRepository {
    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonPage>
}