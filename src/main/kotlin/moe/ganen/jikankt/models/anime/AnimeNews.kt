package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Article

/**
 * Anime's news data class.
 */
data class AnimeNews(
    /**
     * List of article related to the anime.
     * @see Article for the detail.
     */
    @SerializedName("articles")
    val articles: List<Article?>? = null
) : Entity()