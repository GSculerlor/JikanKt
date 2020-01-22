package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Episode

/**
 * Anime's episodes data class.
 */
data class AnimeEpisodes(
    /**
     * Last page of episodes.
     */
    @SerializedName("episodes_last_page")
    val lastPage: Int? = null,

    /**
     * List of anime's episode.
     * @see Episode for the detail.
     */
    @SerializedName("episodes")
    val episodes: List<Episode?>? = null
) : Entity()