package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.MangaSubEntity
import moe.ganen.jikankt.models.prod.Magazine
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseMagazine {

    @Test
    fun `test get Big Comic Original metadata`() {
        val expected = Magazine(
            metadata = MalSubEntity(
                1,
                "manga",
                "Big Comic Original",
                "https://myanimelist.net/manga/magazine/1/Big_Comic_Original"
            )
        )

        val result = runBlocking { JikanKt.getMagazine(1) }

        assertEquals(expected.metadata, result.metadata)

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get Gessan manga`() {
        val expected = Magazine(
            manga = listOf(
                MangaSubEntity(78537, title = "Karakai Jouzu no Takagi-san"),
                MangaSubEntity(56513, title = "Fudatsuki no Kyouko-chan")
            )
        )

        val result = runBlocking { JikanKt.getMagazine(591) }

        assertEquals(expected.manga?.get(0)?.title, result.manga?.get(0)?.title)
        assertEquals(expected.manga?.get(1)?.title, result.manga?.get(1)?.title)

        runBlocking { delay(2000) }
    }

    @Test(expected = JikanException::class)
    fun `test get bad ID magazine return exception`() {
        runBlocking { JikanKt.apply { restClient = RestClient(true) }.getMagazine(676) }
        runBlocking { delay(2000) }
    }

    @Test
    fun `test get bad ID magazine`() {
        val result = runBlocking { JikanKt.apply { restClient = RestClient(false) }.getMagazine(676) }

        assert(result.manga.isNullOrEmpty())

        runBlocking { delay(2000) }
    }
}