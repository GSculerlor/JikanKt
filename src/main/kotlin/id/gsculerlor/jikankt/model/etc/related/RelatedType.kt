package id.gsculerlor.jikankt.model.etc.related

import com.google.gson.annotations.SerializedName

data class RelatedType(

    @SerializedName("mal_id")
    val malId: Int? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("url")
    val url: String? = null
)