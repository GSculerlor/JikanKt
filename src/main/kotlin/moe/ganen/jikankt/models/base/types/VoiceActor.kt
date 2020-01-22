package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.MalEntity

/**
 * Details about character's voice actors
 */
data class VoiceActor(
    /**
     * ID associated with MyAnimeList.
     */
    @SerializedName("mal_id")
    override val malId: Int,

    /**
     * Voice actor's name.
     */
    @SerializedName("name")
    val name: String? = null,

    /**
     * Voice actor's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * Voice actor's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * Voice actor's main language.
     */
    @SerializedName("language")
    val language: String? = null
) : MalEntity