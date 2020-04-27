package moe.ganen.jikankt.models.user

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.MangaListEntity

data class UserMangaList(
    /**
     * List of user's manga on their anime list.
     */
    @SerializedName("manga")
    val manga: List<MangaListEntity?>? = null
) : Entity()