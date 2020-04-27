package moe.ganen.jikankt.models.user

import moe.ganen.jikankt.models.search.enums.MangaOrderBy
import moe.ganen.jikankt.models.search.enums.MangaStatus
import moe.ganen.jikankt.models.search.enums.Sort
import java.text.SimpleDateFormat
import java.util.*

data class MangaListSearchQuery(
    val orderBy1: MangaOrderBy = MangaOrderBy.None,
    val orderBy2: MangaOrderBy = MangaOrderBy.None,
    val sort: Sort = Sort.Descending,
    val magazineId: Long? = null,
    val status: MangaStatus = MangaStatus.All,
    val publishedFrom: Date? = null,
    val publishedTo: Date? = null
) {
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        val queryDateFormat = SimpleDateFormat("yyyy-MM-dd")

        if (orderBy1 != MangaOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy1.queryString.isNullOrEmpty()) orderBy1.name.toLowerCase() else orderBy1.queryString}")

        if (orderBy2 != MangaOrderBy.None)
            stringBuilder.append("&order_by=${if (orderBy2.queryString.isNullOrEmpty()) orderBy2.name.toLowerCase() else orderBy2.queryString}")

        if (sort == Sort.Ascending)
            stringBuilder.append("&sort=asc")

        if (magazineId != null)
            stringBuilder.append("&producer=${magazineId}")

        if (status != MangaStatus.All)
            stringBuilder.append("&airing_status=${status.name.toLowerCase()}")

        if (publishedFrom != null)
            stringBuilder.append("&aired_from=${queryDateFormat.format(publishedFrom)}")

        if (publishedTo != null)
            stringBuilder.append("&aired_to=${queryDateFormat.format(publishedTo)}")

        return stringBuilder.toString()
    }
}