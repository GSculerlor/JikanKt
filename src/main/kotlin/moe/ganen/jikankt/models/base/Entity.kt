package moe.ganen.jikankt.models.base

import com.google.gson.annotations.SerializedName

abstract class Entity {
    /**
     * Hash of the request.
     */
    @SerializedName("request_hash")
    val requestHash: String? = null

    /**
     * Whether you're request cached.
     */
    @SerializedName("request_cached")
    val requestCached: Boolean? = null

    /**
     * Cache expiration in second.
     */
    @SerializedName("request_cached_expiry")
    val requestCachedExpiry: Int? = null
}