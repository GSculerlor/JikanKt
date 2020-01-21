package moe.ganen.jikankt.utils

import com.google.gson.*
import java.lang.reflect.Type

/**
 * Used for serialize/deserialize class with interface/abstract class
 * @see <a href="https://stackoverflow.com/questions/4795349/how-to-serialize-a-class-with-an-interface/9550086"></a>
 */
internal class InterfaceAdapter<T : Any> : JsonSerializer<T>, JsonDeserializer<T> {
    override fun serialize(`object`: T, interfaceType: Type?, context: JsonSerializationContext): JsonElement {
        return JsonObject().also {
            it.addProperty("type", `object`::class.java.name)
            it.add("data", context.serialize(`object`))
        }
    }

    @Throws(JsonParseException::class)
    override fun deserialize(elem: JsonElement, interfaceType: Type?, context: JsonDeserializationContext): T {
        val wrapper = elem as JsonObject
        val typeName = get(wrapper, "type")
        val data = get(wrapper, "data")
        val actualType: Type = typeForName(typeName)

        return context.deserialize(data, actualType)
    }

    private fun typeForName(typeElem: JsonElement): Type {
        return try {
            Class.forName(typeElem.asString)
        } catch (e: ClassNotFoundException) {
            throw JsonParseException(e)
        }
    }

    private operator fun get(wrapper: JsonObject, memberName: String): JsonElement {
        return wrapper[memberName]
            ?: throw JsonParseException("no '$memberName' member found in what was expected to be an interface wrapper")
    }
}