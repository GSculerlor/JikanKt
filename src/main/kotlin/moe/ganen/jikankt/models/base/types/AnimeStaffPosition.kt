package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

data class AnimeStaffPosition(
    /**
     * Person's position.
     */
    @SerializedName("position")
    val position: String? = null,

    /**
     * List of anime associated with person's position.
     */
    @SerializedName("anime")
    val anime: MalSubEntity? = null
)