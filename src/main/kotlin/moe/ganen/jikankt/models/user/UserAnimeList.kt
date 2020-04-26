package moe.ganen.jikankt.models.user

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeListEntity

data class UserAnimeList(
    /**
     * List of user's anime on their anime list.
     */
    @SerializedName("anime")
    val anime: List<AnimeListEntity?>? = null
) : Entity()