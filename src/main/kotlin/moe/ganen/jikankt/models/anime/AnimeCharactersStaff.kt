package moe.ganen.jikankt.models.anime

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Character
import moe.ganen.jikankt.models.base.types.Staff

data class AnimeCharactersStaff(
    /**
     * List of anime's character.
     * @see Character for the detail.
     */
    @SerializedName("characters")
    val characters: List<Character?>? = null,

    /**
     * List of anime's staff.
     * @see Staff for the detail.
     */
    @SerializedName("staff")
    val staff: List<Staff?>? = null
) : Entity()