package moe.ganen.jikankt.models.top

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.PeopleTopEntity

data class TopPeople(
    /**
     * List of top people on MyAnimeList.
     */
    @SerializedName("top")
    val top: List<PeopleTopEntity?>? = null
) : Entity()