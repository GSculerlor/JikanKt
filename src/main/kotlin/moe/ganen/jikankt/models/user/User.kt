package moe.ganen.jikankt.models.user

import com.google.gson.annotations.SerializedName
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.base.types.UserAnimeStats
import moe.ganen.jikankt.models.base.types.UserFavorites
import moe.ganen.jikankt.models.base.types.UserMangaStats
import java.util.*

data class User(
    /**
     * ID associated with MyAnimeList User.
     */
    @SerializedName("user_id")
    val userId: Int,

    /**
     * Username associated with MyAnimeList User.
     */
    @SerializedName("username")
    val username: String,

    /**
     * User's MyAnimeList link.
     */
    @SerializedName("url")
    val url: String? = null,

    /**
     * User's MyAnimeList cover/image link.
     */
    @SerializedName("image_url")
    val imageUrl: String? = null,

    /**
     * User's last online on MyAnimeList.
     */
    @SerializedName("last_online")
    val lastOnline: Date? = null,

    /**
     * User's gender.
     */
    @SerializedName("gender")
    val gender: String? = null,

    /**
     * User's birthday.
     */
    @SerializedName("birthday")
    val birthday: Date? = null,

    /**
     * User's location.
     */
    @SerializedName("location")
    val location: String? = null,

    /**
     * The date the user joined MyAnimeList.
     */
    @SerializedName("joined")
    val joined: Date? = null,

    /**
     * User's anime stats.
     */
    @SerializedName("anime_stats")
    val animeStats: UserAnimeStats? = null,

    /**
     * User's manga stats.
     */
    @SerializedName("manga_stats")
    val mangaStats: UserMangaStats? = null,

    /**
     * User's favorites.
     */
    @SerializedName("favorites")
    val favorites: UserFavorites? = null,

    /**
     * User's detail, returned in HTML format.
     */
    @SerializedName("about")
    val about: String? = null
) : Entity()