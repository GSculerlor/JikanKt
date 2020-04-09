package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity

/**
 * Manga's more info data class.
 */
data class MangaMoreInfo(
    /**
     * More info related to the manga, if any.
     */
    @SerializedName("moreinfo")
    val moreInfo: String? = null
) : Entity()