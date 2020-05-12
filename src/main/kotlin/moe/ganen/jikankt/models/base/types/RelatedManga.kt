package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * Lists of related items of the manga.
 * @see MalSubEntity for the detail.
 */
data class RelatedManga(
    /**
     * List of prequels of the manga.
     */
    @SerializedName("Prequel")
    val prequel: List<MalSubEntity?>? = null,

    /**
     * List of alternative versions of the manga.
     */
    @SerializedName("Alternative version")
    val alternativeVersion: List<MalSubEntity?>? = null,

    /**
     * List of spin-off of the manga.
     */
    @SerializedName("Spin-off")
    val spinOff: List<MalSubEntity?>? = null,

    /**
     * List of adaptations of the manga.
     */
    @SerializedName("Adaptation")
    val adaptation: List<MalSubEntity?>? = null,

    /**
     * List of summaries of the manga.
     */
    @SerializedName("Summary")
    val summary: List<MalSubEntity?>? = null,

    /**
     * List of sequels of the manga.
     */
    @SerializedName("Sequel")
    val sequel: List<MalSubEntity?>? = null,

    /**
     * List of side-stories of the manga.
     */
    @SerializedName("Side story")
    val sideStory: List<MalSubEntity?>? = null,

    /**
     * List of other entries of the manga.
     */
    @SerializedName("Other")
    val other: List<MalSubEntity?>? = null,

    /**
     * List of parent story of the manga.
     */
    @SerializedName("Parent story")
    val parentStory: List<MalSubEntity?>? = null,

    /**
     * List of alternative settings of the manga.
     */
    @SerializedName("Alternative setting")
    val alternativeSetting: List<MalSubEntity?>? = null,

    /**
     * List of related characters of the manga.
     */
    @SerializedName("Character")
    val character: List<MalSubEntity?>? = null,

    /**
     * List of full stories of the manga.
     */
    @SerializedName("Full story")
    val fullStory: List<MalSubEntity?>? = null
)