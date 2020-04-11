package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Manga sub entity data class.
 */
data class MangaSubEntity(
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
     * Manga's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Title of the manga.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Synopsis of the manga.
     */
    @SerializedName("synopsis")
    val synopsis: String? = null,

    /**
     * Type of the manga.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Total volume(s) of the manga.
     */
    @SerializedName("volumes")
    val volumes: Int? = null,

    /**
     * Manga's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Manga's genre(s).
     */
    @SerializedName("genres")
    val genres: List<MalSubEntity?>? = null,

    /**
     * List of authors of the manga.
     */
    @SerializedName("authors")
    val authors: List<MalSubEntity?>? = null,

    /**
     * List of serialization of the manga.
     */
    @SerializedName("serialization")
    val serializations: List<String?>? = null

) : MalEntity