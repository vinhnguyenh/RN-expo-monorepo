package expo.modules.datasyncnativekotlin.data.repository

import expo.modules.datasyncnativekotlin.data.remote.NetworkClient.providePokeApi
import expo.modules.datasyncnativekotlin.data.remote.NetworkClient.provideRetrofit
import expo.modules.datasyncnativekotlin.data.remote.dto.PokemonResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonRepository {
    private val api = providePokeApi(provideRetrofit())

    suspend fun fetchPokemon(name: String): PokemonResponse? {
        return withContext(Dispatchers.IO) {
            try {
                // Gọi API thực tế
                val result = api.getPokemonDetail(name.lowercase())
                println("Thành công! Lấy được dữ liệu của: ${result.name}, nặng: ${result.weight}")
                result
            } catch (e: Exception) {
                println("Lỗi gọi API: ${e.message}")
                null
            }
        }
    }






}