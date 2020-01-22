package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Score entry data class.
 */
data class ScoreEntry(
    /**
     * Number of voted users.
     */
    @SerializedName("votes")
    val votes: Int? = null,

    /**
     * Percentage share of overall stat result.
     */
    @SerializedName("percentage")
    val percentage: Double? = null
)