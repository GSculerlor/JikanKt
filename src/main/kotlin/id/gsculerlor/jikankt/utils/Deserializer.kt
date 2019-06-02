package id.gsculerlor.jikankt.utils

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.GsonBuilder
import java.lang.reflect.Type

fun deserializer(type: Type): ResponseDeserializable<Any> {
    return object : ResponseDeserializable<Any> {
        override fun deserialize(content: String): Any? {
            return GsonBuilder().create().fromJson(content, type)
        }
    }
}