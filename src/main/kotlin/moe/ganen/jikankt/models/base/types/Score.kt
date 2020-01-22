package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Score of the entity.
 * @see Score for the detail.
 */
data class Score(
    /**
     * Score entry for score 1.
     */
    @SerializedName("1")
    val score1: ScoreEntry? = null,

    /**
     * Score entry for score 2.
     */
    @SerializedName("2")
    val score2: ScoreEntry? = null,

    /**
     * Score entry for score 3.
     */
    @SerializedName("3")
    val score3: ScoreEntry? = null,

    /**
     * Score entry for score 4.
     */
    @SerializedName("4")
    val score4: ScoreEntry? = null,

    /**
     * Score entry for score 5.
     */
    @SerializedName("5")
    val score5: ScoreEntry? = null,

    /**
     * Score entry for score 6.
     */
    @SerializedName("6")
    val score6: ScoreEntry? = null,

    /**
     * Score entry for score 7.
     */
    @SerializedName("7")
    val score7: ScoreEntry? = null,

    /**
     * Score entry for score 8.
     */
    @SerializedName("8")
    val score8: ScoreEntry? = null,

    /**
     * Score entry for score 9.
     */
    @SerializedName("9")
    val score9: ScoreEntry? = null,

    /**
     * Score entry for score 10.
     */
    @SerializedName("10")
    val score10: ScoreEntry? = null
)