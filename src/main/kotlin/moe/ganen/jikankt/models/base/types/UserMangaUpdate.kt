package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * User update detail.
 */
data class UserMangaUpdate(
    /**
     * User's username.
     */
    @SerializedName("username")
    val username: String? = null,

    /**
     * User's URL on MyAnimeList.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * User's image URL on MyAnimeList.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * User's score on the manga.
     */
    @SerializedName("score")
    val score: Int? = null,

    /**
     * User's status on the manga (e.g "Reading", "Dropped", etc).
     */
    @SerializedName("status")
    val status: String? = null,

    /**
     * Total user's read volume(s).
     */
    @SerializedName("volumes_read")
    val volumesSeen: Int? = null,

    /**
     * Total volumes of the manga.
     */
    @SerializedName("volumes_total")
    val volumesTotal: Int? = null,

    /**
     * Total user's read chapter(s).
     */
    @SerializedName("chapters_read")
    val chaptersSeen: Int? = null,

    /**
     * Total chapters of the manga.
     */
    @SerializedName("chapters_total")
    val chaptersTotal: Int? = null,

    /**
     * User update date.
     */
    @SerializedName("date")
    val date: Date? = null
)