package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import moe.ganen.jikankt.models.search.enums.AnimeType
import java.util.*

data class AnimeSearchSubEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

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
     * Title of the anime.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Synopsis of the anime.
     */
    @SerializedName("synopsis")
    val synopsis: String? = null,

    /**
     * Type of the anime.
     * @see AnimeType for the detail.
     */
    @SerializedName("type")
    val type: AnimeType? = null,

    /**
     * Score at MyAnimeList. Formatted up to 2 decimal places.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Total episode(s) of the anime.
     */
    @SerializedName("episodes")
    val episodes: Int? = null,

    /**
     * Anime's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Whether the anime is currently airing or not.
     */
    @SerializedName("airing")
    val airing: Boolean? = null,

    /**
     * Anime airing date.
     */
    @SerializedName("start_date")
    val startDate: Date? = null,

    /**
     * Anime finished airing date.
     */
    @SerializedName("end_date")
    val endDate: Date? = null,

    /**
     * Rating of the anime (PG, G, Rx, etc.).
     */
    @SerializedName("rated")
    val rated: String? = null
) : MalEntity