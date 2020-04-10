package moe.ganen.jikankt.models.top

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeTopEntity

data class TopAnime(
    /**
     * List of top anime on MyAnimeList.
     */
    @SerializedName("top")
    val top: List<AnimeTopEntity?>? = null
) : Entity()