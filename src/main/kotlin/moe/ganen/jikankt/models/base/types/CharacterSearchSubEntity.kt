package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

data class CharacterSearchSubEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Character's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Character's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Character's name.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * Character's alternate name (if any).
     */
    @SerializedName("alternative_names")
    val alternativeNames: List<String?>? = null,

    /**
     * Character's animeography.
     */
    @SerializedName("anime")
    val animeography: List<MalSubEntity?>? = null,

    /**
     * Character's mangaography.
     */
    @SerializedName("manga")
    val mangaography: List<MalSubEntity?>? = null
) : MalEntity