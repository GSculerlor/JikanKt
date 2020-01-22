package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

/**
 * Detail of the topic.
 */
data class Topic(
    /**
     * Topic's ID on MyAnimeList.
     */
    @SerializedName("topic_id")
    override val malId: Int,

    /**
     * Topic's URL on MyAnimeList
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Title of the topic.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Topic's date posted.
     */
    @SerializedName("date_posted")
    val datePosted: Date? = null,

    /**
     * Author of the topic.
     */
    @SerializedName("author_name")
    val authorName: String? = null,

    /**
     * Author's URL on MyAnimeList
     */
    @SerializedName("author_url")
    val authorUrl: String? = null,

    /**
     * Replies count on the topic.
     */
    @SerializedName("replies")
    val replies: Int? = null,

    /**
     * last post snippet of the topic.
     * @see PostSnippet for the detail.
     */
    @SerializedName("last_post")
    val lastPost: PostSnippet? = null
) : MalEntity