package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.MalEntity
import moe.ganen.jikankt.models.base.enum.AnimeType
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.RelatedAnime
import moe.ganen.jikankt.models.base.types.TimeInterval

/**
 * Anime data class.
 */
data class Anime(
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
     * Anime's official trailer URL.
     */
    @SerializedName("trailer_url")
    val trailerUrl: String? = null,

    /**
     * Title of the anime.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Title of the anime in English.
     */
    @SerializedName("title_english")
    val titleEnglish: String? = null,

    /**
     * Title of the anime in Japanese.
     */
    @SerializedName("title_japanese")
    val titleJapanese: String? = null,

    /**
     * List of anime's synonyms.
     * @return null if there's none.
     */
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String?>? = null,

    /**
     * Type of the anime.
     * @see AnimeType for the detail.
     */
    @SerializedName("type")
    val type: AnimeType? = null,

    /**
     * Source of the anime.
     */
    @SerializedName("source")
    val source: String? = null,

    /**
     * Total episode(s) of the anime.
     */
    @SerializedName("episodes")
    val episodes: Int? = null,

    /**
     * Status of the anime (e.g "Airing", "Not yet airing", etc).
     */
    @SerializedName("status")
    val status: String? = null,

    /**
     * Whether the anime is currently airing or not.
     */
    @SerializedName("airing")
    val airing: Boolean? = null,

    /**
     * Interval of airing time in ISO8601 format.
     * @see TimeInterval for the detail.
     * @return null if there's none
     */
    @SerializedName("aired")
    val aired: TimeInterval? = null,

    /**
     * Duration per episode.
     */
    @SerializedName("duration")
    val duration: String? = null,

    /**
     * Age rating of the anime.
     */
    @SerializedName("rating")
    val rating: String? = null,

    /**
     * Score at MyAnimeList. Formatted up to 2 decimal places.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Number of people/users that scored the anime.
     */
    @SerializedName("scored_by")
    val scoredBy: Int? = null,

    /**
     * Anime's score rank on MyAnimeList.
     */
    @SerializedName("rank")
    val rank: Int? = null,

    /**
     * Anime's popularity rank on MyAnimeList.
     */
    @SerializedName("popularity")
    val popularity: Int? = null,

    /**
     * Anime's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Anime's favorites count on MyAnimeList.
     */
    @SerializedName("favorites")
    val favorites: Int? = null,

    /**
     * Synopsis of the anime.
     */
    @SerializedName("synopsis")
    val synopsis: String? = null,

    /**
     * Background info of the anime.
     */
    @SerializedName("background")
    val background: String? = null,

    /**
     * Season where anime premiered.
     */
    @SerializedName("premiered")
    val premiered: String? = null,

    /**
     * Broadcast date of the anime (day and time).
     */
    @SerializedName("broadcast")
    val broadcast: String? = null,

    /**
     * Lists of related items of the anime.
     * @see RelatedAnime for the detail.
     */
    @SerializedName("related")
    val related: RelatedAnime? = null,

    @SerializedName("producers")
    val producers: List<MalSubEntity?>? = null,

    @SerializedName("licensors")
    val licensors: List<MalSubEntity?>? = null,

    @SerializedName("studios")
    val studios: List<MalSubEntity?>? = null,

    @SerializedName("genres")
    val genres: List<MalSubEntity?>? = null,

    @SerializedName("opening_themes")
    val openingThemes: List<String?>? = null,

    @SerializedName("ending_themes")
    val endingThemes: List<String?>? = null

) : Entity(), MalEntity