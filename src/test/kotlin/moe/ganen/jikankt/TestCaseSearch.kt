package moe.ganen.jikankt

import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.CharacterSearchSubEntity
import moe.ganen.jikankt.models.base.types.MalSubEntity
import moe.ganen.jikankt.models.base.types.PeopleSearchSubEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseSearch {

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
    }

    @Test
    fun `test characters multiple page result`() {
        val expected = 6
        val result = runBlocking { JikanKt.searchCharacter("naruto").lastPage }

        assertEquals(expected, result)
    }

    @Test(expected = JikanException::class)
    fun `test search random character`() {
        runBlocking { JikanKt.searchCharacter("Bjir").results?.get(0) }
    }

    @Test
    fun `test search people Uesaka Sumire`() {
        val expected = PeopleSearchSubEntity(
            malId = 14441,
            name = "Sumire Uesaka"
        )

        val result = runBlocking { JikanKt.searchPeople("Sumire Uesaka").results?.get(0) }

        assertEquals(expected.malId, result?.malId)
        assertEquals(expected.name, result?.name)
    }

    @Test()
    fun `test search random people`() {
        val result = runBlocking { JikanKt.searchPeople("Bjir").results }
        assertEquals(0, result?.size)
    }
}