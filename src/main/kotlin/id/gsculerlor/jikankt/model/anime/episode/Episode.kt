package id.gsculerlor.jikankt.model.anime.episode

import com.google.gson.annotations.SerializedName

data class Episode(

    @SerializedName("episode_id")
    val episodeId: Int? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("title_japanese")
    val titleJapanese: String? = null,

    @SerializedName("title_romanji")
    val title_romanji: String? = null,

    @SerializedName("aired")
    val aired: String? = null,

    @SerializedName("filler")
    val filler: Boolean? = null,

    @SerializedName("recap")
    val recap: Boolean? = null,

    @SerializedName("video_url")
    val videoUrl: String? = null,

    @SerializedName("forum_url")
    val forumUrl: String? = null
)