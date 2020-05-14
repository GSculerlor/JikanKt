package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.prod.Producer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestCaseProducer {

    @Test
    fun `test get Sotsu metadata`() {
        val expected = Producer(
            metadata = MalSubEntity(
                64,
                "anime",
                "Sotsu",
                "https://myanimelist.net/anime/producer/64/Sotsu"
            )
        )

        val result = runBlocking { JikanKt.getProducer(64) }

        assertEquals(expected.metadata, result.metadata)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get Studio Pierrot anime`() {
        val expected = Producer(
            anime = listOf(AnimeSubEntity(22319, title = "Tokyo Ghoul"), AnimeSubEntity(20, title = "Naruto"))
        )

        val result = runBlocking { JikanKt.getProducer(1) }

        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)
        assertEquals(expected.anime?.get(1)?.title, result.anime?.get(1)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get bad ID producer return exception`() {
        assertThrows<JikanException> {
            runBlocking {
                JikanKt.apply { restClient = RestClient(true, url = "http://ganen.moe:8800/v3/") }.getProducer(712)
            }
        }
        runBlocking { delay(3000) }
    }

    @Test
    fun `test get bad ID producer`() {
        val result = runBlocking {
            JikanKt.apply { restClient = RestClient(false, url = "http://ganen.moe:8800/v3/") }.getProducer(712)
        }

        assert(result.anime.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            JikanKt.apply { restClient = RestClient(url = "http://ganen.moe:8800/v3/") }
        }
    }
}