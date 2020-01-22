package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Sub item of MyAnimeList entity on API response.
 */
data class MalSubEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Type of the sub item.
     */
    @SerializedName("type")
    val type: String? = null,

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