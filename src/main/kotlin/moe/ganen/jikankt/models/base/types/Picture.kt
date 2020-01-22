package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Contains picture's URL on MyAnimeList
 */
data class Picture(
    /**
     * Large image's URL
     */
    @SerializedName("large")
    val largeImageUrl: String? = null,

    /**
     * Small image's URL
     */
    @SerializedName("small")
    val smallImageUrl: String? = null
)