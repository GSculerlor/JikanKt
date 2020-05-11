package moe.ganen.jikankt.models.search

import moe.ganen.jikankt.models.search.enums.*
import java.text.SimpleDateFormat
import java.util.*

data class AnimeSearchQuery(
    val type: AnimeType = AnimeType.All,
    val status: AnimeStatus = AnimeStatus.All,
    val rated: AgeRating = AgeRating.All,
    val genre: List<AnimeGenre>? = null,
    val score: Int? = null,
    val startDate: Date? = null,
    val endDate: Date? = null,
    val excludedGenre: Boolean = false,
    val limit: Int? = null,
    val orderBy: AnimeOrderBy = AnimeOrderBy.None,
    val sort: Sort = Sort.Descending,
    val producerId: Int? = null
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        val queryDateFormat = SimpleDateFormat("yyyy-MM-dd")

        if (type != AnimeType.All)
            stringBuilder.append("&type=${type.name}")

        if (status != AnimeStatus.All)
            stringBuilder.append("&status=${status.name}")

        if (rated != AgeRating.All)
            stringBuilder.append("&rated=${rated.name}")

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

        if (orderBy != AnimeOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy.queryString.isNullOrEmpty()) orderBy.name.toLowerCase() else orderBy.queryString}")

        if (sort == Sort.Ascending)
            stringBuilder.append("&sort=asc")

        if (producerId != null)
            stringBuilder.append("&producer=${producerId}")

        return stringBuilder.toString()
    }
}