package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import moe.ganen.jikankt.models.search.enums.MangaType
import java.util.*

data class MangaSearchSubEntity(
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
     * @see MangaType for the detail.
     */
    @SerializedName("type")
    val type: MangaType? = null,

    /**
     * Score at MyAnimeList. Formatted up to 2 decimal places.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Total chapter(s) of the manga.
     */
    @SerializedName("chapters")
    val chapters: Int? = null,

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
     * Whether the manga is currently publishing or not.
     */
    @SerializedName("publishing")
    val publishing: Boolean? = null,

    /**
     * Manga publishing date.
     */
    @SerializedName("start_date")
    val startDate: Date? = null,

    /**
     * Manga finished publishing date.
     */
    @SerializedName("end_date")
    val endDate: Date? = null
) : MalEntity