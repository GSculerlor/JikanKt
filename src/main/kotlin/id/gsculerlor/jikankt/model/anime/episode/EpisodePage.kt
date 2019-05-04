package id.gsculerlor.jikankt.model.anime.episode

import com.google.gson.annotations.SerializedName

data class EpisodePage(
    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("episodes_last_page")
    val episodeLastPage: Int? = null,

    @SerializedName("episodes")
    val results: List<Episode?>? = null
)