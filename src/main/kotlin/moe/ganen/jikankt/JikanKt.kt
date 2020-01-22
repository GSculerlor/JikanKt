package moe.ganen.jikankt

import com.google.gson.GsonBuilder
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.models.anime.Anime
import moe.ganen.jikankt.models.anime.AnimeCharactersStaff
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.utils.InterfaceAdapter
import moe.ganen.jikankt.utils.deserialize

object JikanKt {
    private val restClient = RestClient()
    private val gson = GsonBuilder().registerTypeAdapter(Entity::class.java, InterfaceAdapter<Entity>()).create()

    //region Anime

    suspend fun getAnime(id: Int): Anime = gson.deserialize(restClient.request("anime/$id"), Anime::class.java)

    suspend fun getAnimeCharactersStaff(id: Int): AnimeCharactersStaff =
        gson.deserialize(restClient.request("anime/$id/characters_staff"), AnimeCharactersStaff::class.java)

    //endregion
}