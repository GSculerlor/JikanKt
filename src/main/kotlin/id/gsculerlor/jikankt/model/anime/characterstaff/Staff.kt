package id.gsculerlor.jikankt.model.anime.characterstaff

import com.google.gson.annotations.SerializedName

data class Staff(

    @SerializedName("mal_id")
    val malId: String? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null,

    @SerializedName("positions")
    val positions: List<String?>? = null
)