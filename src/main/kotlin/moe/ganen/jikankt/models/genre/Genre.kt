package moe.ganen.jikankt.models.genre

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.MangaSubEntity

data class Genre(
    /**
     * Genre's metadata
     */
    @SerializedName("mal_url")
    val metadata: MalSubEntity? = null,

    /**
     * Anime/manga count in this genre.
     */
    @SerializedName("item_count")
    val itemCount: Int? = null,

    /**
     * List of manga in this genre (will be null if request type is anime.
     */
    @SerializedName("manga")
    val manga: List<MangaSubEntity?>? = null,

    /**
     * List of anime in this genre (will be null if request type is manga.
     */
    @SerializedName("anime")
    val anime: List<AnimeSubEntity?>? = null
) : Entity()