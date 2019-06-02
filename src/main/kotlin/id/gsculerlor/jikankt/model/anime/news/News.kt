package id.gsculerlor.jikankt.model.anime.news

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("url")
    val url: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("date")
    val date: String? = null,

    @SerializedName("author_name")
    val authorName: String? = null,

    @SerializedName("author_url")
    val authorUrl: String? = null,

    @SerializedName("forum_url")
    val forumUrl: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    @SerializedName("comments")
    val comments: Int? = null,

    @SerializedName("intro")
    val intro: String? = null
)