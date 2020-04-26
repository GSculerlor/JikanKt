package moe.ganen.jikankt.models.user

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Friend

data class UserFriends(
    /**
     * List of user's friends.
     */
    @SerializedName("friends")
    val friends: List<Friend?>? = null
) : Entity()