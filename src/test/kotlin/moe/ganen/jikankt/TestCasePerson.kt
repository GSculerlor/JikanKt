package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.base.types.Picture
import moe.ganen.jikankt.models.person.Person
import moe.ganen.jikankt.models.person.PersonPictures
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class TestCasePerson {

    @Test
    fun `test get Uesaka Sumire`() {
        val expected = Person(
            malId = 14441,
            name = "Sumire Uesaka",
            givenName = "すみれ",
            about = "Birth place: Kanagawa Prefecture, Japan\\\\n\\r\\nBlood type: O\\\\n\\\\n\\r\\nUesaka Sumire is a voice actress currently affiliated with Space Craft Entertainment."
        )

        val result = runBlocking { JikanKt.getPerson(14441) }

        assertEquals(expected.malId, result.malId)
        assertEquals(expected.name, result.name)
        assertEquals(expected.givenName, result.givenName)
        assert(result.about?.contains(result.about.toString(), false) ?: false)
        assert(result.alternativeNames.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get person with bad ID`() {
        val result = runBlocking {
            JikanKt.apply { restClient = RestClient(false, url = "http://ganen.moe:8800/v3/") }.getPerson(13308)
        }

        assert(result.name.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get person with bad ID then throw exception`() {
        assertThrows<JikanException> {
            runBlocking {
                JikanKt.apply { restClient = RestClient(true, url = "http://ganen.moe:8800/v3/") }.getPerson(13308)

            }
        }

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get Uesaka Sumire pictures`() {
        val expected = PersonPictures(
            pictures = listOf(
                Picture(
                    "https://cdn.myanimelist.net/images/voiceactors/2/16377.jpg",
                    "https://cdn.myanimelist.net/images/voiceactors/2/16377.jpg"
                ),
                Picture(
                    "https://cdn.myanimelist.net/images/voiceactors/3/18177.jpg",
                    "https://cdn.myanimelist.net/images/voiceactors/3/18177.jpg"
                ),
                Picture(
                    "https://cdn.myanimelist.net/images/voiceactors/1/28133.jpg",
                    "https://cdn.myanimelist.net/images/voiceactors/1/28133.jpg"
                )
            )
        )

        val result = runBlocking { JikanKt.getPersonPictures(14441) }

        for (i in 0..2) {
            assertEquals(expected.pictures?.get(i), result.pictures?.get(i))
        }

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get person picture with bad ID`() {
        val result = runBlocking {
            JikanKt.apply { restClient = RestClient(false, url = "http://ganen.moe:8800/v3/") }.getPersonPictures(13308)
        }

        assert(result.pictures.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get person picture with bad ID then throw exception`() {
        assertThrows<JikanException> {
            runBlocking {
                JikanKt.apply { restClient = RestClient(true, url = "http://ganen.moe:8800/v3/") }
                    .getPersonPictures(13308)
            }
        }

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