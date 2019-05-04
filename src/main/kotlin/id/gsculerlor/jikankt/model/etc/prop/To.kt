package id.gsculerlor.jikankt.model.etc.prop

import com.google.gson.annotations.SerializedName

data class To(

    @SerializedName("day")
    val day: Int? = null,

    @SerializedName("month")
    val month: Int? = null,

    @SerializedName("year")
    val year: Int? = null
)