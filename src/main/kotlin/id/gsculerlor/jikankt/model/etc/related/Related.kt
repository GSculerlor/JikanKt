package id.gsculerlor.jikankt.model.etc.related

import com.google.gson.annotations.SerializedName
import id.gsculerlor.jikankt.utils.enums.Relates

data class Related(

    @SerializedName("Prequel")
    val prequel: List<RelatedType?>? = null,

    @SerializedName("Alternative version")
    val alternativeVersion: List<RelatedType?>? = null,

    @SerializedName("Spin-off")
    val spinOff: List<RelatedType?>? = null,

    @SerializedName("Adaptation")
    val adaptation: List<RelatedType?>? = null,

    @SerializedName("Summary")
    val summary: List<RelatedType?>? = null,

    @SerializedName("Sequel")
    val sequel: List<RelatedType?>? = null,

    @SerializedName("Side story")
    val sideStory: List<RelatedType?>? = null,

    @SerializedName("Other")
    val other: List<RelatedType?>? = null,

    @SerializedName("Parent story")
    val parentStory: List<RelatedType?>? = null,

    @SerializedName("Alternative setting")
    val alternativeSetting: List<RelatedType?>? = null,

    @SerializedName("Character")
    val character: List<RelatedType?>? = null,

    @SerializedName("Full story")
    val fullStory: List<RelatedType?>? = null
) {
    fun getRelatedType(relates: Relates): List<RelatedType?>? {
        return when (relates) {
            Relates.PREQUEL -> prequel
            Relates.ALTERNATIVE_VERSION -> alternativeVersion
            Relates.SPIN_OFF -> spinOff
            Relates.ADAPTATION -> adaptation
            Relates.SUMMARY -> summary
            Relates.SEQUEL -> sequel
            Relates.SIDE_STORY -> sideStory
            Relates.OTHER -> other
            Relates.PARENT_STORY -> parentStory
            Relates.ALTERNATIVE_SETTING -> alternativeSetting
            Relates.CHARACTER -> character
            Relates.FULL_STORY -> fullStory
        }
    }
}