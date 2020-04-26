package moe.ganen.jikankt.models.search

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeSearchSubEntity

/**
 * Result of search query.
 */
data class AnimeSearchResult(
    /**
     * List of anime result of search query.
     */
    @SerializedName("results")
    val results: List<AnimeSearchSubEntity?>? = null,

    /**
     * Index of last page.
     */
    @SerializedName("last_page")
    val lastPage: Int? = null
) : Entity()