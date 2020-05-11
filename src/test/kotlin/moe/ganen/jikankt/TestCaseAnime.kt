package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.models.anime.*
import moe.ganen.jikankt.models.base.types.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class TestCaseAnime {

    //region getAnime

    @Test
    fun `test anime with correct ID`() {
        val expected = Anime(
            malId = 9289,
            title = "Hanasaku Iroha",
            titleJapanese = "花咲くいろは",
            titleSynonyms = null,
            status = "Finished Airing",
            aired = TimeInterval(simplifiedString = "Apr 3, 2011 to Sep 25, 2011"),
            related = RelatedAnime(adaptation = listOf(MalSubEntity(malId = 25408))),
            producers = listOf(MalSubEntity(malId = 23)),
            openingThemes = listOf("\"Hana no Iro (ハナノイロ)\" by nano.RIPE (eps 2-13)"),
            endingThemes = listOf("\"Hana no Iro (ハナノイロ)\" by nano.RIPE (ep 1)")
        )
        val result = runBlocking { JikanKt.getAnime(9289) }

        assertEquals(expected.malId, result.malId)
        assertEquals(expected.title, result.title)
        assertEquals(expected.titleJapanese, result.titleJapanese)
        assertEquals(0, result.titleSynonyms?.count())
        assertEquals(expected.status, result.status)
        assertEquals(expected.aired?.simplifiedString, result.aired?.simplifiedString)
        assertEquals(expected.related?.adaptation?.get(0)?.malId, result.related?.adaptation?.get(0)?.malId)
        assertEquals(expected.producers?.get(0)?.malId, result.producers?.get(0)?.malId)
        assertEquals(expected.openingThemes?.get(0), result.openingThemes?.get(0))
        assertEquals(expected.endingThemes?.get(0), result.endingThemes?.get(0))

        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID`() {
        val result = runBlocking { JikanKt.getAnime(2) }

        assertNull(result.title)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeCharactersStaff

    @Test
    fun `test Hanasaku Iroha characters staff`() {
        val expected = AnimeCharactersStaff(
            characters = listOf(
                Character(
                    malId = 36184,
                    name = "Matsumae, Ohana",
                    voiceActors = listOf(VoiceActor(malId = 762, name = "Itou, Kanae"))
                ),
                Character(
                    malId = 37215,
                    name = "Oshimizu, Nako",
                    voiceActors = listOf(VoiceActor(malId = 599, name = "Toyosaki, Aki"))
                )
            )
        )

        val result = runBlocking { JikanKt.getAnimeCharactersStaff(9289) }

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
    fun `test Hinamatsuri characters staff`() {
        val expected = AnimeCharactersStaff(
            characters = listOf(
                Character(
                    malId = 100043,
                    name = "Hina",
                    voiceActors = listOf(VoiceActor(malId = 47440, name = "Tanaka, Takako"))
                ),
                Character(
                    malId = 100045,
                    name = "Nitta, Yoshifumi",
                    voiceActors = listOf(VoiceActor(malId = 20096, name = "Nakajima, Yoshiki"))
                )
            )
        )

        val result = runBlocking { JikanKt.getAnimeCharactersStaff(36296) }

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
    fun `test anime with bad ID characters staff`() {
        val result = runBlocking { JikanKt.getAnimeCharactersStaff(2) }

        assertNull(result.characters)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeEpisodes

    @Test
    fun `test Just Because Episodes`() {
        val expected = AnimeEpisodes(
            episodes = listOf(
                Episode(episodeId = 1, title = "On Your Marks!"),
                Episode(episodeId = 2, title = "Question")
            )
        )
        val result = runBlocking { JikanKt.getAnimeEpisodes(35639) }

        assertEquals(12, result.episodes?.count())
        assertEquals(expected.episodes?.get(0)?.title, result.episodes?.get(0)?.title)
        assertEquals(expected.episodes?.get(1)?.title, result.episodes?.get(1)?.title)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test Kimi no Suizou wo Tabetai Episodes`() {
        val result = runBlocking { JikanKt.getAnimeEpisodes(36098) }

        assertEquals(0, result.episodes?.count())
        runBlocking { delay(3000) }
    }

    @Test
    fun `test One Piece Episodes`() {
        val expectedFirstPage = AnimeEpisodes(
            episodes = listOf(
                Episode(episodeId = 1, title = "I'm Luffy! The Man Who's Gonna Be King of the Pirates!")
            )
        )

        val resultFirstPage = runBlocking { JikanKt.getAnimeEpisodes(21) }

        assertEquals(10, resultFirstPage.lastPage)
        assertEquals(expectedFirstPage.episodes?.get(0)?.title, resultFirstPage.episodes?.get(0)?.title)

        val expectedSecondPage = AnimeEpisodes(
            episodes = listOf(
                Episode(episodeId = 101, title = "Showdown in a Heat Haze! Ace vs. the Gallant Scorpion!")
            )
        )

        val resultSecondPage = runBlocking { JikanKt.getAnimeEpisodes(21, 2) }

        assertEquals(10, resultSecondPage.lastPage)
        assertEquals(expectedSecondPage.episodes?.get(0)?.title, resultSecondPage.episodes?.get(0)?.title)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID episodes`() {
        val result = runBlocking { JikanKt.getAnimeEpisodes(2) }

        assert(result.episodes.isNullOrEmpty())
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeNews

    @Test
    fun `test Koe no Katachi news`() {
        val expected = AnimeNews(
            articles = listOf(
                Article(
                    url = "https://myanimelist.net/news/58614811",
                    intro = "Here are the North American anime & manga releases for November Week 1: November 5 - 11 Anime Releases Dragon Ball Z 30th Anniversary Collector's Edition Bl..."
                )
            )
        )
        val result = runBlocking { JikanKt.getAnimeNews(28851) }

        assertEquals(13, result.articles?.count())
        assertEquals(expected.articles?.get(0)?.url, result.articles?.get(0)?.url)
        assertEquals(expected.articles?.get(0)?.intro, result.articles?.get(0)?.intro)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID news`() {
        val result = runBlocking { JikanKt.getAnimeNews(2) }

        assertNull(result.articles)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimePictures

    @Test
    fun `test Kimi no Suizou wo Tabetai Pictures`() {
        val expected = AnimePictures(
            pictures = listOf(
                Picture(
                    "https://cdn.myanimelist.net/images/anime/11/90070l.jpg",
                    "https://cdn.myanimelist.net/images/anime/11/90070.jpg"
                )
            )
        )

        val result = runBlocking { JikanKt.getAnimePictures(36098) }

        assertEquals(4, result.pictures?.count())
        assertEquals(expected.pictures?.get(0), result.pictures?.get(0))
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID pictures`() {
        val result = runBlocking { JikanKt.getAnimePictures(2) }

        assertNull(result.pictures)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeVideo

    @Test
    fun `test Sora no Aosa wo Shiru Hito yo Video`() {
        val expected = AnimeVideos(
            promo = listOf(
                PromoVideo(
                    "Trailer 2",
                    "https://i.ytimg.com/vi/xhBQyCoE-dg/mqdefault.jpg",
                    "https://www.youtube.com/embed/xhBQyCoE-dg?enablejsapi=1&wmode=opaque&autoplay=1"
                )
            )
        )

        val result = runBlocking { JikanKt.getAnimeVideos(39569) }

        assertEquals(0, result.episodes?.count())
        assertEquals(4, result.promo?.count())
        assertEquals(expected.promo?.get(0), result.promo?.get(0))
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID video`() {
        val result = runBlocking { JikanKt.getAnimeVideos(2) }

        assertNull(result.episodes)
        assertNull(result.promo)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeStats

    @Test
    fun `test Sora no Aosa wo Shiru Hito yo Stats`() {
        val result = runBlocking { JikanKt.getAnimeStats(39569) }

        assert(result.watching in 900..950)
        assert(result.completed in 1600..1850)
        assert(result.onHold in 350..450)
        assert(result.dropped in 70..80)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID stats`() {
        val result = runBlocking { JikanKt.getAnimeStats(2) }

        assertNull(result.scorePage)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeForum

    @Test
    fun `test Konosuba Kurenai Densetsu forum`() {
        val expected = AnimeForum(
            topics = listOf(
                Topic(
                    malId = 1800323,
                    title = "Kono Subarashii Sekai ni Shukufuku wo!: Kurenai Densetsu Episode 1 Discussion"
                )
            )
        )

        val result = runBlocking { JikanKt.getAnimeForum(38040) }

        assertEquals(15, result.topics?.count())
        assertEquals(expected.topics?.get(0)?.title, result.topics?.get(0)?.title)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID forum`() {
        val result = runBlocking { JikanKt.getAnimeForum(2) }

        assertNull(result.topics)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeMoreInfo

    @Test
    fun `test Konosuba Kurenai Densetsu more info`() {
        val result = runBlocking { JikanKt.getAnimeMoreInfo(38040) }

        assertNull(result.moreInfo)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test One Piece more info`() {
        val expected =
            "Episode 492 is the second part of a two part special called Toriko x One Piece Collabo Special - a crossover with Toriko (2011).  The first part is Toriko (2011) episode 1.  The first part aired on Toriko's timeslot at 9:00 and the second part aired on One Piece's timeslot at 9:30.\r\nEpisode 542 is the second part of a two part special called Toriko x One Piece Collabo Special 2 - another crossover with Toriko (2011). The first part is Toriko (2011) episode 51. The first part aired on Toriko's timeslot at 9:00 and the second part aired on One Piece's timeslot at 9:30.\r\nEpisode 590 is the second part of a two part special called Dream 9 Toriko & One Piece & Dragon Ball Z Super Collaboration Special - a crossover with Toriko (2011) and Dragon Ball Z. The first part is Toriko (2011) episode 99. The first part aired on Toriko's timeslot at 9:00 and the second part aired on One Piece's timeslot at 9:30.\r\n(Source: AniDB)"
        val result = runBlocking { JikanKt.getAnimeMoreInfo(21) }

        assertEquals(expected, result.moreInfo)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID more info`() {
        val result = runBlocking { JikanKt.getAnimeMoreInfo(2) }

        assertNull(result.moreInfo)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeReviews

    @Test
    fun `test Nichijou reviews`() {
        val expectedFirstPage = AnimeReviews(
            reviews = listOf(
                Review(
                    malId = 44337,
                    reviewer = Reviewer(username = "Ryhzuo"),
                    content = "Conventional wisdom has always taught us that more is usually better. We think that the more expensive car should have more completely unrelated features"
                )
            )
        )
        val resultFirstPage = runBlocking { JikanKt.getAnimeReviews(10165) }

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

        val expectedSecondPage = AnimeReviews(
            reviews = listOf(
                Review(
                    malId = 54289,
                    reviewer = Reviewer(username = "dariken"),
                    content = "When I first finished this anime, I gave it 8. But I wasn't entirely honest with myself. This anime is possibly the anime I've subjectively enjoyed the most."
                )
            )
        )
        val resultSecondPage = runBlocking { JikanKt.getAnimeReviews(10165, 2) }

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
    fun `test anime with bad ID reviews`() {
        val result = runBlocking { JikanKt.getAnimeReviews(2) }

        assertNull(result.reviews)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeRecommendations

    @Test
    fun `test No Game No Life recommendations`() {
        val expected = AnimeRecommendations(
            recommendations = listOf(
                Recommendation(
                    malId = 15315,
                    title = "Mondaiji-tachi ga Isekai kara Kuru Sou Desu yo?"
                )
            )
        )
        val result = runBlocking { JikanKt.getAnimeRecommendations(19815) }

        assertEquals(expected.recommendations?.get(0)?.malId, result.recommendations?.get(0)?.malId)
        assertEquals(expected.recommendations?.get(0)?.title, result.recommendations?.get(0)?.title)
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID recommendations`() {
        val result = runBlocking { JikanKt.getAnimeRecommendations(2) }

        assertNull(result.recommendations)
        runBlocking { delay(3000) }
    }

    //endregion

    //region getAnimeUserUpdates

    @Test
    fun `test No Game No Life user updates`() {
        val resultFirstPage = runBlocking { JikanKt.getAnimeUserUpdates(19815) }

        assertEquals(75, resultFirstPage.updates?.count())

        val resultSecondPage = runBlocking { JikanKt.getAnimeUserUpdates(19815, 2) }

        assertEquals(75, resultSecondPage.updates?.count())
        runBlocking { delay(3000) }
    }

    @Test
    fun `test anime with bad ID user update`() {
        val result = runBlocking { JikanKt.getAnimeUserUpdates(2) }

        assertNull(result.updates)
        runBlocking { delay(3000) }
    }

    //endregion
}