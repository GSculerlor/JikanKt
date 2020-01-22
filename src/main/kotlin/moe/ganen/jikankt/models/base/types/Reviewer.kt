package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Reviewer detail.
 */
data class Reviewer(
    /**
     * Reviewer's URL on MyAnimeList.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Reviewer's image URL on MyAnimeList.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Reviewer's username.
     */
    @SerializedName("username")
    val username: String? = null,

    /**
     * Total reviewer's watched episode(s).
     */
    @SerializedName("episodes_seen")
    val episodesSeen: Int? = null,

    /**
     * Reviewer's score.
     * @see ReviewerScore for the detail.
     */
    @SerializedName("scores")
    val scores: ReviewerScore? = null
)