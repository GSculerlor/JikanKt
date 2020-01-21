package moe.ganen.jikankt.connection

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import io.ktor.client.call.call
import io.ktor.client.request.header
import io.ktor.client.request.url
import io.ktor.client.response.readText
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import moe.ganen.jikankt.JikanClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.exception.TooManyRequestException

class RestClient : JikanClient() {
    private val client = CLIENT
    private val gson = Gson()

    suspend fun request(endPoint: String, data: JsonObject? = null): JsonElement {
        try {
            var url = BASE_URL + endPoint
            if (data != null) {
                url += "?" + data.entrySet().joinToString("&") { entry ->
                    "${entry.key}=${entry.value}"
                }
            }

            LOGGER.info { "Requesting to Jikan: $url" }

            val response = client.call {
                method = HttpMethod.Get

                url(url)
                header(HttpHeaders.Accept, "application/json")
            }.response

            val contentType = response.headers["Content-Type"]
            val body = response.readText()

            response.close()

            val json = if (contentType?.equals("application/json", true) == true) {
                gson.fromJson(body, JsonElement::class.java)
            } else {
                null
            }

            LOGGER.debug("Response from Jikan: ${response.status.value}, body: $json")

            if (response.status.value !in 200..299) {
                if (response.status.value in 500..599)
                    throw Exception("An internal server error has occurred, code: ${response.status.value}")

                throw JikanException(
                    "Jikan API returns code ${response.status.value} and body ${json?.toString()}",
                    response.status.value
                )
            }

            return json ?: JsonObject()
        } catch (ex: JikanException) {
            throw ex
        } catch (ex: TooManyRequestException) {
            throw ex
        } catch (ex: Exception) {
            LOGGER.error(ex) { "An unexpected error has occurred!" }
            throw ex
        }
    }

    companion object {
        private const val BASE_URL = "https://api.jikan.moe/v3/"
    }
}