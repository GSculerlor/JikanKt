package moe.ganen.jikankt.connection

import moe.ganen.jikankt.JikanClient.Companion.JIKANKT_LOG
import okhttp3.Interceptor
import okhttp3.Response

class RateLimitInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var response = chain.proceed(chain.request())

        //See: https://jikan.docs.apiary.io/#introduction/http-response
        if (!response.isSuccessful && response.code() == 429) {
            try {
                JIKANKT_LOG.error("You are being rate limited or Jikan is being rate limited by MyAnimeList, retrying in 4 seconds...")
                Thread.sleep(4000L)
            } catch (e: InterruptedException) {
            }

            response = chain.proceed(chain.request())
        }

        return response
    }
}