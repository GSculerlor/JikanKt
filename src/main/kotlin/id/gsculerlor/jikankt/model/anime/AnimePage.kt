package id.gsculerlor.jikankt.model.anime

import com.google.gson.annotations.SerializedName

data class AnimePage(

    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("results")
    val results: List<Anime?>? = null
)