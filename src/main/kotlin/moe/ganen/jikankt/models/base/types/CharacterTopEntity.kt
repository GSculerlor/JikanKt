package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

data class CharacterTopEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Current rank of the character on list.
     */
    @SerializedName("rank")
    val rank: Int? = null,

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
     * Name of the character.
     */
    @SerializedName("title")
    val name: String? = null,

    /**
     * Name of the character.
     */
    @SerializedName("name_kanji")
    val nameKanji: String? = null,

    /**
     * Character's favorites count on MyAnimeList.
     */
    @SerializedName("favorites")
    val favorites: Int? = null,

    /**
     * Character's score on MyAnimeList.
     */
    @SerializedName("score")
    val score: Double? = null,

    /**
     * Character's animeography.
     */
    @SerializedName("animeography")
    val animeography: List<MalSubEntity?>? = null,

    /**
     * Character's mangaography.
     */
    @SerializedName("mangaography")
    val mangaography: List<MalSubEntity?>? = null
) : MalEntity