package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * User update detail.
 */
data class UserUpdate(
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
     * User's score on the anime.
     */
    @SerializedName("score")
    val score: Int? = null,

    /**
     * User's status on the anime (e.g "Watching", "Dropped", etc).
     */
    @SerializedName("status")
    val status: String? = null,

    /**
     * Total user's watched episode(s).
     */
    @SerializedName("episodes_seen")
    val episodesSeen: Int? = null,

    /**
     * Total episodes of the anime.
     */
    @SerializedName("episodes_total")
    val episodesTotal: Int? = null,

    /**
     * User update date.
     */
    @SerializedName("date")
    val date: Date? = null
)