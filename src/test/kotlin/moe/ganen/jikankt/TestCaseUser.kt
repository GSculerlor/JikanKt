package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.exception.JikanException
import moe.ganen.jikankt.models.user.User
import moe.ganen.jikankt.models.user.enums.HistoryType
import org.junit.Assert.assertEquals
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.*

class TestCaseUser {

    @Test
    fun `test get GSculerlor profile`() {
        val expected =
            User(
                userId = 4616204,
                username = "GSculerlor",
                joined = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").apply { timeZone = TimeZone.getTimeZone("UTC") }
                    .parse("2015-05-15T00:00:00+00:00")
            )

        val result = runBlocking { JikanKt.getUser("GSculerlor") }

        assertEquals(expected.userId, result.userId)
        assertEquals(expected.username, result.username)
        assertEquals(expected.joined, result.joined)

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get GSculerlor anime history`() {
        val result = runBlocking { JikanKt.getUserHistory("GSculerlor", HistoryType.Anime) }
        assert(!result.histories.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get GSculerlor all history`() {
        val result = runBlocking { JikanKt.getUserHistory("GSculerlor", HistoryType.All) }
        assert(!result.histories.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get GSculerlor manga history`() {
        val result = runBlocking { JikanKt.getUserHistory("GSculerlor", HistoryType.Manga) }
        assert(result.histories.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get GSculerlor friends`() {
        val result = runBlocking { JikanKt.getUserFriends("GSculerlor") }
        assert(!result.friends.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test
    fun `test get mizore manga history`() {
        val result = runBlocking { JikanKt.getUserHistory("Mizore", HistoryType.Manga) }
        assert(!result.histories.isNullOrEmpty())

        runBlocking { delay(2000) }
    }

    @Test(expected = JikanException::class)
    fun `test get bjir123 profile throw exception`() {
        runBlocking { JikanKt.apply { restClient = RestClient(true) }.getUser("bjir123") }
        runBlocking { delay(2000) }
    }

    @Test
    fun `test get bjir123 profile`() {
        val result = runBlocking { JikanKt.apply { restClient = RestClient(false) }.getUser("bjir123") }

        assert(result.username.isNullOrEmpty())
        runBlocking { delay(2000) }
    }
}