package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.MalEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.RelatedManga
import moe.ganen.jikankt.models.base.types.TimeInterval

/**
 * Manga data class
 */
data class Manga(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Manga's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Title of the manga.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Title of the manga in English.
     */
    @SerializedName("title_english")
    val titleEnglish: String? = null,

    /**
     * List of manga's synonyms.
     * @return null if there's none.
     */
    @SerializedName("title_synonyms")
    val titleSynonyms: List<String>? = null,

    /**
     * Title of the manga in Japanese.
     */
    @SerializedName("title_japanese")
    val titleJapanese: String? = null,

    /**
     * Status of the anime (e.g "Publishing", etc).
     */
    @SerializedName("status")
    val status: String? = null,

    /**
     * Manga's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Type of the manga.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Total volume(s) of the anime.
     */
    @SerializedName("volumes")
    val volumes: String? = null,

    /**
     * Total chapter(s) of the anime.
     */
    @SerializedName("chapters")
    val chapters: String? = null,

    /**
     * Whether the anime is currently publishing or not.
     */
    @SerializedName("publishing")
    val publishing: Boolean? = null,

    /**
     * Interval of publishing time in ISO8601 format.
     * @see TimeInterval for the detail.
     * @return null if there's none
     */
    @SerializedName("published")
    val published: TimeInterval? = null,

    /**
     * Manga's score rank on MyAnimeList.
     */
    @SerializedName("rank")
    val rank: Int? = null,

    /**
     * Score at MyAnimeList. Formatted up to 2 decimal places.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Number of people/users that scored the manga.
     */
    @SerializedName("scored_by")
    val scoredBy: Int? = null,

    /**
     * Manga's popularity rank on MyAnimeList.
     */
    @SerializedName("popularity")
    val popularity: Int? = null,

    /**
     * Manga's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Manga's favorites count on MyAnimeList.
     */
    @SerializedName("favorites")
    val favorites: Int? = null,

    /**
     * Synopsis of the manga.
     */
    @SerializedName("synopsis")
    val synopsis: String? = null,

    /**
     * Background info of the manga.
     */
    @SerializedName("background")
    val background: String? = null,

    /**
     * Lists of related items of the anime.
     * @see RelatedManga for the detail.
     */
    @SerializedName("related")
    val related: RelatedManga? = null,

    /**
     * List of genre of this manga.
     */
    @SerializedName("genres")
    val genres: List<MalSubEntity?>? = null,

    /**
     * List of authors of this manga.
     */
    @SerializedName("authors")
    val authors: List<MalSubEntity?>? = null,

    /**
     * List of serializations of this manga.
     */
    @SerializedName("serializations")
    val serializations: List<MalSubEntity?>? = null
) : Entity(), MalEntity