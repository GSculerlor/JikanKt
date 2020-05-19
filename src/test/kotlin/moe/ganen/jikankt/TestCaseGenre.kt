package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.genre.Genre
import moe.ganen.jikankt.models.genre.RequestType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class TestCaseGenre {

    @Test
    fun `test get anime action genre`() {
        val expected =
            Genre(
                metadata = MalSubEntity(1, "anime", "Action Anime", "https://myanimelist.net/anime/genre/1/Action")
            )

        val result = runBlocking { JikanKt.apply { restClient = RestClient(url = "http://ganen.moe:8800/v3/") }.getGenreType(RequestType.ANIME, 1) }

        assertEquals(expected.metadata, result.metadata)
        assert(result.manga.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get anime adventure genre third page`() {
        val expected =
            Genre(
                metadata = MalSubEntity(
                    2,
                    "anime",
                    "Adventure Anime",
                    "https://myanimelist.net/anime/genre/2/Adventure?page=3"
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.ANIME, 2, 3) }

        assertEquals(expected.metadata, result.metadata)
        assert(result.manga.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get manga comedy genre`() {
        val expected =
            Genre(
                metadata = MalSubEntity(4, "manga", "Comedy Manga", "https://myanimelist.net/manga/genre/4/Comedy")
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.MANGA, 4) }

        assertEquals(expected.metadata, result.metadata)
        assert(result.anime.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get manga demon genre fifth page`() {
        val expected =
            Genre(
                metadata = MalSubEntity(
                    6,
                    "manga",
                    "Demons Manga",
                    "https://myanimelist.net/manga/genre/6/Demons?page=5"
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.MANGA, 6, 5) }

        assertEquals(expected.metadata, result.metadata)
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