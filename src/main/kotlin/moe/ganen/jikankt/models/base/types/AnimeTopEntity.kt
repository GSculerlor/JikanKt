package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

data class AnimeTopEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Current rank of the anime on list.
     */
    @SerializedName("rank")
    val rank: Int? = null,

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
     * Type of the anime.
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Total episode(s) of the anime.
     */
    @SerializedName("episodes")
    val episodes: Int? = null,

    /**
     * Anime start date.
     */
    @SerializedName("start_date")
    val startDate: String? = null,

    /**
     * Anime end date.
     */
    @SerializedName("end_date")
    val endDate: String? = null,

    /**
     * Anime's members count on MyAnimeList.
     */
    @SerializedName("members")
    val members: Int? = null,

    /**
     * Anime's score on MyAnimeList.
     */
    @SerializedName("score")
    val score: Double? = null
) : MalEntity