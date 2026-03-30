package expo.modules.datasyncnativekotlin.data.remote.api

import expo.modules.datasyncnativekotlin.data.remote.dto.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {

    @GET("api/v2/pokemon/{name}")
    suspend fun getPokemonDetail(@Path("name") name: String): PokemonResponse
}
