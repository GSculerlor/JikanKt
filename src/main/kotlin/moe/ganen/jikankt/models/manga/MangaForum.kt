package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Topic

data class MangaForum(
    /**
     * List of topic related to the manga.
     * @see Topic for the detail.
     */
    @SerializedName("topics")
    val topics: List<Topic?>? = null
) : Entity()