package id.gsculerlor.jikankt

import id.gsculerlor.jikankt.main.anime.Anime
import junit.framework.Assert.assertEquals
import org.junit.Test

class AnimeTest {
    @Test
    fun getAnime() {
        val animeById = Anime().anime(34618)
        assertEquals("Blend S", animeById?.title)

        val animeByTitle = Anime().anime("Blend S")
        assertEquals("Blend S", animeByTitle?.title)
    }

    @Test
    fun getAnimeEpisode() {
        val animeById = Anime().episodes(34618, 0)
        assertEquals("I Love You!", animeById?.get(11)?.title)
    }
}