package moe.ganen.jikankt.models.club

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.ClubMember

data class ClubMembers(
    /**
     * List of members on this club
     */
    @SerializedName("members")
    val members: List<ClubMember?>? = null
) : Entity()