package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Detail about anime's episode.
 */
data class Episode(
    /**
     * ID associated with the anime.
     */
    @SerializedName("episode_id")
    val malId: Int? = null,

    /**
     * Title of the episode.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Title of the episode in romanji.
     */
    @SerializedName("title_romanji")
    val titleEnglish: String? = null,

    /**
     * Title of the episode in Japanese.
     */
    @SerializedName("title_japanese")
    val titleJapanese: String? = null,

    /**
     * Aired date of the episode.
     */
    @SerializedName("aired")
    val aired: Date? = null,

    /**
     * Whether this episode is filler ep or not.
     */
    @SerializedName("filler")
    val filler: Boolean? = null,

    /**
     * Whether this episode is recap ep or not.
     */
    @SerializedName("recap")
    val recap: Boolean? = null,

    /**
     * Episode video's MyAnimeList URL
     */
    @SerializedName("video_url")
    val videoUrl: String? = null,

    /**
     * Episode forum's MyAnimeList URL
     */
    @SerializedName("forum_url")
    val forumUrl: String? = null
)