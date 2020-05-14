package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.ClubMember
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.club.Club
import moe.ganen.jikankt.models.club.ClubMembers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestCaseClub {

    @Test
    fun `test get Takagi club`() {
        val expected = Club(
            malId = 75088, title = "Club of the Teasing Master Takagi-san", animeRelations = listOf(
                MalSubEntity(malId = 35860, name = "Karakai Jouzu no Takagi-san")
            )
        )

        val result = runBlocking { JikanKt.getClub(75088) }

        assertEquals(expected.malId, result.malId)
        assertEquals(expected.animeRelations?.get(0)?.name, result.animeRelations?.get(0)?.name)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get MyAnimeList Official Mobile App club staff`() {
        val expected = Club(
            malId = 75288,
            title = "MyAnimeList’s Official Mobile App",
            staff = listOf(MalSubEntity(malId = 0, name = "myanimelistllc"), MalSubEntity(malId = 0, name = "Xinil"))
        )

        val result = runBlocking { JikanKt.getClub(75288) }

        assertEquals(expected.malId, result.malId)
        assertEquals(expected.staff?.get(0)?.name, result.staff?.get(0)?.name)
        assertEquals(expected.staff?.get(1)?.name, result.staff?.get(1)?.name)
        assert(result.animeRelations.isNullOrEmpty())
        assert(result.mangaRelations.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get bad ID club return exception`() {
        assertThrows<JikanException> {
            runBlocking {
                JikanKt.apply { restClient = RestClient(true, url = "http://ganen.moe:8800/v3/") }.getClub(7787)
            }
        }
        runBlocking { delay(3000) }
    }

    @Test
    fun `test get bad ID club`() {
        val result = runBlocking {
            JikanKt.apply { restClient = RestClient(false, url = "http://ganen.moe:8800/v3/") }.getClub(7787)
        }

        assert(result.mangaRelations.isNullOrEmpty())
        assert(result.animeRelations.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get Takagi club member`() {
        val expected = ClubMembers(
            listOf(ClubMember("Aceless-kun"), ClubMember("Amhaz"))
        )

        val result = runBlocking { JikanKt.getClubMembers(75088) }

        assertEquals(expected.members?.get(0)?.username, result.members?.get(0)?.username)
        assertEquals(expected.members?.get(1)?.username, result.members?.get(1)?.username)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get bad ID club members`() {
        val result = runBlocking {
            JikanKt.apply { restClient = RestClient(false, url = "http://ganen.moe:8800/v3/") }.getClubMembers(7787)
        }

        assert(result.members.isNullOrEmpty())

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