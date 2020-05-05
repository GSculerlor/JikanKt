package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

data class PeopleSearchSubEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * People's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * People's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * People's name.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * People's alternate name (if any).
     */
    @SerializedName("alternative_names")
    val alternativeNames: List<String?>? = null
) : MalEntity