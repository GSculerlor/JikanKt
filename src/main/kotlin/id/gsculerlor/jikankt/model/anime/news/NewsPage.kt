package id.gsculerlor.jikankt.model.anime.news

import com.google.gson.annotations.SerializedName

data class NewsPage(
    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("articles")
    val news: List<News?>? = null
)