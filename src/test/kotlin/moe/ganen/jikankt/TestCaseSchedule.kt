package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.schedule.Day
import moe.ganen.jikankt.models.schedule.Schedule
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseSchedule {

    @Test
    fun `test get current schedule`() {
        val expected = Schedule(
            monday = listOf(AnimeSubEntity(malId = 38843, title = "Shironeko Project: Zero Chronicle")),
            tuesday = listOf(AnimeSubEntity(malId = 34572, title = "Black Clover")),
            wednesday = listOf(AnimeSubEntity(malId = 37403, title = "Ahiru no Sora")),
            thursday = listOf(AnimeSubEntity(malId = 40221, title = "Kami no Tou")),
            friday = listOf(AnimeSubEntity(malId = 38481, title = "Toaru Kagaku no Railgun T")),
            saturday = listOf(
                AnimeSubEntity(
                    malId = 40591,
                    title = "Kaguya-sama wa Kokurasetai?: Tensai-tachi no Renai Zunousen"
                )
            ),
            sunday = listOf(AnimeSubEntity(malId = 21, title = "One Piece"))
        )

        val result = runBlocking { JikanKt.getSchedule() }

        assertEquals(expected.monday?.get(0)?.title, result.monday?.get(0)?.title)
        assertEquals(expected.tuesday?.get(0)?.title, result.tuesday?.get(0)?.title)
        assertEquals(expected.wednesday?.get(0)?.title, result.wednesday?.get(0)?.title)
        assertEquals(expected.thursday?.get(0)?.title, result.thursday?.get(0)?.title)
        assertEquals(expected.friday?.get(0)?.title, result.friday?.get(0)?.title)
        assertEquals(expected.saturday?.get(0)?.title, result.saturday?.get(0)?.title)
        assertEquals(expected.sunday?.get(0)?.title, result.sunday?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get friday schedule`() {
        val expected = Schedule(
            friday = listOf(AnimeSubEntity(malId = 38481, title = "Toaru Kagaku no Railgun T"))
        )

        val result = runBlocking { JikanKt.getSchedule(Day.FRIDAY) }

        assert(expected.monday.isNullOrEmpty())
        assert(expected.tuesday.isNullOrEmpty())
        assert(expected.wednesday.isNullOrEmpty())
        assert(expected.thursday.isNullOrEmpty())
        assertEquals(expected.friday?.get(0)?.title, result.friday?.get(0)?.title)
        assert(expected.saturday.isNullOrEmpty())
        assert(expected.sunday.isNullOrEmpty())

        runBlocking { delay(3000) }
    }
}