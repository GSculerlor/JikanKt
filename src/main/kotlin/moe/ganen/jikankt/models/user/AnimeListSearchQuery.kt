package moe.ganen.jikankt.models.user

import moe.ganen.jikankt.models.search.enums.AnimeStatus
import moe.ganen.jikankt.models.search.enums.Sort
import moe.ganen.jikankt.models.season.SeasonType
import moe.ganen.jikankt.models.user.enums.AnimeOrderBy
import java.text.SimpleDateFormat
import java.util.*

data class AnimeListSearchQuery(
    val orderBy1: AnimeOrderBy = AnimeOrderBy.None,
    val orderBy2: AnimeOrderBy = AnimeOrderBy.None,
    val sort: Sort = Sort.Descending,
    val producerId: Long? = null,
    val year: Int? = null,
    val season: SeasonType = SeasonType.All,
    val status: AnimeStatus = AnimeStatus.All,
    val airedFrom: Date? = null,
    val airedTo: Date? = null
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        val queryDateFormat = SimpleDateFormat("yyyy-MM-dd")

        if (orderBy1 != AnimeOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy1.queryString.isNullOrEmpty()) orderBy1.name.toLowerCase() else orderBy1.queryString}")

        if (orderBy2 != AnimeOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy2.queryString.isNullOrEmpty()) orderBy2.name.toLowerCase() else orderBy2.queryString}")

        if (sort == Sort.Ascending)
            stringBuilder.append("&sort=asc")

        if (producerId != null)
            stringBuilder.append("&producer=${producerId}")

        if (season != SeasonType.All) {
            if (year != null)
                stringBuilder.append("&year=${year}&season=${season.name.toLowerCase()}")
            else
                throw Exception("Year need to be specified!")
        }

        if (status != AnimeStatus.All)
            stringBuilder.append("&airing_status=${status.name.toLowerCase()}")

        if (airedFrom != null)
            stringBuilder.append("&aired_from=${queryDateFormat.format(airedFrom)}")

        if (airedTo != null)
            stringBuilder.append("&aired_to=${queryDateFormat.format(airedTo)}")

        return stringBuilder.toString()
    }
}