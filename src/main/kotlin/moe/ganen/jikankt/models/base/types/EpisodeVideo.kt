package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Episode's video of the anime.
 */
data class EpisodeVideo(
    /**
     * Title of the video.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Numbered title of the video.
     */
    @SerializedName("episode")
    val episode: String? = null,

    /**
     * Video's image URL on MyAnimeList.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Video's URL on MyAnimeList.
     */
    @SerializedName("url")
    val videoUrl: String? = null
)