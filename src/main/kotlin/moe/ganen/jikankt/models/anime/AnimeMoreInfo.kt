package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity

/**
 * Anime's more info data class.
 */
data class AnimeMoreInfo(
    /**
     * More info related to the anime, if any.
     */
    @SerializedName("moreinfo")
    val moreInfo: String? = null
) : Entity()