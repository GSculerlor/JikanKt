package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.MangaSubEntity
import moe.ganen.jikankt.models.genre.Genre
import moe.ganen.jikankt.models.genre.RequestType
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseGenre {

    @Test
    fun `test get anime action genre`() {
        val expected =
            Genre(
                metadata = MalSubEntity(1, "anime", "Action Anime", "https://myanimelist.net/anime/genre/1/Action"),
                anime = listOf(
                    AnimeSubEntity(malId = 16498, title = "Shingeki no Kyojin"),
                    AnimeSubEntity(malId = 11757, title = "Sword Art Online")
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.ANIME, 1) }

        assertEquals(expected.metadata, result.metadata)
        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)
        assertEquals(expected.anime?.get(1)?.title, result.anime?.get(1)?.title)
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
                ),
                anime = listOf(
                    AnimeSubEntity(malId = 40356, title = "Tate no Yuusha no Nariagari 2nd Season"),
                    AnimeSubEntity(malId = 34086, title = "Tales of Zestiria the Cross 2nd Season")
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.ANIME, 2, 3) }

        assertEquals(expected.metadata, result.metadata)
        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)
        assertEquals(expected.anime?.get(1)?.title, result.anime?.get(1)?.title)
        assert(result.manga.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get manga comedy genre`() {
        val expected =
            Genre(
                metadata = MalSubEntity(4, "manga", "Comedy Manga", "https://myanimelist.net/manga/genre/4/Comedy"),
                manga = listOf(
                    MangaSubEntity(malId = 13, title = "One Piece"),
                    MangaSubEntity(malId = 44347, title = "One Punch-Man")
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.MANGA, 4) }

        assertEquals(expected.metadata, result.metadata)
        assertEquals(expected.manga?.get(0)?.title, result.manga?.get(0)?.title)
        assertEquals(expected.manga?.get(1)?.title, result.manga?.get(1)?.title)
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
                ),
                manga = listOf(
                    MangaSubEntity(malId = 58945, title = "Tawamure Yuuoni")
                )
            )

        val result = runBlocking { JikanKt.getGenreType(RequestType.MANGA, 6, 5) }

        assertEquals(expected.metadata, result.metadata)
        assertEquals(expected.manga?.get(0)?.title, result.manga?.get(0)?.title)
        assert(result.anime.isNullOrEmpty())

        runBlocking { delay(3000) }
    }
}