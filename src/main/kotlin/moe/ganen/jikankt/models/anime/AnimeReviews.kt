package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Review

/**
 * Anime review's data class.
 */
data class AnimeReviews(
    /**
     * List of anime's reviews.
     * @see Review for the detail.
     */
    @SerializedName("reviews")
    val reviews: List<Review?>? = null
) : Entity()