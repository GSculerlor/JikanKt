package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

data class PublishedManga(
    /**
     * Person's position.
     */
    @SerializedName("position")
    val position: String? = null,

    /**
     * List of manga associated with person's position.
     */
    @SerializedName("manga")
    val manga: MalSubEntity? = null
)