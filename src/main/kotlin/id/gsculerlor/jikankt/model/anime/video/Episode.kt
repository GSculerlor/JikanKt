package id.gsculerlor.jikankt.model.anime.video

import com.google.gson.annotations.SerializedName

data class Episode(

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("episode")
    val episode: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    @SerializedName("video_url")
    val videoUrl: String? = null
) : Video