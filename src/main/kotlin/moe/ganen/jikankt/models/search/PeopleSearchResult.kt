package moe.ganen.jikankt.models.search

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.PeopleSearchSubEntity

/**
 * Result of search query.
 */
data class PeopleSearchResult(
    /**
     * List of people result of search query.
     */
    @SerializedName("results")
    val results: List<PeopleSearchSubEntity?>? = null,

    /**
     * Index of last page.
     */
    @SerializedName("last_page")
    val lastPage: Int? = null
) : Entity()