package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName
import java.util.*

/**
 * Interval of the airing time for anime or date of start and end for manga.
 */
data class TimeInterval(
    /**
     * Start date.
     * @return null if there's none.
     */
    @SerializedName("from")
    val from: Date? = null,

    /**
     * End date.
     * @return null if there's none.
     */
    @SerializedName("to")
    val to: Date? = null,

    /**
     * Stringify version of @see [TimeInterval].
     * Value is fetched from API response.
     */
    @SerializedName("string")
    val simplifiedString: String? = null
)