package id.gsculerlor.jikankt.model.anime.picture

import com.google.gson.annotations.SerializedName

data class Picture(
    @SerializedName("large")
    val large: String? = null,

    @SerializedName("small")
    val small: String? = null
)