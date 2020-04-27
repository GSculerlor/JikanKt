package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * User Manga Stats.
 */
data class UserMangaStats(
    /**
     * Total amount of days user has been reading manga.
     */
    @SerializedName("days_read")
    val daysRead: Double? = null,

    /**
     * User's mean score for manga.
     */
    @SerializedName("mean_score")
    val meanScore: Double? = null,

    /**
     * User's amount of anime that currently reading.
     */
    @SerializedName("reading")
    val reading: Int? = null,

    /**
     * User's amount of manga that completed.
     */
    @SerializedName("completed")
    val completed: Int? = null,

    /**
     * User's amount of manga that currently on hold.
     */
    @SerializedName("on_hold")
    val onHold: Int? = null,

    /**
     * User's amount of manga that dropped.
     */
    @SerializedName("dropped")
    val dropped: Int? = null,

    /**
     * User's amount of manga that currently added in plan-to-watch.
     */
    @SerializedName("plan_to_read")
    val planToRead: Int? = null,

    /**
     * Total number of user's manga entries.
     */
    @SerializedName("total_entries")
    val totalEntries: Int? = null,

    /**
     * User's amount of manga that reread.
     */
    @SerializedName("reread")
    val reread: Int? = null,

    /**
     * User's amount of read chapters.
     */
    @SerializedName("chapters_read")
    val chaptersRead: Int? = null,

    /**
     * User's amount of read volumes.
     */
    @SerializedName("volumes_read")
    val volumesRead: Int? = null
)