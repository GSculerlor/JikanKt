package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

data class Friend(
    /**
     * User's username.
     */
    @SerializedName("username")
    val username: String? = null,

    /**
     * URL of friend's MyAnimeList page.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Image URL.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Friend's last online date.
     */
    @SerializedName("last_online")
    val lastOnline: Date? = null,

    /**
     * User's date friend additions.
     */
    @SerializedName("friends_since")
    val friendSince: Date? = null
)