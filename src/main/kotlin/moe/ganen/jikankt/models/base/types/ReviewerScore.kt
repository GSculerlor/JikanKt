package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * List of reviewers score.
 */
data class ReviewerScore(
    /**
     * Overall reviewer's score.
     */
    @SerializedName("overall")
    val overall: Int? = null,

    /**
     * Story reviewer's score.
     */
    @SerializedName("story")
    val story: Int? = null,

    /**
     * Animation reviewer's score.
     */
    @SerializedName("animation")
    val animation: Int? = null,

    /**
     * Sound reviewer's score.
     */
    @SerializedName("sound")
    val sound: Int? = null,

    /**
     * Character reviewer's score.
     */
    @SerializedName("character")
    val character: Int? = null,

    /**
     * Enjoyment reviewer's score.
     */
    @SerializedName("enjoyment")
    val enjoyment: Int? = null
)