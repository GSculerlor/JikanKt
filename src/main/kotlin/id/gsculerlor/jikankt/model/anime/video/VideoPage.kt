package id.gsculerlor.jikankt.model.anime.video

import com.google.gson.annotations.SerializedName

data class VideoPage(
    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("promo")
    val promoVideos: List<Promo?>? = null,

    @SerializedName("episodes")
    val episodeVideos: List<Episode?>? = null
)