package moe.ganen.jikankt.models.season

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.SeasonArchive

data class SeasonArchives(
    /**
     * List of archived season
     */
    @SerializedName("archive")
    val archive: List<SeasonArchive?>? = null
) : Entity()