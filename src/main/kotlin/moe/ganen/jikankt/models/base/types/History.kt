package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

data class History(
    /**
     * Metadata about updated manga/anime.
     */
    @SerializedName("meta")
    val metadata: MalSubEntity? = null,

    /**
     * New item for watched episodes/read chapters.
     */
    @SerializedName("increment")
    val increment: Int? = null,

    /**
     * Updated date.
     */
    @SerializedName("date")
    val date: Date? = null
)