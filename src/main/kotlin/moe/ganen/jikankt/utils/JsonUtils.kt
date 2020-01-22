package moe.ganen.jikankt.utils

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject
import java.lang.reflect.Type

fun createJson(builder: JsonBuilder.() -> Unit) = JsonBuilder().apply(builder).get()

class JsonBuilder {
    private val jsonObject = JsonObject()

    infix fun String.to(value: Number?) {
        jsonObject.addProperty(this, value)
    }

    infix fun String.to(value: String?) {
        jsonObject.addProperty(this, value)
    }

    infix fun String.to(value: Boolean?) {
        jsonObject.addProperty(this, value)
    }

    infix fun String.to(value: JsonElement?) {
        jsonObject.add(this, value)
    }

    fun String.toNull() {
        jsonObject.add(this, JsonNull.INSTANCE)
    }

    fun get() = jsonObject
}

/**
 * Gson extension function to deserialize [JsonElement] to [T]
 * @param jsonElement: Json element that want to deserialize.
 * @param type: return type
 * @return T as the deserialize result.
 */
fun <T : Any> Gson.deserialize(jsonElement: JsonElement, type: Type): T {
    return this.fromJson<T>(jsonElement, type)
}