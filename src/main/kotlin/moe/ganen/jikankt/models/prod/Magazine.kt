package moe.ganen.jikankt.models.prod

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.MangaSubEntity

data class Magazine(
    /**
     * Magazine's metadata
     */
    @SerializedName("meta")
    val metadata: MalSubEntity? = null,

    /**
     * List of manga published by this magazine.
     */
    @SerializedName("manga")
    val manga: List<MangaSubEntity?>? = null
) : Entity()