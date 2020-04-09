package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Score

data class MangaStats(
    /**
     * Number of user who mark this manga as "Watching"
     */
    @SerializedName("reading")
    val reading: Int? = null,

    /**
     * Number of user who mark this manga as "Completed"
     */
    @SerializedName("completed")
    val completed: Int? = null,

    /**
     * Number of user who mark this manga as "On hold"
     */
    @SerializedName("on_hold")
    val onHold: Int? = null,

    /**
     * Number of user who mark this manga as "Dropped"
     */
    @SerializedName("dropped")
    val dropped: Int? = null,

    /**
     * Number of user who mark this manga as "Plan to read"
     */
    @SerializedName("plan_to_read")
    val planToRead: Int? = null,

    /**
     * Total of numbers of users.
     */
    @SerializedName("total")
    val total: Int? = null,

    /**
     * List of score statistics.
     */
    @SerializedName("scores")
    val scorePage: Score? = null
) : Entity()