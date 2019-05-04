package id.gsculerlor.jikankt.main.anime

import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.gson.responseObject
import com.github.kittinunf.fuel.httpGet
import id.gsculerlor.jikankt.model.anime.Anime
import id.gsculerlor.jikankt.model.anime.AnimePage
import id.gsculerlor.jikankt.model.anime.episode.Episode
import id.gsculerlor.jikankt.model.anime.episode.EpisodePage
import id.gsculerlor.jikankt.utils.JIKAN_URL

/**
 * @author Ganendra Afrasya
 * 4/5/2019
 */
class Anime {
    init {
        FuelManager.instance.basePath = JIKAN_URL
    }

    /**
     * Search anime by MyAnimeList ID
     *
     * @param id anime ID on MyAnimeList
     * @return Anime object
     */
    fun anime(id: Int): Anime? {
        return "anime/$id".httpGet().responseObject<Anime>().third.component1()
    }

    /**
     * Search anime by title and get the first result
     *
     * @param title anime title to be searched
     * @return Anime object
     */
    fun anime(title: String): Anime? {
        val searchResult =
            "search/anime?q=${title.replace(" ", "%20")}&page=1".httpGet().responseObject<AnimePage>()
                .third.component1()?.results

        return searchResult?.get(0)
    }

    /**
     * Get the episode list from the Anime
     *
     * @param id anime ID on MyAnimeList
     * @param page the index of paginated result of episodes
     * @return list of episodes from the Anime
     */
    fun episodes(id: Int, page: Int = 0): List<Episode?>? {
        return "/anime/$id/episodes?page=$page".httpGet().responseObject<EpisodePage>().third.component1()?.results
    }
}