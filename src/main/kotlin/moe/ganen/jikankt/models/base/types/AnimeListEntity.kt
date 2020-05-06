package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

data class AnimeListEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Title of the anime.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Anime's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Anime's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Anime video's MyAnimeList URL
     */
    @SerializedName("video_url")
    val videoUrl: String? = null,

    /**
     * Type of the anime.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * User's amount of watched episodes.
     */
    @SerializedName("watched_episodes")
    val episodesWatched: Int? = null,

    /**
     * Anime's episodes total count.
     */
    @SerializedName("total_episodes")
    val episodesTotal: Int? = null,

    /**
     * User's score on this anime.
     */
    @SerializedName("score")
    val score: Double? = null,
    /**
     * Whether anime have episode video.
     */
    @SerializedName("has_episode_video")
    val hasEpisodeVideo: Boolean? = null,

    /**
     * Whether anime have promo video.
     */
    @SerializedName("has_promo_video")
    val hasPromoVideo: Boolean? = null,

    /**
     * Whether anime have video.
     */
    @SerializedName("has_video")
    val hasVideo: Boolean? = null,

    /**
     * Whether user is currently rewatching this anime.
     */
    @SerializedName("is_rewatching")
    val isRewatching: Boolean? = null,

    /**
     * Age rating of the anime.
     */
    @SerializedName("rating")
    val rating: String? = null,

    /**
     * Anime start date.
     */
    @SerializedName("start_date")
    val startDate: Date? = null,

    /**
     * Anime end date.
     */
    @SerializedName("end_date")
    val endDate: Date? = null,

    /**
     * User's start date watching the anime.
     */
    @SerializedName("watch_start_date")
    val startWatchDate: Date? = null,

    /**
     * User's finished date watching the anime.
     */
    @SerializedName("watch_end_date")
    val endWatchDate: Date? = null,

    /**
     * Total amount of days user has been watching anime.
     */
    @SerializedName("days")
    val days: Int? = null,

    /**
     * Priority of anime on user's list.
     */
    @SerializedName("priority")
    val priority: String? = null,

    /**
     * Current airing status of anime.
     */
    @SerializedName("airing_status")
    val airingStatus: Int? = null,

    /**
     * Current user's watching status of anime.
     */
    @SerializedName("watching_status")
    val watchingStatus: Int? = null
) : MalEntity