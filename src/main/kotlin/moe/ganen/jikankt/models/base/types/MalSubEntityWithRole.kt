package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Sub item of MyAnimeList entity on API response.
 */
data class MalSubEntityWithRole(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Name of the sub item.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * URL of the sub item's MyAnimeList page.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Image URL.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Entity's role.
     */
    @SerializedName("role")
    val role: String? = null

) : MalEntity