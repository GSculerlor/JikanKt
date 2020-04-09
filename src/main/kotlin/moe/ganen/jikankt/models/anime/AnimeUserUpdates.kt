package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.UserAnimeUpdate

/**
 * Anime's user updates data class.
 */
data class AnimeUserUpdates(
    /**
     * List of user's update.
     */
    @SerializedName("users")
    val updates: List<UserAnimeUpdate?>? = null
) : Entity()