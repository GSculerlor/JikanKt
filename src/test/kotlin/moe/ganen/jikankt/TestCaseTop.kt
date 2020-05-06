package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.base.types.AnimeTopEntity
import moe.ganen.jikankt.models.base.types.CharacterTopEntity
import moe.ganen.jikankt.models.base.types.MangaTopEntity
import moe.ganen.jikankt.models.base.types.PeopleTopEntity
import moe.ganen.jikankt.models.top.*
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseTop {

    //region top anime

    @Test
    fun `test get top anime`() {
        val expected = TopAnime(
            top = listOf(
                AnimeTopEntity(malId = 5114, rank = 1, title = "Fullmetal Alchemist: Brotherhood"),
                AnimeTopEntity(malId = 37991, rank = 50, title = "JoJo no Kimyou na Bouken Part 5: Ougon no Kaze")
            )
        )

        val result = runBlocking { JikanKt.getTopAnime() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)
        assert(result.top?.get(49)?.rank == 50)
        assertEquals(expected.top?.get(1)?.title, result.top?.get(49)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top anime second page`() {
        val expected = TopAnime(
            top = listOf(
                AnimeTopEntity(malId = 34591, rank = 51, title = "Natsume Yuujinchou Roku"),
                AnimeTopEntity(malId = 10165, rank = 100, title = "Nichijou")
            )
        )

        val result = runBlocking { JikanKt.getTopAnime(2) }

        assert(result.top?.get(0)?.rank == 51)
        assertEquals(expected.top?.get(0)?.title, result.top?.get(0)?.title)
        assert(result.top?.get(49)?.rank == 100)
        assertEquals(expected.top?.get(1)?.title, result.top?.get(49)?.title)

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
                CharacterTopEntity(malId = 417, rank = 1, name = "Lamperouge, Lelouch"),
                CharacterTopEntity(malId = 67067, rank = 50, name = "Yukinoshita, Yukino")
            )
        )

        val result = runBlocking { JikanKt.getTopCharacters() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 50)
        assertEquals(expected.top?.get(1)?.name, result.top?.get(49)?.name)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top characters second page`() {
        val expected = TopCharacters(
            top = listOf(
                CharacterTopEntity(malId = 913, rank = 51, name = "Vegeta"),
                CharacterTopEntity(malId = 118739, rank = 100, name = "Sakurajima, Mai")
            )
        )

        val result = runBlocking { JikanKt.getTopCharacters(2) }

        assert(result.top?.get(0)?.rank == 51)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 100)
        assertEquals(expected.top?.get(1)?.name, result.top?.get(49)?.name)

        runBlocking { delay(3000) }
    }
    //endregion

    //region top people

    @Test
    fun `test get top people`() {
        val expected = TopPeople(
            top = listOf(
                PeopleTopEntity(malId = 185, rank = 1, name = "Hanazawa, Kana"),
                PeopleTopEntity(malId = 2836, rank = 50, name = "Asano, Inio")
            )
        )

        val result = runBlocking { JikanKt.getTopPeople() }

        assert(result.top?.get(0)?.rank == 1)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 50)
        assertEquals(expected.top?.get(1)?.name, result.top?.get(49)?.name)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get top people second page`() {
        val expected = TopPeople(
            top = listOf(
                PeopleTopEntity(malId = 508, rank = 51, name = "Kanno, Yoko"),
                PeopleTopEntity(malId = 19169, rank = 100, name = "EGOIST")
            )
        )

        val result = runBlocking { JikanKt.getTopPeople(2) }

        assert(result.top?.get(0)?.rank == 51)
        assertEquals(expected.top?.get(0)?.name, result.top?.get(0)?.name)
        assert(result.top?.get(49)?.rank == 100)
        assertEquals(expected.top?.get(1)?.name, result.top?.get(49)?.name)

        runBlocking { delay(3000) }
    }
    //endregion
}