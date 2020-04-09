package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Recommendation

/**
 * Manga's recommendation data class.
 */
data class MangaRecommendations(
    /**
     * List of recommendation of the manga.
     * @see Recommendation for the detail.
     */
    @SerializedName("recommendations")
    val recommendations: List<Recommendation?>? = null
) : Entity()