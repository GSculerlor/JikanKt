package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.anime.MangaCharacters
import moe.ganen.jikankt.models.base.types.*
import moe.ganen.jikankt.models.manga.Manga
import moe.ganen.jikankt.models.manga.MangaNews
import moe.ganen.jikankt.models.manga.MangaRecommendations
import moe.ganen.jikankt.models.manga.MangaReviews
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class TestCaseManga {

    //region getManga

    @Test
    fun `test anime with correct ID`() {
        val expected = Manga(
            malId = 78523,
            title = "ReLIFE",
            titleJapanese = "ReLIFE",
            titleSynonyms = null,
            status = "Finished",
            published = TimeInterval(simplifiedString = "Oct  12, 2013 to Mar  16, 2018"),
            related = RelatedManga(adaptation = listOf(MalSubEntity(malId = 30015))),
            authors = listOf(MalSubEntity(malId = 33911))
        )
        val result = runBlocking { JikanKt.getManga(78523) }

        assertEquals(expected.malId, result.malId)
        assertEquals(expected.title, result.title)
        assertEquals(expected.titleJapanese, result.titleJapanese)
        assertEquals(0, result.titleSynonyms?.count())
        assertEquals(expected.status, result.status)
        assertEquals(expected.published?.simplifiedString, result.published?.simplifiedString)
        assertEquals(expected.related?.adaptation?.get(0)?.malId, result.related?.adaptation?.get(0)?.malId)
        assertEquals(expected.authors?.get(0)?.malId, result.authors?.get(0)?.malId)

        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID`() {
        val result = runBlocking { JikanKt.getManga(7218) }

        Assert.assertNull(result.title)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaCharactersStaff

    @Test
    fun `test ReLIFE characters`() {
        val expected = MangaCharacters(
            characters = listOf(
                Character(
                    malId = 127643,
                    name = "Hishiro, Chizuru"
                ),
                Character(
                    malId = 123703,
                    name = "Kaizaki, Arata"
                )
            )
        )

        val result = runBlocking { JikanKt.getMangaCharacters(78523) }

        val firstExpected = expected.characters?.get(0)
        val firstResult = result.characters?.get(0)
        assertEquals(firstExpected?.malId, firstResult?.malId)
        assertEquals(firstExpected?.name, firstResult?.name)
        assertEquals(firstExpected?.voiceActors?.get(0)?.name, firstResult?.voiceActors?.get(0)?.name)

        val secondExpected = expected.characters?.get(1)
        val secondResult = result.characters?.get(1)
        assertEquals(secondExpected?.malId, secondResult?.malId)
        assertEquals(secondExpected?.name, secondResult?.name)
        assertEquals(secondExpected?.voiceActors?.get(0)?.name, secondResult?.voiceActors?.get(0)?.name)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID characters`() {
        val result = runBlocking { JikanKt.getMangaCharacters(7218) }

        Assert.assertNull(result.characters)
        runBlocking { delay(3000) }
    }

    //endregion


    //region getAnimeNews

    @Test
    fun `test ReLIFE news`() {
        val expected = MangaNews(
            articles = listOf(
                Article(
                    url = "https://myanimelist.net/news/44004599",
                    intro = "In this thread, you'll find a comprehensive list of anime and manga licensed in the first quarter (Jan-Mar) of 2016. Winter anime which were licensed before the..."
                )
            )
        )
        val result = runBlocking { JikanKt.getMangaNews(78523) }

        assertEquals(2, result.articles?.count())
        assertEquals(expected.articles?.get(0)?.url, result.articles?.get(0)?.url)
        assertEquals(expected.articles?.get(0)?.intro, result.articles?.get(0)?.intro)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID news`() {
        val result = runBlocking { JikanKt.getMangaNews(7181) }

        assert(result.articles.isNullOrEmpty())
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaPictures

    @Test
    fun `test get Solo Leveling picture`() {
        val expected = listOf(
            Picture(
                "https://cdn.myanimelist.net/images/manga/3/222295l.jpg",
                "https://cdn.myanimelist.net/images/manga/3/222295.jpg"
            ),
            Picture(
                "https://cdn.myanimelist.net/images/manga/1/227594l.jpg",
                "https://cdn.myanimelist.net/images/manga/1/227594.jpg"
            )
        )

        val result = runBlocking { JikanKt.getMangaPictures(121496) }

        assertEquals(expected, result.pictures)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID pictures`() {
        val result = runBlocking { JikanKt.getMangaPictures(7218) }

        Assert.assertNull(result.pictures)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaStats

    @Test
    fun `test Solo Leveling Stats`() {
        val result = runBlocking { JikanKt.getMangaStats(121496) }

        assert(result.reading in 45000..55000)
        assert(result.completed in 6000..7500)
        assert(result.onHold in 1500..2500)
        assert(result.dropped in 700..800)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID stats`() {
        val result = runBlocking { JikanKt.getMangaStats(7218) }

        Assert.assertNull(result.scorePage)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaForum

    @Test
    fun `test Ookami to Koushinryou forum`() {
        val result = runBlocking { JikanKt.getMangaForum(9115) }

        assertEquals(15, result.topics?.count())
        assert(result.topics?.get(0)?.malId != null)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID forum`() {
        val result = runBlocking { JikanKt.getMangaForum(7218) }

        Assert.assertNull(result.topics)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaMoreInfo

    @Test
    fun `test Metro Survive more info`() {
        val result = runBlocking { JikanKt.getAnimeMoreInfo(7181) }

        Assert.assertNull(result.moreInfo)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test Koe no Katachi more info`() {
        val expected = "Volume 1 contains the side story \"7-kagetsu Mae\" (7か月前)."
        val result = runBlocking { JikanKt.getMangaMoreInfo(56805) }

        assert(result.moreInfo?.contains(expected) ?: false)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID more info`() {
        val result = runBlocking { JikanKt.getMangaMoreInfo(7218) }

        Assert.assertNull(result.moreInfo)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaReviews

    @Test
    fun `test Tower of God reviews`() {
        val expectedFirstPage = MangaReviews(
            reviews = listOf(
                Review(
                    malId = 321944,
                    reviewer = Reviewer(username = "Wasakanene"),
                    content = "I've been waiting for this on MAL for so long and now it's finally here, I can finally put it on my list of one of my favorite Manhwas."
                )
            )
        )
        val resultFirstPage = runBlocking { JikanKt.getMangaReviews(122663) }

        assertEquals(expectedFirstPage.reviews?.get(0)?.malId, resultFirstPage.reviews?.get(0)?.malId)
        assertEquals(
            expectedFirstPage.reviews?.get(0)?.reviewer?.username,
            resultFirstPage.reviews?.get(0)?.reviewer?.username
        )
        assert(
            resultFirstPage.reviews?.get(0)?.content?.contains(
                expectedFirstPage.reviews?.get(0)?.content.toString(),
                false
            ) ?: false
        )

        val expectedSecondPage = MangaReviews(
            reviews = listOf(
                Review(
                    malId = 334986,
                    reviewer = Reviewer(username = "Xknightking"),
                    content = "First time writing a full review, so hopefully this goes well."
                )
            )
        )
        val resultSecondPage = runBlocking { JikanKt.getMangaReviews(122663, 2) }

        assertEquals(expectedSecondPage.reviews?.get(0)?.malId, resultSecondPage.reviews?.get(0)?.malId)
        assertEquals(
            expectedSecondPage.reviews?.get(0)?.reviewer?.username,
            resultSecondPage.reviews?.get(0)?.reviewer?.username
        )
        assert(
            resultSecondPage.reviews?.get(0)?.content?.contains(
                expectedSecondPage.reviews?.get(0)?.content.toString(),
                false
            ) ?: false
        )
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID reviews`() {
        val result = runBlocking { JikanKt.getMangaReviews(7218) }

        Assert.assertNull(result.reviews)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaRecommendations

    @Test
    fun `test Overlord recommendations`() {
        val expected = MangaRecommendations(
            recommendations = listOf(
                Recommendation(
                    malId = 44347,
                    title = "One Punch-Man"
                )
            )
        )
        val result = runBlocking { JikanKt.getMangaRecommendations(81669) }

        assertEquals(expected.recommendations?.get(0)?.malId, result.recommendations?.get(0)?.malId)
        assertEquals(expected.recommendations?.get(0)?.title, result.recommendations?.get(0)?.title)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID recommendations`() {
        val result = runBlocking { JikanKt.getMangaRecommendations(7218) }

        Assert.assertNull(result.recommendations)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getMangaUserUpdates

    @Test
    fun `test Monster user updates`() {
        val resultFirstPage = runBlocking { JikanKt.getMangaUserUpdates(1) }

        assertEquals(75, resultFirstPage.updates?.count())

        val resultSecondPage = runBlocking { JikanKt.getMangaUserUpdates(1, 2) }

        assertEquals(75, resultSecondPage.updates?.count())
        runBlocking { delay(3000) }
    }

    @Test
    fun `test manga with bad ID user update`() {
        val result = runBlocking { JikanKt.getMangaUserUpdates(7218) }

        Assert.assertNull(result.updates)
        runBlocking { delay(3000) }
    }

    //endregion
}