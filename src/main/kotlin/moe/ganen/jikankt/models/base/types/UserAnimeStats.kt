package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * User's anime statistic.
 */
data class UserAnimeStats(
    /**
     * Total amount of days user has been watching anime.
     */
    @SerializedName("days_watched")
    val daysWatched: Double? = null,

    /**
     * User's mean score for anime.
     */
    @SerializedName("mean_score")
    val meanScore: Double? = null,

    /**
     * User's amount of anime that currently watching.
     */
    @SerializedName("watching")
    val watching: Int? = null,

    /**
     * User's amount of anime that completed.
     */
    @SerializedName("completed")
    val completed: Int? = null,

    /**
     * User's amount of anime that currently on hold.
     */
    @SerializedName("on_hold")
    val onHold: Int? = null,

    /**
     * User's amount of anime that dropped.
     */
    @SerializedName("dropped")
    val dropped: Int? = null,

    /**
     * User's amount of anime that currently added in plan-to-watch.
     */
    @SerializedName("plan_to_watch")
    val planToWatch: Int? = null,

    /**
     * Total number of user's anime entries.
     */
    @SerializedName("total_entries")
    val totalEntries: Int? = null,

    /**
     * User's amount of anime that rewatched.
     */
    @SerializedName("rewatched")
    val rewatched: Int? = null,

    /**
     * User's amount of watched episodes.
     */
    @SerializedName("episodes_watched")
    val episodesWatched: Int? = null
)