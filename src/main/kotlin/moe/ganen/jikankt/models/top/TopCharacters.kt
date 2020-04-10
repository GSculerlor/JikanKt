package moe.ganen.jikankt.models.top

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.CharacterTopEntity

data class TopCharacters(
    /**
     * List of top anime on MyAnimeList.
     */
    @SerializedName("top")
    val top: List<CharacterTopEntity?>? = null
) : Entity()