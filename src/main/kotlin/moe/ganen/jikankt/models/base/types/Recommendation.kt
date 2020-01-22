package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 *
 */
data class Recommendation(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Recommendation's anime URL on MyAnimeList.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Recommendation's anime cover/image URL.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Recommendation's URL on MyAnimeList.
     */
    @SerializedName("recommendation_url")
    val recommendationUrl: String? = null,

    /**
     * Title of the anime.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Number of recommendation(s).
     */
    @SerializedName("recommendation_count")
    val recommendationCount: Int? = null
) : MalEntity