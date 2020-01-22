package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Lists of related items of the anime.
 * @see MalSubEntity for the detail.
 */
data class RelatedAnime(
    /**
     * List of prequels of the anime.
     */
    @SerializedName("Prequel")
    val prequel: List<MalSubEntity?>? = null,

    /**
     * List of alternative versions of the anime.
     */
    @SerializedName("Alternative version")
    val alternativeVersion: List<MalSubEntity?>? = null,

    /**
     * List of spin-off of the anime.
     */
    @SerializedName("Spin-off")
    val spinOff: List<MalSubEntity?>? = null,

    /**
     * List of adaptations of the anime.
     */
    @SerializedName("Adaptation")
    val adaptation: List<MalSubEntity?>? = null,

    /**
     * List of summaries of the anime.
     */
    @SerializedName("Summary")
    val summary: List<MalSubEntity?>? = null,

    /**
     * List of sequels of the anime.
     */
    @SerializedName("Sequel")
    val sequel: List<MalSubEntity?>? = null,

    /**
     * List of side-stories of the anime.
     */
    @SerializedName("Side story")
    val sideStory: List<MalSubEntity?>? = null,

    /**
     * List of other entries of the anime.
     */
    @SerializedName("Other")
    val other: List<MalSubEntity?>? = null,

    /**
     * List of parent story of the anime.
     */
    @SerializedName("Parent story")
    val parentStory: List<MalSubEntity?>? = null,

    /**
     * List of alternative settings of the anime.
     */
    @SerializedName("Alternative setting")
    val alternativeSetting: List<MalSubEntity?>? = null,

    /**
     * List of related characters of the anime.
     */
    @SerializedName("Character")
    val character: List<MalSubEntity?>? = null,

    /**
     * List of full stories of the anime.
     */
    @SerializedName("Full story")
    val fullStory: List<MalSubEntity?>? = null
)