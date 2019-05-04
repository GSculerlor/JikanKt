package id.gsculerlor.jikankt.model.etc.staff

import com.google.gson.annotations.SerializedName

data class Staff(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("mal_id")
    val malId: Int? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)