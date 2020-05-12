package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Article

/**
 * Manga's news data class.
 */
data class MangaNews(
    /**
     * List of article related to the manga.
     * @see Article for the detail.
     */
    @SerializedName("articles")
    val articles: List<Article?>? = null
) : Entity()