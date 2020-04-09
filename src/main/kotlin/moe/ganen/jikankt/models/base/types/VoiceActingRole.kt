package moe.ganen.jikankt.models.base.types

import com.google.gson.annotations.SerializedName

data class VoiceActingRole(
    /**
     * Person's role.
     */
    @SerializedName("role")
    val role: String? = null,

    /**
     * List of anime associated with person.
     */
    @SerializedName("anime")
    val anime: MalSubEntity? = null,

    /**
     * List of characters associated with person.
     */
    @SerializedName("character")
    val character: MalSubEntity? = null
)