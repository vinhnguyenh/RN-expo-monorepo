package expo.modules.datasyncnativekotlin.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResponse(
    val id: Int,
    val name: String,
    val weight: Int,
    val height: Int,
    val sprites: Sprites
)

@Serializable
data class Sprites(
    @SerialName("front_default")
    val frontDefault: String?
)
