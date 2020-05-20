package moe.ganen.jikankt

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.features.json.GsonSerializer
import io.ktor.client.features.json.JsonFeature
import moe.ganen.jikankt.utils.JikanLogger
import okhttp3.Protocol
import org.slf4j.Logger

open class JikanClient {
    protected val httpClient by lazy {
        HttpClient(OkHttp) {
            engine {
                config {
                    protocols(listOf(Protocol.HTTP_1_1))
                    //see: https://github.com/ktorio/ktor/issues/1708
                    retryOnConnectionFailure(true)
                }
            }

            install(JsonFeature) {
                serializer = GsonSerializer()
            }

            expectSuccess = false
        }
    }

    init {
        JIKANKT_LOG.info("Initialize $JIKANKT_NAME version $JIKANKT_VERSION")
    }

    companion object {
        private const val JIKANKT_NAME = "JikanKt"
        private const val JIKANKT_VERSION = "1.3.0"
        val JIKANKT_LOG: Logger = JikanLogger().getLog(JIKANKT_NAME)
    }
}