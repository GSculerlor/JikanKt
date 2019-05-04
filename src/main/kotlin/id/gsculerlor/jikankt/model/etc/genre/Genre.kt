package id.gsculerlor.jikankt.model.etc.genre

import com.google.gson.annotations.SerializedName

data class Genre(

    @SerializedName("mal_id")
    val malId: Int? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
)