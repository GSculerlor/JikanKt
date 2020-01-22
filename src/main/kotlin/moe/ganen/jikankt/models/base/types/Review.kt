package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

/**
 * Review detail of the anime.
 */
data class Review(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Review's URL on MyAnimeList.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Numbers of user that mark this review as helpful.
     */
    @SerializedName("helpful_count")
    val helpfulCount: Int? = null,

    /**
     * Posted date.
     */
    @SerializedName("date")
    val date: Date? = null,

    /**
     * Review's reviewer.
     * @see Reviewer for the detail.
     */
    @SerializedName("reviewer")
    val reviewer: Reviewer? = null,

    /**
     * Review's content.
     */
    @SerializedName("content")
    val content: String? = null
) : MalEntity