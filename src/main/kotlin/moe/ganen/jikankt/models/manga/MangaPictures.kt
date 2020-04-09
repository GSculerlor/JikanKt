package moe.ganen.jikankt.models.manga

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.Picture

data class MangaPictures(
    /**
     * List of pictures.
     * @see Picture for the detail.
     */
    @SerializedName("pictures")
    val pictures: List<Picture?>? = null
) : Entity()