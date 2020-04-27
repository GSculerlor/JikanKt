package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Sub item of favorites section on user detail.
 */
data class UserFavSubEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Sub item's cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Name of the sub item.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * URL of the sub item's MyAnimeList page.
     */
    @SerializedName("url")
    val url: String? = null
) : MalEntity