package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Promo video of the anime.
 */
data class PromoVideo(
    /**
     * Title of the video.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Video's image URL on MyAnimeList.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Video's URL on MyAnimeList.
     */
    @SerializedName("video_url")
    val videoUrl: String? = null
)