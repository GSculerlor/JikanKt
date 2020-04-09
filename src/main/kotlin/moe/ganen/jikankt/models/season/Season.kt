package moe.ganen.jikankt.models.season

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeSubEntity

data class Season(
    /**
     * Name of the season.
     */
    @SerializedName("season_name")
    val seasonName: String,

    /**
     * Year of the season.
     */
    @SerializedName("season_year")
    val seasonYear: Int,

    /**
     * List of anime in this season.
     */
    @SerializedName("anime")
    val anime: List<AnimeSubEntity?>? = null
) : Entity()