package id.gsculerlor.jikankt.model.anime

import com.google.gson.annotations.SerializedName
import id.gsculerlor.jikankt.model.etc.aired.Aired
import id.gsculerlor.jikankt.model.etc.genre.Genre
import id.gsculerlor.jikankt.model.etc.related.Related
import id.gsculerlor.jikankt.model.etc.staff.Staff

data class Anime(

    @SerializedName("request_hash")
    val requestHash: String? = null,

    @SerializedName("request_cached")
    val requestCached: Boolean? = null,

    @SerializedName("request_cache_expiry")
    val requestCacheExpiry: Int? = null,

    @SerializedName("mal_id")
    val malId: Int? = null,

    @SerializedName("url")
    val url: String? = null,

    @SerializedName("trailer_url")
    val trailerUrl: String? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("title_english")
    val titleEnglish: String? = null,

    @SerializedName("title_japanese")
    val titleJapanese: String? = null,

    @SerializedName("title_synonyms")
    val titleSynonyms: List<String?>? = null,

    @SerializedName("type")
    val type: String? = null,

    @SerializedName("source")
    val source: String? = null,

    @SerializedName("episodes")
    val episodes: Int? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("aired")
    val aired: Aired? = null,

    @SerializedName("airing")
    val airing: Boolean? = null,

    @SerializedName("duration")
    val duration: String? = null,

    @SerializedName("rating")
    val rating: String? = null,

    @SerializedName("score")
    val score: Double? = null,

    @SerializedName("scored_by")
    val scoredBy: Int? = null,

    @SerializedName("rank")
    val rank: Int? = null,

    @SerializedName("popularity")
    val popularity: Int? = null,

    @SerializedName("members")
    val members: Int? = null,

    @SerializedName("favorites")
    val favorites: Int? = null,

    @SerializedName("synopsis")
    val synopsis: String? = null,

    @SerializedName("background")
    val background: String? = null,

    @SerializedName("premiered")
    val premiered: String? = null,

    @SerializedName("broadcast")
    val broadcast: String? = null,

    @SerializedName("related")
    val related: Related? = null,

    @SerializedName("producers")
    val producers: List<Staff?>? = null,

    @SerializedName("licensors")
    val licensors: List<Staff?>? = null,

    @SerializedName("studios")
    val studios: List<Staff?>? = null,

    @SerializedName("genres")
    val genres: List<Genre?>? = null,

    @SerializedName("opening_themes")
    val openingThemes: List<String?>? = null,

    @SerializedName("ending_themes")
    val endingThemes: List<String?>? = null,

    @SerializedName("image_url")
    val imageUrl: String? = null
)