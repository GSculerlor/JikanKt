package moe.ganen.jikankt.models.top

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.MangaTopEntity

data class TopManga(
    /**
     * List of top manga on MyAnimeList.
     */
    @SerializedName("top")
    val top: List<MangaTopEntity?>? = null
) : Entity()