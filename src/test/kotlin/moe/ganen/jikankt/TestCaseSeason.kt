package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.base.types.AnimeSubEntity
import moe.ganen.jikankt.models.season.Season
import moe.ganen.jikankt.models.season.SeasonType
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseSeason {

    @Test
    fun `test get archived season`() {
        val result = runBlocking { JikanKt.getSeasonArchive() }

        assert(result.archive?.first()?.year == 2020)
        assert(result.archive?.first()?.seasons?.count() == 4)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get current season`() {
        val expected = Season(
            seasonName = "Spring",
            seasonYear = 2020,
            anime = listOf(
                AnimeSubEntity(
                    malId = 40591,
                    title = "Kaguya-sama wa Kokurasetai?: Tensai-tachi no Renai Zunousen"
                )
            )
        )

        val result = runBlocking { JikanKt.getSeason() }

        assertEquals(expected.seasonName, result.seasonName)
        assertEquals(expected.seasonYear, result.seasonYear)
        assertEquals(expected.anime?.get(0)?.malId, result.anime?.get(0)?.malId)
        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get summer 2015 season`() {
        val expected = Season(
            seasonName = "Summer",
            seasonYear = 2015,
            anime = listOf(
                AnimeSubEntity(
                    malId = 28999,
                    title = "Charlotte"
                )
            )
        )

        val result = runBlocking { JikanKt.getSeason(2015, SeasonType.SUMMER) }

        assertEquals(expected.seasonName, result.seasonName)
        assertEquals(expected.seasonYear, result.seasonYear)
        assertEquals(expected.anime?.get(0)?.malId, result.anime?.get(1)?.malId)
        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(1)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get summer 2015 season but missing param then return current season instead`() {
        val expected = Season(
            seasonName = "Spring",
            seasonYear = 2020,
            anime = listOf(
                AnimeSubEntity(
                    malId = 40591,
                    title = "Kaguya-sama wa Kokurasetai?: Tensai-tachi no Renai Zunousen"
                )
            )
        )

        val result = runBlocking { JikanKt.getSeason(2015) }

        assertEquals(expected.seasonName, result.seasonName)
        assertEquals(expected.seasonYear, result.seasonYear)
        assertEquals(expected.anime?.get(0)?.malId, result.anime?.get(0)?.malId)
        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get later season`() {

        val result = runBlocking { JikanKt.getSeasonLater() }

        assert(result.anime?.isNotEmpty() ?: false)

        runBlocking { delay(3000) }
    }
}