package moe.ganen.jikankt.models.user

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.History

data class UserHistory(
    /**
     * List of user's history updates.
     */
    @SerializedName("history")
    val histories: List<History?>? = null
) : Entity()