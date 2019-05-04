package id.gsculerlor.jikankt.model.etc.aired

import com.google.gson.annotations.SerializedName
import id.gsculerlor.jikankt.model.etc.prop.Prop

data class Aired(

    @SerializedName("from")
    val from: String? = null,

    @SerializedName("to")
    val to: String? = null,

    @SerializedName("prop")
    val prop: Prop? = null,

    @SerializedName("string")
    val string: String? = null
)