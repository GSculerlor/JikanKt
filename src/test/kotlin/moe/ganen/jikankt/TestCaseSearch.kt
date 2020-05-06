package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.AnimeSearchSubEntity
import moe.ganen.jikankt.models.base.types.CharacterSearchSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.PeopleSearchSubEntity
import moe.ganen.jikankt.models.search.AnimeSearchQuery
import moe.ganen.jikankt.models.search.AnimeSearchResult
import moe.ganen.jikankt.models.search.CharacterSearchResult
import moe.ganen.jikankt.models.search.enums.*
import org.junit.Assert.assertEquals
import org.junit.Test
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
        runBlocking { delay(1500) }
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
        assertEquals(20, result.lastPage)
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search anime with query 2`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 39569,
                    title = "Sora no Aosa wo Shiru Hito yo",
                    type = AnimeType.Movie,
                    startDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }.parse("2019-10-11T00:00:00+00:00"),
                    endDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }.parse("2019-10-11T00:00:00+00:00")
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
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search anime with query 3`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 2559,
                    title = "Romeo no Aoi Sora",
                    type = AnimeType.TV,
                    startDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }.parse("1995-01-15T00:00:00+00:00"),
                    endDate = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }.parse("1995-12-17T00:00:00+00:00")
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
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search anime with query 4`() {
        val expected = AnimeSearchResult(
            results = listOf(
                AnimeSearchSubEntity(
                    malId = 41759,
                    title = "Sora Tobu Kujira",
                    type = AnimeType.Music
                )
            )
        )
        val result = runBlocking {
            JikanKt.searchAnime(
                "Sora no Aosa",
                AnimeSearchQuery(
                    orderBy = AnimeOrderBy.Members,
                    sort = Sort.Ascending,
                    limit = 1
                )
            )
        }

        assertEquals(expected.results?.get(0)?.malId, result.results?.get(0)?.malId)
        assertEquals(expected.results?.get(0)?.title, result.results?.get(0)?.title)
        assertEquals(expected.results?.get(0)?.type, result.results?.get(0)?.type)
        assertEquals(20, result.lastPage)
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search anime with query 5`() {
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
        assertEquals(2, result.lastPage)
        runBlocking { delay(1500) }
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
        runBlocking { delay(1500) }
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
        runBlocking { delay(1500) }
    }

    @Test
    fun `test characters multiple page result`() {
        val expected = 6
        val result = runBlocking { JikanKt.searchCharacter("naruto").lastPage }

        assertEquals(expected, result)
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search random character return empty`() {
        val jikan = JikanKt.apply {
            restClient = RestClient(false)
        }

        val expected = CharacterSearchResult()
        val result = runBlocking { jikan.searchCharacter("Bjir") }

        assertEquals(expected, result)
        runBlocking { delay(1500) }
    }

    @Test(expected = JikanException::class)
    fun `test search random character return exception`() {
        val jikan = JikanKt.apply {
            restClient = RestClient(true)
        }
        runBlocking { jikan.searchCharacter("Bjir").results?.get(0) }
        runBlocking { delay(1500) }
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
        runBlocking { delay(1500) }
    }

    @Test
    fun `test search random people`() {
        val result = runBlocking { JikanKt.searchPeople("Bjir").results }
        assertEquals(0, result?.size)
        runBlocking { delay(1500) }
    }

    //endregion
}