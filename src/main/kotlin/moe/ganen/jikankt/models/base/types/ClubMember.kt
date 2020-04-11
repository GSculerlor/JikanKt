package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

data class ClubMember(
    /**
     * User's username.
     */
    @SerializedName("username")
    val username: String? = null,

    /**
     * User's URL on MyAnimeList.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * User's image URL on MyAnimeList.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null
)