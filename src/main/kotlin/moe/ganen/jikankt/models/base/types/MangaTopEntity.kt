package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

data class MangaTopEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Current rank of the manga on list.
     */
    @SerializedName("rank")
    val rank: Int? = null,

    /**
     * Mang's MyAnimeList link.
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
     * Type of the manga.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Total volume(s) of the anime.
     */
    @SerializedName("volumes")
    val volumes: Int? = null,

    /**
     * Manga start date.
     */
    @SerializedName("start_date")
    val startDate: String? = null,

    /**
     * Manga end date.
     */
    @SerializedName("end_date")
    val endDate: String? = null,

    /**
     * Manga's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Manga's score on MyAnimeList.
     */
    @SerializedName("score")
    val score: Double? = null
) : MalEntity