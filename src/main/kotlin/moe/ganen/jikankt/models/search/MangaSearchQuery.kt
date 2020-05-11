package moe.ganen.jikankt.models.search

import moe.ganen.jikankt.models.search.enums.*
import java.text.SimpleDateFormat
import java.util.*

data class MangaSearchQuery(
    val type: MangaType = MangaType.All,
    val status: MangaStatus = MangaStatus.All,
    val genre: List<MangaGenre>? = null,
    val score: Int? = null,
    val startDate: Date? = null,
    val endDate: Date? = null,
    val excludedGenre: Boolean = false,
    val limit: Int? = null,
    val orderBy: MangaOrderBy = MangaOrderBy.None,
    val sort: Sort = Sort.Descending,
    val magazineId: Int? = null
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        val queryDateFormat = SimpleDateFormat("yyyy-MM-dd")

        if (type != MangaType.All)
            stringBuilder.append("&type=${if (type.queryString.isNullOrEmpty()) type.name.toLowerCase() else type.queryString}")

        if (status != MangaStatus.All)
            stringBuilder.append("&status=${status.name.toLowerCase()}")

        if (!genre.isNullOrEmpty())
            stringBuilder.append("&genre=${genre.joinToString(separator = ",") { "${it.ordinal}" }}")

        if (score != null && score in 1..10)
            stringBuilder.append("&score=$score")

        if (startDate != null)
            stringBuilder.append("&start_date=${queryDateFormat.format(startDate)}")

        if (endDate != null)
            stringBuilder.append("&end_date=${queryDateFormat.format(endDate)}")

        if (excludedGenre)
            stringBuilder.append("&genre_exclude=0")

        if (limit != null)
            stringBuilder.append("&limit=${limit}")

        if (orderBy != MangaOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy.queryString.isNullOrEmpty()) orderBy.name.toLowerCase() else orderBy.queryString}")

        if (sort == Sort.Ascending)
            stringBuilder.append("&sort=asc")

        if (magazineId != null)
            stringBuilder.append("&producer=${magazineId}")

        return stringBuilder.toString()
    }
}