package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Topic

/**
 * Anime's list of forum data class.
 */
data class AnimeForum(
    /**
     * List of topic related to the anime.
     * @see Topic for the detail.
     */
    @SerializedName("topics")
    val topics: List<Topic?>? = null
) : Entity()