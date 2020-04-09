package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.UserMangaUpdate

/**
 * Manga's user updates data class.
 */
data class MangaUserUpdates(
    /**
     * List of user's update.
     */
    @SerializedName("users")
    val updates: List<UserMangaUpdate?>? = null
) : Entity()