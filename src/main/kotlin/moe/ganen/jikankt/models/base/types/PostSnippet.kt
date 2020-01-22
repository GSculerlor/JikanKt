package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Snippet of forum post.
 */
data class PostSnippet(
    /**
     * Post's URL on MyAnimeList
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Post's author name.
     */
    @SerializedName("author_name")
    val authorName: String? = null,

    /**
     * Post's author MyAnimeList URL.
     */
    @SerializedName("author_url")
    val authorUrl: String? = null,

    /**
     * Date posted.
     */
    @SerializedName("date_posted")
    val datePosted: Date? = null
)