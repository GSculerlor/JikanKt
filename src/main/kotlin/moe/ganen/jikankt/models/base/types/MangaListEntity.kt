package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

data class MangaListEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Title of the manga.
     */
    @SerializedName("title")
    val title: String? = null,

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
     * Type of the manga.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * User's amount of read chapters.
     */
    @SerializedName("read_chapters")
    val readChapters: Int? = null,

    /**
     * User's amount of read volumes.
     */
    @SerializedName("read_volumes")
    val readVolumes: Int? = null,

    /**
     * Manga's chapters total count.
     */
    @SerializedName("total_chapters")
    val chaptersTotal: Int? = null,

    /**
     * Manga's volumes total count.
     */
    @SerializedName("total_volumes")
    val volumesTotal: Int? = null,

    /**
     * User's score on this anime.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Whether user is currently rereading this manga.
     */
    @SerializedName("is_rereading")
    val isRereading: Boolean? = null,

    /**
     * Manga start date.
     */
    @SerializedName("start_date")
    val startDate: Date? = null,

    /**
     * Manga end date.
     */
    @SerializedName("end_date")
    val endDate: Date? = null,

    /**
     * User's start date reading the anime.
     */
    @SerializedName("read_start_date")
    val startReadDate: Date? = null,

    /**
     * User's finished date watching the anime.
     */
    @SerializedName("read_end_date")
    val endReadDate: Date? = null,

    /**
     * Total amount of days user has been reading manga.
     */
    @SerializedName("days")
    val days: Int? = null,

    /**
     * Priority of manga on user's list.
     */
    @SerializedName("priority")
    val priority: String? = null,

    /**
     * Current publishing status of manga.
     */
    @SerializedName("publishing_status")
    val airingStatus: String? = null,

    /**
     * Current user's reading status of manga.
     */
    @SerializedName("reading_status")
    val readingStatus: String? = null
) : MalEntity