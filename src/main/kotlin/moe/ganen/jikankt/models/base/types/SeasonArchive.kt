package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

data class SeasonArchive(
    /**
     * Year of the season.
     */
    @SerializedName("year")
    val year: Int,

    /**
     * Seasons on that year.
     */
    @SerializedName("seasons")
    val seasons: List<String>
)