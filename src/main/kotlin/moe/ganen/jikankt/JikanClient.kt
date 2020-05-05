package moe.ganen.jikankt

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import mu.KotlinLogging
import okhttp3.Protocol

open class JikanClient {
    protected val httpClient by lazy {
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

    protected val logger = KotlinLogging.logger(JIKANKT_NAME)

    init {
        logger.info { "Initialize $JIKANKT_NAME version $JIKANKT_VERSION" }
    }

    companion object {
        private const val JIKANKT_NAME = "JikanKt"
        private const val JIKANKT_VERSION = "1.1.3"
    }
}