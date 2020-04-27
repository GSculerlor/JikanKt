package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

/**
 * User Favorites.
 */
data class UserFavorites(
    /**
     * User's favorite anime.
     */
    @SerializedName("anime")
    val anime: List<UserFavSubEntity?>? = null,

    /**
     * User's favorite manga.
     */
    @SerializedName("manga")
    val manga: List<UserFavSubEntity?>? = null,

    /**
     * User's favorite characters.
     */
    @SerializedName("characters")
    val characters: List<UserFavSubEntity?>? = null,

    /**
     * User's favorite people.
     */
    @SerializedName("people")
    val people: List<UserFavSubEntity?>? = null
)