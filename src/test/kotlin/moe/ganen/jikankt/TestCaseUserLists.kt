package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.base.types.AnimeListEntity
import moe.ganen.jikankt.models.base.types.MangaListEntity
import moe.ganen.jikankt.models.search.enums.AnimeStatus
import moe.ganen.jikankt.models.search.enums.MangaOrderBy
import moe.ganen.jikankt.models.search.enums.Sort
import moe.ganen.jikankt.models.user.AnimeListSearchQuery
import moe.ganen.jikankt.models.user.MangaListSearchQuery
import moe.ganen.jikankt.models.user.UserAnimeList
import moe.ganen.jikankt.models.user.UserMangaList
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseUserLists {

    @Test
    fun `test get GSculerlor anime list`() {
        val result = runBlocking { JikanKt.getUserAnimeList("GSculerlor") }
        assert(result.anime?.count() ?: 0 >= 230)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get GSculerlor manga list`() {
        val result = runBlocking { JikanKt.getUserMangaList("GSculerlor") }
        assert(result.manga.isNullOrEmpty())

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get GSculerlor anime list with query 1`() {
        val expected = UserAnimeList(
            anime = listOf(
                AnimeListEntity(
                    malId = 40591,
                    title = "Kaguya-sama wa Kokurasetai: Tensai-tachi no Renai Zunousen",
                    airingStatus = 2
                )
            )
        )

        val result = runBlocking {
            JikanKt.getUserAnimeList(
                "GSculerlor",
                "kaguya",
                additionalQuery = AnimeListSearchQuery(status = AnimeStatus.Complete)
            )
        }

        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)
        assertEquals(expected.anime?.get(0)?.airingStatus, result.anime?.get(0)?.airingStatus)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get Mizore manga list with query 1`() {
        val expected = UserMangaList(
            manga = listOf(
                MangaListEntity(
                    malId = 99949,
                    title = "Vigilante: Boku no Hero Academia Illegals"
                )
            )
        )

        val result = runBlocking {
            JikanKt.getUserMangaList(
                "Mizore",
                "Boku no Hero",
                additionalQuery = MangaListSearchQuery(sort = Sort.Ascending, orderBy1 = MangaOrderBy.Title)
            )
        }

        assertEquals(expected.manga?.get(0)?.title, result.manga?.get(0)?.title)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test get literaturenerd anime list second page`() {
        val expected = UserAnimeList(anime = listOf(AnimeListEntity(malId = 8187, title = "Fumiko no Kokuhaku")))

        val result = runBlocking { JikanKt.getUserAnimeList("literaturenerd", page = 2) }

        assertEquals(expected.anime?.get(0)?.title, result.anime?.get(0)?.title)

        runBlocking { delay(3000) }
    }
}