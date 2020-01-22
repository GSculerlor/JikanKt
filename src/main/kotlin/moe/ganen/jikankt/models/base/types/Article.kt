package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Detail about article's entity.
 */
data class Article(
    /**
     * Article's URL on MyAnimeList
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Title of the article.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Article's published date.
     */
    @SerializedName("date")
    val date: Date? = null,

    /**
     * Article's author.
     */
    @SerializedName("author_name")
    val authorName: String? = null,

    /**
     * Author's MyAnimeList URL.
     */
    @SerializedName("author_url")
    val authorUrl: String? = null,

    /**
     * Article's forum URL on MyAnimeList.
     */
    @SerializedName("forum_url")
    val forumUrl: String? = null,

    /**
     * Article's image URL.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Comments count on the article.
     */
    @SerializedName("comments")
    val comments: Int? = null,

    /**
     * Intro of the article.
     */
    @SerializedName("intro")
    val intro: String? = null
)