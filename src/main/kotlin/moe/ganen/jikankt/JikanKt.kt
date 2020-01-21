package moe.ganen.jikankt

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import mu.KotlinLogging
import okhttp3.Protocol

object JikanKt {
    private const val JIKANKT_NAME = "JikanKt"
    private const val JIKANKT_VERSION = "0.0.1"

    val CLIENT by lazy {
        HttpClient(OkHttp) {
            engine {
                config {
                    protocols(listOf(Protocol.HTTP_1_1))
                }
            }

            install(JsonFeature) {
                serializer = GsonSerializer()
            }

            expectSuccess = false
        }
    }

    val LOGGER = KotlinLogging.logger(JIKANKT_NAME)

    init {
        LOGGER.info { "Initialize $JIKANKT_NAME version $JIKANKT_VERSION" }
    }
}