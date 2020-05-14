package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import org.junit.Assert.assertEquals
import org.junit.Test


class TestCaseCustomRestClient {

    @Test(expected = JikanException::class)
    fun `test request to invalid domain`() {
        runBlocking { JikanKt.apply { restClient = RestClient(isDebug = true, url = "http://ganen.moe:8800/v69/") }.getAnime(9289) }

        runBlocking { delay(3000) }
    }

    @Test
    fun `test request to ganen moe`() {
        val result = runBlocking { JikanKt.apply { restClient = RestClient(url = "http://ganen.moe:8800/v3/") }.getAnime(9289) }
        val expected = runBlocking { JikanKt.apply { restClient = RestClient() }.getAnime(9289) }

        assertEquals(expected.malId, result.malId)

        runBlocking { delay(3000) }
    }
}