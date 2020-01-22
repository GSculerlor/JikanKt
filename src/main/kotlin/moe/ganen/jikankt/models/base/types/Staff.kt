package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Detail about entity's staff.
 */
data class Staff(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Staff's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Staff's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Staff's name.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * Staff's role on the related entity.
     */
    @SerializedName("positions")
    val positions: List<String>? = null

) : MalEntity