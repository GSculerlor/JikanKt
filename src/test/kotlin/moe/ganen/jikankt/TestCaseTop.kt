package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.models.base.types.AnimeTopEntity
import moe.ganen.jikankt.models.base.types.CharacterTopEntity
import moe.ganen.jikankt.models.base.types.MangaTopEntity
import moe.ganen.jikankt.models.base.types.PeopleTopEntity
import moe.ganen.jikankt.models.top.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

class TestCaseTop {

    //region top anime

    @Test
    fun `test get top anime`() {
        val expected = TopAnime(
            top = listOf(
                AnimeTopEntity(malId = 5114, rank = 1, title = "Fullmetal Alchemist: Brotherhood")
            )
        )

        val result = runBlocking { JikanKt.getTopAnime() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)
        assert(result.top?.get(49)?.rank == 50)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top anime second page`() {
        val result = runBlocking { JikanKt.getTopAnime(2) }

        assert(result.top?.get(0)?.rank == 51)
        assert(result.top?.get(49)?.rank == 100)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top anime with movie subtype`() {
        val expected = TopAnime(
            top = listOf(
                AnimeTopEntity(malId = 32281, rank = 1, title = "Kimi no Na wa.")
            )
        )

        val result = runBlocking { JikanKt.getTopAnime(1, TopSubtype.MOVIE) }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top anime with ova subtype`() {
        val expected = TopAnime(
            top = listOf(
                AnimeTopEntity(malId = 820, rank = 1, title = "Ginga Eiyuu Densetsu")
            )
        )

        val result = runBlocking { JikanKt.getTopAnime(1, TopSubtype.OVA) }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    //endregion

    //region top manga

    @Test
    fun `test get top manga`() {
        val expected = TopManga(
            top = listOf(
                MangaTopEntity(malId = 2, rank = 1, title = "Berserk")
            )
        )

        val result = runBlocking { JikanKt.getTopManga() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top manga with oneshot subtype`() {
        val expected = TopManga(
            top = listOf(
                MangaTopEntity(malId = 48621, rank = 1, title = "Koe no Katachi")
            )
        )

        val result = runBlocking { JikanKt.getTopManga(1, TopSubtype.ONESHOTS) }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top anime with novel subtype`() {
        val expected = TopManga(
            top = listOf(
                MangaTopEntity(malId = 14893, rank = 1, title = "Monogatari Series: First Season")
            )
        )

        val result = runBlocking { JikanKt.getTopManga(1, TopSubtype.NOVELS) }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    //endregion

    //region top character

    @Test
    fun `test get top characters`() {
        val expected = TopCharacters(
            top = listOf(
                CharacterTopEntity(malId = 417, rank = 1, name = "Lamperouge, Lelouch")
            )
        )

        val result = runBlocking { JikanKt.getTopCharacters() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 50)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top characters second page`() {
        val result = runBlocking { JikanKt.getTopCharacters(2) }

        assert(result.top?.get(0)?.rank == 51)
        assert(result.top?.get(49)?.rank == 100)

        runBlocking { delay(3000) }
    }
    //endregion

    //region top people

    @Test
    fun `test get top people`() {
        val expected = TopPeople(
            top = listOf(
                PeopleTopEntity(malId = 185, rank = 1, name = "Hanazawa, Kana")
            )
        )

        val result = runBlocking { JikanKt.getTopPeople() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 50)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top people second page`() {
        val result = runBlocking { JikanKt.getTopPeople(2) }

        assert(result.top?.get(0)?.rank == 51)
        assert(result.top?.get(49)?.rank == 100)

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