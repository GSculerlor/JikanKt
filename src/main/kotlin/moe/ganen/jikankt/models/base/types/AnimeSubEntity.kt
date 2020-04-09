package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

/**
 * Anime sub entity data class.
 */
data class AnimeSubEntity(
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
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Anime airing date.
     */
    @SerializedName("airing_start")
    val airingStart: Date? = null,

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
     * Anime's genre(s).
     */
    @SerializedName("genres")
    val genres: List<MalSubEntity?>? = null,

    /**
     * Source of the anime.
     */
    @SerializedName("source")
    val source: String? = null,

    /**
     * List of producers of the anime.
     */
    @SerializedName("producers")
    val producers: List<MalSubEntity?>? = null,

    /**
     * Score at MyAnimeList. Formatted up to 2 decimal places.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * List of licensors of the anime.
     */
    @SerializedName("licensors")
    val licensors: List<String?>? = null,

    /**
     * Whether this anime is R18 or not.
     */
    @SerializedName("r18")
    val r18: Boolean? = null,

    /**
     * Whether this anime is kids or not.
     */
    @SerializedName("kids")
    val kids: Boolean? = null,

    /**
     * Whether this anime is continuing or not
     */
    @SerializedName("continuing")
    val continuing: Boolean? = null

) : Entity(), MalEntity