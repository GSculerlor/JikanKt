package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Detail about entity's characters.
 */
data class Character(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Character's MyAnimeList URL.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Character's MyAnimeList cover/image URL.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Character's name.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * Character's role on the related entity.
     */
    @SerializedName("role")
    val role: String? = null,

    /**
     * Character's list of voice actor on the related entity.
     * @see VoiceActor for the detail.
     */
    @SerializedName("voice_actors")
    val voiceActors: List<VoiceActor?>? = null

) : MalEntity