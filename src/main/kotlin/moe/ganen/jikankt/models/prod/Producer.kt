package moe.ganen.jikankt.models.prod

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity

data class Producer(
    /**
     * Producer's metadata
     */
    @SerializedName("meta")
    val metadata: MalSubEntity? = null,

    /**
     * List of anime published by this producer.
     */
    @SerializedName("anime")
    val anime: List<AnimeSubEntity?>? = null
) : Entity()