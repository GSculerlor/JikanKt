package moe.ganen.jikankt.connection

import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.readText
import io.ktor.http.HttpHeaders
import moe.ganen.jikankt.JikanClient
import moe.ganen.jikankt.exception.JikanException

class RestClient(private val isDebug: Boolean) : JikanClient() {
    private val client = httpClient
    private val gson = Gson()

    suspend fun request(endPoint: String, data: JsonObject? = null): JsonElement {
        try {
            var url = BASE_URL + endPoint
            if (data != null) {
                url += "?" + data.entrySet().joinToString("&") { entry ->
                    "${entry.key}=${entry.value}"
                }
            }

            logger.info { "Requesting to Jikan: $url" }


            val response = client.get<HttpResponse>(url) {
                header(HttpHeaders.Accept, "application/json")
            }

            val contentType = response.headers["Content-Type"]
            val body = response.readText()

            val json = if (contentType?.equals("application/json", true) == true) {
                gson.fromJson(body, JsonElement::class.java)
            } else {
                null
            }

            logger.debug("Response from Jikan: ${response.status.value}, body: $json")

            if (response.status.value !in 200..299) {
                if (response.status.value in 500..599) {
                    val ex = Exception("An internal server error has occurred, code: ${response.status.value}")
                    if (isDebug)
                        throw ex
                    else
                        exceptionHandler(ex)
                } else {
                    val ex = JikanException(
                        "Jikan API returns code ${response.status.value} and body ${json?.toString()}",
                        response.status.value
                    )

                    if (isDebug)
                        throw ex
                    else
                        exceptionHandler(ex)
                }
            }

            return json ?: JsonObject()
        } catch (ex: Exception) {
            if (!isDebug) {
                return exceptionHandler(ex, "An unexpected error has occurred!")
            } else
                throw ex
        }
    }

    private fun exceptionHandler(ex: java.lang.Exception, message: String? = null) : JsonObject {
        if (message.isNullOrEmpty())
            logger.error { "Something went wrong! Exception: ${ex.localizedMessage}" }
        else
            logger.error(ex) { message }

        //Will return empty json object instead
        return JsonObject()
    }

    companion object {
        private const val BASE_URL = "https://api.jikan.moe/v3/"
    }
}