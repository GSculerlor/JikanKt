package moe.ganen.jikankt.models.club

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.MalEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import java.util.*

data class Club(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Club's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Club's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Club's title/name.
     */
    @SerializedName("title")
    val title: String? = null,

    /**
     * Member count.
     */
    @SerializedName("members_count")
    val membersCount: Int? = null,

    /**
     * Picture count.
     */
    @SerializedName("pictures_count")
    val picturesCount: Int? = null,

    /**
     * Club's category.
     */
    @SerializedName("category")
    val category: String? = null,

    /**
     * Created date.
     */
    @SerializedName("created")
    val create: Date? = null,

    /**
     * Club's type (public, private, etc).
     */
    @SerializedName("type")
    val type: String? = null,

    /**
     * Club staff.
     */
    @SerializedName("staff")
    val staff: List<MalSubEntity?>? = null,

    /**
     * List of anime related to the club.
     */
    @SerializedName("anime_relations")
    val animeRelations: List<MalSubEntity?>? = null,

    /**
     * List of manga related to the club.
     */
    @SerializedName("manga_relations")
    val mangaRelations: List<MalSubEntity?>? = null,

    /**
     * List of character related to the club.
     */
    @SerializedName("character_relations")
    val characterRelations: List<MalSubEntity?>? = null

) : Entity(), MalEntity