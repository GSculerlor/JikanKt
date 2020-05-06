package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.ClubMember
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.club.Club
import moe.ganen.jikankt.models.club.ClubMembers
import org.junit.Assert.assertEquals
import org.junit.Test

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

        runBlocking { delay(2000) }
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

        runBlocking { delay(2000) }
    }

    @Test(expected = JikanException::class)
    fun `test get bad ID club return exception`() {
        runBlocking { JikanKt.apply { restClient = RestClient(true) }.getClub(7787) }
        runBlocking { delay(2000) }
    }

    @Test
    fun `test get bad ID club`() {
        val result = runBlocking { JikanKt.apply { restClient = RestClient(false) }.getClub(7787) }

        assert(result.mangaRelations.isNullOrEmpty())
        assert(result.animeRelations.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get Takagi club member`() {
        val expected = ClubMembers(
            listOf(ClubMember("Aceless-kun"), ClubMember("Amhaz"))
        )

        val result = runBlocking { JikanKt.getClubMembers(75088) }

        assertEquals(expected.members?.get(0)?.username, result.members?.get(0)?.username)
        assertEquals(expected.members?.get(1)?.username, result.members?.get(1)?.username)

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get bad ID club members`() {
        val result = runBlocking { JikanKt.apply { restClient = RestClient(false) }.getClubMembers(7787) }

        assert(result.members.isNullOrEmpty())

        runBlocking { delay(2000) }
    }
}