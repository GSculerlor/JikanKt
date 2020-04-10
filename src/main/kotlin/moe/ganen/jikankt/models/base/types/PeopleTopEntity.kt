package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity
import java.util.*

data class PeopleTopEntity(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Current rank of the person on list.
     */
    @SerializedName("rank")
    val rank: Int? = null,

    /**
     * Person's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Person's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Name of the person.
     */
    @SerializedName("title")
    val name: String? = null,

    /**
     * Name of the person.
     */
    @SerializedName("name_kanji")
    val nameKanji: String? = null,

    /**
     * Person's favorites count on MyAnimeList.
     */
    @SerializedName("favorites")
    val favorites: Int? = null,

    /**
     * Person's birthday
     */
    @SerializedName("birthday")
    val birthday: Date? = null
) : MalEntity