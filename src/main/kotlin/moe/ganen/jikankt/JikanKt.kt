package moe.ganen.jikankt

import com.google.gson.GsonBuilder
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.models.anime.*
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.utils.InterfaceAdapter
import moe.ganen.jikankt.utils.deserialize

object JikanKt {
    private val restClient = RestClient()
    private val gson = GsonBuilder().registerTypeAdapter(Entity::class.java, InterfaceAdapter<Entity>()).create()

    //region Anime

    /**
     * Function to get anime by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return Anime with given MyAnimeList id.
     */
    suspend fun getAnime(id: Int): Anime = gson.deserialize(restClient.request("anime/$id"), Anime::class.java)

    /**
     * Function to get anime's characters and staff by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of characters and staff of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeCharactersStaff(id: Int): AnimeCharactersStaff =
        gson.deserialize(restClient.request("anime/$id/characters_staff"), AnimeCharactersStaff::class.java)

    /**
     * Function to get anime's episodes by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 50 episode entity.
     * @return List of characters and staff of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeEpisodes(id: Int, page: Int? = 1): AnimeEpisodes =
        gson.deserialize(restClient.request("anime/$id/episodes/$page"), AnimeEpisodes::class.java)

    /**
     * Function to get anime's news by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of articles related to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeNews(id: Int): AnimeNews =
        gson.deserialize(restClient.request("anime/$id/news"), AnimeNews::class.java)

    /**
     * Function to get anime's pictures by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of pictures to the anime with given MyAnimeList id.
     */
    suspend fun getAnimePictures(id: Int): AnimePictures =
        gson.deserialize(restClient.request("anime/$id/pictures"), AnimePictures::class.java)

    /**
     * Function to get anime's videos by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of videos to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeVideos(id: Int): AnimeVideos =
        gson.deserialize(restClient.request("anime/$id/videos"), AnimeVideos::class.java)

    /**
     * Function to get anime's stats by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return Statistics to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeStats(id: Int): AnimeStats =
        gson.deserialize(restClient.request("anime/$id/stats"), AnimeStats::class.java)

    /**
     * Function to get anime's forum by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of topics to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeForum(id: Int): AnimeForum =
        gson.deserialize(restClient.request("anime/$id/forum"), AnimeForum::class.java)

    /**
     * Function to get anime's reviews by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 20 items.
     * @return List of reviews of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeReviews(id: Int, page: Int? = 1): AnimeReviews =
        gson.deserialize(restClient.request("anime/$id/reviews/$page"), AnimeReviews::class.java)

    /**
     * Function to get anime's recommendations by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of recommendations to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeRecommendations(id: Int): AnimeRecommendations =
        gson.deserialize(restClient.request("anime/$id/recommendations"), AnimeRecommendations::class.java)

    /**
     * Function to get anime's user updates by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 75 items.
     * @return List of user updates of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeUserUpdates(id: Int, page: Int? = 1): AnimeUserUpdates =
        gson.deserialize(restClient.request("anime/$id/userupdates/$page"), AnimeUserUpdates::class.java)

    //endregion
}