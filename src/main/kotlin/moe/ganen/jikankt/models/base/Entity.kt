package moe.ganen.jikankt.models.base

import com.google.gson.annotations.SerializedName
import java.io.Serializable

abstract class Entity : Serializable {
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
    @SerializedName("request_cache_expiry")
    val requestCachedExpiry: Int? = null
}