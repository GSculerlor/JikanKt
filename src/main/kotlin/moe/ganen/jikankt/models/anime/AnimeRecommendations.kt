package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Recommendation

/**
 * Anime's recommendation data class.
 */
data class AnimeRecommendations(
    /**
     * List of recommendation of the anime.
     * @see Recommendation for the detail.
     */
    @SerializedName("recommendations")
    val recommendations: List<Recommendation?>? = null
) : Entity()