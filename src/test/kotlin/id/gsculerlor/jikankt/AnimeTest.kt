package id.gsculerlor.jikankt

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class AnimeTest {
    @Test
    fun `Get Anime By ID`() = runBlocking {
        val animeById = JikanKtClient().getAnimeDetail(34618)
        assertEquals("Blend S", animeById?.title)
    }

    @Test
    fun `Get Episode List`() = runBlocking {

    }
}