package id.gsculerlor.jikankt.model.anime.picture

import com.google.gson.annotations.SerializedName

data class PicturePage(
    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("pictures")
    val pictures: List<Picture?>? = null
)