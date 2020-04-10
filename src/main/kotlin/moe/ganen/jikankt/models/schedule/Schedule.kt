package moe.ganen.jikankt.models.schedule

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeSubEntity

data class Schedule(
    /**
     * All current season entries scheduled for Monday.
     */
    @SerializedName("monday")
    val monday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Tuesday.
     */
    @SerializedName("tuesday")
    val tuesday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Wednesday.
     */
    @SerializedName("wednesday")
    val wednesday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Thursday.
     */
    @SerializedName("thursday")
    val thursday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Friday.
     */
    @SerializedName("friday")
    val friday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Saturday.
     */
    @SerializedName("saturday")
    val saturday: List<AnimeSubEntity?>? = null,

    /**
     * All current season entries scheduled for Sunday.
     */
    @SerializedName("sunday")
    val sunday: List<AnimeSubEntity?>? = null

) : Entity()