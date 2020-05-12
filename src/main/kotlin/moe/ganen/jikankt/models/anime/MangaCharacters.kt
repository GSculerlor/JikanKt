package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Character

/**
 * Manga's characters data class
 */
data class MangaCharacters(
    /**
     * List of manga character.
     * @see Character for the detail.
     */
    @SerializedName("characters")
    val characters: List<Character?>? = null
) : Entity()