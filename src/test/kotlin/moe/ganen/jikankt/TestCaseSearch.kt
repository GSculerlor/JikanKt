package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.*
import moe.ganen.jikankt.models.search.*
import moe.ganen.jikankt.models.search.enums.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.text.SimpleDateFormat
import java.util.*

class TestCaseSearch {

    //region search anime

    @Test
    fun `test search anime without query`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 39569,
                    title = "Sora no Aosa wo Shiru Hito yo",
                    type = AnimeType.Movie
                )
            )
        )
        val result = runBlocking { JikanKt.searchAnime("Sora no Aosa") }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(20, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime without title`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 7669,
                    title = "\"Bungaku Shoujo\" Kyou no Oyatsu: Hatsukoi",
                    type = AnimeType.OVA
                )
            )
        )
        val result = runBlocking { JikanKt.searchAnime(additionalQuery = AnimeSearchQuery(AnimeType.OVA)) }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime with query 1`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 22791,
                    title = "Sora Iro Hana Iro",
                    type = AnimeType.Movie,
                    rated = "PG"
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(type = AnimeType.Movie, rated = AgeRating.PG)
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(expected.results?.get(0)?.rated, result.results?.get(0)?.rated)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime with query 2`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 39569,
                    title = "Sora no Aosa wo Shiru Hito yo",
                    type = AnimeType.Movie,
                    startDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply {
                        timeZone = TimeZone.getTimeZone("UTC")
                    }.parse("2019-10-11T00:00:00+00:00"),
                    endDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }
                        .parse("2019-10-11T00:00:00+00:00")
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(
                    startDate = SimpleDateFormat("yyyy-MM-dd").parse("2019-10-11"),
                    endDate = SimpleDateFormat("yyyy-MM-dd").parse("2019-10-11")
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(expected.results?.get(0)?.startDate, result.results?.get(0)?.startDate)
        assertEquals(expected.results?.get(0)?.endDate, result.results?.get(0)?.endDate)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime with query 3`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 2559,
                    title = "Romeo no Aoi Sora",
                    type = AnimeType.TV,
                    startDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply {
                        timeZone = TimeZone.getTimeZone("UTC")
                    }.parse("1995-01-15T00:00:00+00:00"),
                    endDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }
                        .parse("1995-12-17T00:00:00+00:00")
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(
                    score = 8,
                    limit = 1
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(expected.results?.get(0)?.startDate, result.results?.get(0)?.startDate)
        assertEquals(expected.results?.get(0)?.endDate, result.results?.get(0)?.endDate)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime with query 4`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 39569,
                    title = "Sora no Aosa wo Shiru Hito yo",
                    type = AnimeType.Movie
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(
                    genre = listOf(AnimeGenre.Drama),
                    limit = 1
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search anime with query 6`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 6987,
                    title = "Aki-Sora",
                    type = AnimeType.OVA
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(
                    genre = listOf(AnimeGenre.Drama),
                    limit = 1,
                    excludedGenre = true
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(3, result.lastPage)
        runBlocking { delay(3000) }
    }

    //endregion

    //region search manga

    @Test
    fun `test search manga without query`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 116793,
                    title = "Meguro-san wa Hajimete ja Nai",
                    type = MangaType.Manga
                )
            )
        )
        val result = runBlocking { JikanKt.searchManga("Meguro") }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(20, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga without title`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 10000,
                    title = "\"Bungaku Shoujo\" Series",
                    score = 8.13
                )
            )
        )
        val result = runBlocking { JikanKt.searchManga(additionalQuery = MangaSearchQuery(score = 8)) }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.score, result.results?.get(0)?.score)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga with query 1`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 13587,
                    title = "Sasagu Omoi wa Hana Meguri",
                    type = MangaType.`One-shot`
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchManga(
                "Meguro",
                MangaSearchQuery(type = MangaType.`One-shot`, score = 7)
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga with query 2`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 14090,
                    title = "All Rounder Meguru",
                    type = MangaType.Manga,
                    startDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply {
                        timeZone = TimeZone.getTimeZone("UTC")
                    }.parse("2008-11-25T00:00:00+00:00"),
                    endDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }
                        .parse("2016-04-12T00:00:00+00:00")

                )
            )
        )
        val result = runBlocking {
            JikanKt.searchManga(
                "Meguro",
                MangaSearchQuery(
                    status = MangaStatus.Complete,
                    startDate = SimpleDateFormat("yyyy-MM-dd").apply { timeZone = TimeZone.getTimeZone("UTC") }
                        .parse("2008-11-25")
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(expected.results?.get(0)?.startDate, result.results?.get(0)?.startDate)
        assertEquals(expected.results?.get(0)?.endDate, result.results?.get(0)?.endDate)
        assertEquals(2, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga with query 3`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 116793,
                    title = "Meguro-san wa Hajimete ja Nai",
                    type = MangaType.Manga
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchManga(
                "Meguro",
                MangaSearchQuery(
                    orderBy = MangaOrderBy.Title
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(20, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga with query 4`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 116793,
                    title = "Meguro-san wa Hajimete ja Nai",
                    type = MangaType.Manga
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchManga(
                "Meguro",
                MangaSearchQuery(
                    genre = listOf(MangaGenre.Comedy)
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(1, result.lastPage)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search manga with query 5`() {
        val expected = MangaSearchResult(
            results = listOf(
                MangaSearchSubEntity(
                    malId = 14090,
                    title = "All Rounder Meguru",
                    type = MangaType.Manga
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchManga(
                "Meguro",
                MangaSearchQuery(
                    genre = listOf(MangaGenre.Comedy),
                    excludedGenre = true
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(4, result.lastPage)
        runBlocking { delay(3000) }
    }

    //endregion

    //region search characters

    @Test
    fun `test search character Amatsukaze`() {
        val expected = CharacterSearchSubEntity(
            malId = 140701,
            name = "Amatsukaze",
            animeography = listOf(MalSubEntity(malId = 31418, name = "KanColle Movie"))
        )

        val result = runBlocking { JikanKt.searchCharacter("Amatsukaze").results?.get(0) }

        assertEquals(expected.malId, result?.malId)
        assertEquals(expected.name, result?.name)
        assertEquals(expected.animeography?.count(), result?.animeography?.count())
        assertEquals(expected.animeography?.get(0)?.name, result?.animeography?.get(0)?.name)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test characters multiple page result`() {
        val expected = 6
        val result = runBlocking { JikanKt.searchCharacter("naruto").lastPage }

        assertEquals(expected, result)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search random character return empty`() {
        val jikan = JikanKt.apply {
            restClient = RestClient(false)
        }

        val expected = CharacterSearchResult()
        val result = runBlocking { jikan.searchCharacter("Bjir") }

        assertEquals(expected, result)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search random character return exception`() {
        assertThrows<JikanException> {
            val jikan = JikanKt.apply {
                restClient = RestClient(true)
            }
            runBlocking { jikan.searchCharacter("Bjir").results?.get(0) }
        }
        runBlocking { delay(3000) }
    }

    //endregion

    //region search people

    @Test
    fun `test search people Uesaka Sumire`() {
        val expected = PeopleSearchSubEntity(
            malId = 14441,
            name = "Sumire Uesaka"
        )

        val result = runBlocking { JikanKt.searchPeople("Sumire Uesaka").results?.get(0) }

        assertEquals(expected.malId, result?.malId)
        assertEquals(expected.name, result?.name)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test search random people`() {
        val result = runBlocking { JikanKt.searchPeople("Bjir").results }
        assertEquals(0, result?.size)
        runBlocking { delay(3000) }
    }

    //endregion

    companion object {
        @BeforeAll
        @JvmStatic
        internal fun setup() {
            JikanKt.apply { restClient = RestClient(url = "http://ganen.moe:8800/v3/") }
        }
    }
}