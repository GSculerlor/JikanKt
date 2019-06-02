package id.gsculerlor.jikankt

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.coroutines.awaitObjectResult
import id.gsculerlor.jikankt.model.anime.Anime
import id.gsculerlor.jikankt.model.anime.episode.Episode
import id.gsculerlor.jikankt.model.anime.episode.EpisodePage
import id.gsculerlor.jikankt.model.anime.news.News
import id.gsculerlor.jikankt.model.anime.news.NewsPage
import id.gsculerlor.jikankt.model.anime.picture.Picture
import id.gsculerlor.jikankt.model.anime.picture.PicturePage
import id.gsculerlor.jikankt.model.anime.video.Video
import id.gsculerlor.jikankt.model.anime.video.VideoPage
import id.gsculerlor.jikankt.utils.JIKAN_URL
import id.gsculerlor.jikankt.utils.deserializer
import id.gsculerlor.jikankt.utils.enums.VideoEnum
import id.gsculerlor.jikankt.utils.enums.VideoEnum.EPISODES
import id.gsculerlor.jikankt.utils.enums.VideoEnum.PROMO

class JikanKtClient {
    init {
        FuelManager.instance.basePath = JIKAN_URL
    }

    /**
     * Get the anime detail by MyAnimeList ID
     *
     * @param id anime ID on MyAnimeList
     * @return Anime object
     */
    suspend fun getAnimeDetail(id: Int): Anime? {
        val (request, response) = Fuel.get("anime/$id")
            .awaitObjectResult(deserializer(Anime::class.java))

        return request as Anime
    }

    /**
     * Get the list of episodes of the anime
     *
     * @param id anime ID on MyAnimeList
     * @param page the index of paginated result of episodes
     * @return list of episodes of the anime
     */
    suspend fun getAnimeEpisodes(id: Int, page: Int = 0): List<Episode?>? {
        val (request, response) = Fuel.get("anime/$id/episodes?page=$page")
            .awaitObjectResult(deserializer(EpisodePage::class.java))

        return (request as EpisodePage).episodes
    }

    /**
     * Get the news related to the anime
     *
     * @param id anime ID on MyAnimeList
     * @return list of news of the anime on MyAnimeList
     */
    suspend fun getAnimeNews(id: Int): List<News?>? {
        val (request, response) = Fuel.get("anime/$id/news")
            .awaitObjectResult(deserializer(NewsPage::class.java))

        return (request as NewsPage).news
    }

    /**
     * Get the pictures related to the anime
     *
     * @param id anime ID on MyAnimeList
     * @return list of pictures of the anime on MyAnimeList
     */
    suspend fun getAnimePictures(id: Int): List<Picture?>? {
        val (request, response) = Fuel.get("anime/$id/news")
            .awaitObjectResult(deserializer(PicturePage::class.java))

        return (request as PicturePage).pictures
    }

    /**
     * Get the videos related to the anime (promo videos and episode videos if any)
     *
     * @param id anime ID on MyAnimeList
     * @param videoEnum requested videoEnum type, default is episodes
     * @see VideoEnum for the videoEnum type
     * @return list of videoEnum of the anime on MyAnimeList
     */
    suspend fun getAnimeVideos(
        id: Int,
        videoEnum: VideoEnum = EPISODES
    ): List<Video?>? {
        val (request, response) = Fuel.get("anime/$id/videos")
            .awaitObjectResult(deserializer(VideoPage::class.java))

        return when (videoEnum) {
            PROMO -> (request as VideoPage).promoVideos
            EPISODES -> (request as VideoPage).episodeVideos
        }
    }
}