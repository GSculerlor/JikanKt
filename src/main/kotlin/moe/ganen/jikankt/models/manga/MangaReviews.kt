package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Review

/**
 * Manga review's data class.
 */
data class MangaReviews(
    /**
     * List of manga's reviews.
     * @see Review for the detail.
     */
    @SerializedName("reviews")
    val reviews: List<Review?>? = null
) : Entity()