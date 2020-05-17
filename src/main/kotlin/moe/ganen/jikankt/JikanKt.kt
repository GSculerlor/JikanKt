package moe.ganen.jikankt

import com.google.gson.GsonBuilder
import moe.ganen.jikankt.connection.RestClient
import moe.ganen.jikankt.models.anime.*
import moe.ganen.jikankt.models.base.Entity
import moe.ganen.jikankt.models.character.CharacterPictures
import moe.ganen.jikankt.models.club.Club
import moe.ganen.jikankt.models.club.ClubMembers
import moe.ganen.jikankt.models.genre.Genre
import moe.ganen.jikankt.models.genre.RequestType
import moe.ganen.jikankt.models.manga.*
import moe.ganen.jikankt.models.person.Person
import moe.ganen.jikankt.models.person.PersonPictures
import moe.ganen.jikankt.models.prod.Magazine
import moe.ganen.jikankt.models.prod.Producer
import moe.ganen.jikankt.models.schedule.Day
import moe.ganen.jikankt.models.schedule.Schedule
import moe.ganen.jikankt.models.search.*
import moe.ganen.jikankt.models.season.Season
import moe.ganen.jikankt.models.season.SeasonArchives
import moe.ganen.jikankt.models.season.SeasonType
import moe.ganen.jikankt.models.top.*
import moe.ganen.jikankt.models.user.*
import moe.ganen.jikankt.models.user.enums.AnimeStatusType
import moe.ganen.jikankt.models.user.enums.HistoryType
import moe.ganen.jikankt.models.user.enums.MangaStatusType
import moe.ganen.jikankt.utils.InterfaceAdapter
import moe.ganen.jikankt.utils.deserialize

object JikanKt {

    var restClient = RestClient()
    private val gson = GsonBuilder().registerTypeAdapter(Entity::class.java, InterfaceAdapter<Entity>()).create()


    //region Anime

    /**
     * Function to get anime by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return Anime with given MyAnimeList id.
     */
    suspend fun getAnime(id: Int): Anime = gson.deserialize(restClient.request("anime/$id"), Anime::class.java)

    /**
     * Function to get anime's characters and staff by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of characters and staff of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeCharactersStaff(id: Int): AnimeCharactersStaff =
        gson.deserialize(restClient.request("anime/$id/characters_staff"), AnimeCharactersStaff::class.java)

    /**
     * Function to get anime's episodes by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 50 episode entity.
     * @return List of characters and staff of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeEpisodes(id: Int, page: Int? = 1): AnimeEpisodes =
        gson.deserialize(restClient.request("anime/$id/episodes/$page"), AnimeEpisodes::class.java)

    /**
     * Function to get anime's news by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of articles related to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeNews(id: Int): AnimeNews =
        gson.deserialize(restClient.request("anime/$id/news"), AnimeNews::class.java)

    /**
     * Function to get anime's pictures by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of pictures to the anime with given MyAnimeList id.
     */
    suspend fun getAnimePictures(id: Int): AnimePictures =
        gson.deserialize(restClient.request("anime/$id/pictures"), AnimePictures::class.java)

    /**
     * Function to get anime's videos by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of videos to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeVideos(id: Int): AnimeVideos =
        gson.deserialize(restClient.request("anime/$id/videos"), AnimeVideos::class.java)

    /**
     * Function to get anime's stats by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return Statistics to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeStats(id: Int): AnimeStats =
        gson.deserialize(restClient.request("anime/$id/stats"), AnimeStats::class.java)

    /**
     * Function to get anime's forum by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of topics to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeForum(id: Int): AnimeForum =
        gson.deserialize(restClient.request("anime/$id/forum"), AnimeForum::class.java)

    /**
     * Function to get anime's more info by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return Anime's more info in string, if any.
     */
    suspend fun getAnimeMoreInfo(id: Int): AnimeMoreInfo =
        gson.deserialize(restClient.request("anime/$id/moreinfo"), AnimeMoreInfo::class.java)

    /**
     * Function to get anime's reviews by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 20 items.
     * @return List of reviews of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeReviews(id: Int, page: Int? = 1): AnimeReviews =
        gson.deserialize(restClient.request("anime/$id/reviews/$page"), AnimeReviews::class.java)

    /**
     * Function to get anime's recommendations by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @return List of recommendations to the anime with given MyAnimeList id.
     */
    suspend fun getAnimeRecommendations(id: Int): AnimeRecommendations =
        gson.deserialize(restClient.request("anime/$id/recommendations"), AnimeRecommendations::class.java)

    /**
     * Function to get anime's user updates by it's MyAnimeList id
     * @param id: MyAnimeList id of the anime.
     * @param page: Optional, default is 1. Index of page, each page contain 75 items.
     * @return List of user updates of the anime with given MyAnimeList id.
     */
    suspend fun getAnimeUserUpdates(id: Int, page: Int? = 1): AnimeUserUpdates =
        gson.deserialize(restClient.request("anime/$id/userupdates/$page"), AnimeUserUpdates::class.java)

    //endregion

    //region Manga

    /**
     * Function to get manga by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return Manga with given MyAnimeList id.
     */
    suspend fun getManga(id: Int): Manga = gson.deserialize(restClient.request("manga/$id"), Manga::class.java)

    /**
     * Function to get manga's characters by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return List of characters and staff of the manga with given MyAnimeList id.
     */
    suspend fun getMangaCharacters(id: Int): MangaCharacters =
        gson.deserialize(restClient.request("manga/$id/characters"), MangaCharacters::class.java)

    /**
     * Function to get manga's news by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return List of articles related to the manga with given MyAnimeList id.
     */
    suspend fun getMangaNews(id: Int): MangaNews =
        gson.deserialize(restClient.request("manga/$id/news"), MangaNews::class.java)

    /**
     * Function to get manga's pictures by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return List of pictures to the manga with given MyAnimeList id.
     */
    suspend fun getMangaPictures(id: Int): MangaPictures =
        gson.deserialize(restClient.request("manga/$id/pictures"), MangaPictures::class.java)

    /**
     * Function to get manga's stats by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return Statistics to the manga with given MyAnimeList id.
     */
    suspend fun getMangaStats(id: Int): MangaStats =
        gson.deserialize(restClient.request("manga/$id/stats"), MangaStats::class.java)

    /**
     * Function to get manga's forum by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return List of topics to the manga with given MyAnimeList id.
     */
    suspend fun getMangaForum(id: Int): MangaForum =
        gson.deserialize(restClient.request("manga/$id/forum"), MangaForum::class.java)

    /**
     * Function to get manga's more info by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return Manga's more info in string, if any.
     */
    suspend fun getMangaMoreInfo(id: Int): MangaMoreInfo =
        gson.deserialize(restClient.request("manga/$id/moreinfo"), MangaMoreInfo::class.java)

    /**
     * Function to get manga's reviews by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @param page: Optional, default is 1. Index of page, each page contain 20 items.
     * @return List of reviews of the manga with given MyAnimeList id.
     */
    suspend fun getMangaReviews(id: Int, page: Int? = 1): MangaReviews =
        gson.deserialize(restClient.request("manga/$id/reviews/$page"), MangaReviews::class.java)

    /**
     * Function to get manga's recommendations by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @return List of recommendations to the manga with given MyAnimeList id.
     */
    suspend fun getMangaRecommendations(id: Int): MangaRecommendations =
        gson.deserialize(restClient.request("manga/$id/recommendations"), MangaRecommendations::class.java)

    /**
     * Function to get manga's user updates by it's MyAnimeList id
     * @param id: MyAnimeList id of the manga.
     * @param page: Optional, default is 1. Index of page, each page contain 75 items.
     * @return List of user updates of the manga with given MyAnimeList id.
     */
    suspend fun getMangaUserUpdates(id: Int, page: Int? = 1): MangaUserUpdates =
        gson.deserialize(restClient.request("manga/$id/userupdates/$page"), MangaUserUpdates::class.java)

    //endregion

    //region People

    /**
     * Function to get person by it's MyAnimeList id
     * @param id: MyAnimeList id of the person.
     * @return Person with given MyAnimeList id.
     */
    suspend fun getPerson(id: Int): Person = gson.deserialize(restClient.request("person/$id"), Person::class.java)

    /**
     * Function to get person's pictures by it's MyAnimeList id
     * @param id: MyAnimeList id of the person.
     * @return List of pictures of the person with given MyAnimeList id.
     */
    suspend fun getPersonPictures(id: Int): PersonPictures =
        gson.deserialize(restClient.request("person/$id/pictures"), PersonPictures::class.java)

    //endregion

    //region Characters

    /**
     * Function to get character by it's MyAnimeList id
     * @param id: MyAnimeList id of the character.
     * @return Character with given MyAnimeList id.
     */
    suspend fun getCharacter(id: Int): moe.ganen.jikankt.models.character.Character =
        gson.deserialize(restClient.request("character/$id"), moe.ganen.jikankt.models.character.Character::class.java)

    /**
     * Function to get character's pictures by it's MyAnimeList id
     * @param id: MyAnimeList id of the character.
     * @return List of pictures of the character with given MyAnimeList id.
     */
    suspend fun getCharacterPictures(id: Int): CharacterPictures =
        gson.deserialize(restClient.request("character/$id/pictures"), CharacterPictures::class.java)

    //endregion

    //region Season

    /**
     * Function to get anime list by it's season.
     * NOTE: If year and/or season is not specified, it'll return current season instead.
     * @param year: Year of the season.
     * @param season: season type (winter, spring, etc).
     * @return List of anime that airing on that season.
     */
    suspend fun getSeason(year: Int? = null, season: SeasonType? = null): Season {
        val query = if (year != null && season != null && season != SeasonType.All) "$year/${season.name.toLowerCase()}" else ""

        return gson.deserialize(restClient.request("season/$query"), Season::class.java)
    }

    /**
     * Function to get archived season on MyAnimeList.
     * @return List of archived season.
     */
    suspend fun getSeasonArchive(): SeasonArchives =
        gson.deserialize(restClient.request("season/archive"), SeasonArchives::class.java)

    /**
     * Function to get later season anime list.
     * @return List of anime that airing on next season.
     */
    suspend fun getSeasonLater(): Season =
        gson.deserialize(restClient.request("season/later"), Season::class.java)

    //endregion

    //region Schedule

    /**
     * Function to get all anime schedule in this season.
     * @return List of day consist of anime list that airing on that day.
     */
    suspend fun getSchedule(): Schedule =
        gson.deserialize(restClient.request("schedule"), Schedule::class.java)

    /**
     * Function to get all anime schedule in this season filtered by day.
     * @return List of anime that airing on that day.
     */
    suspend fun getSchedule(day: Day): Schedule =
        gson.deserialize(restClient.request("schedule/${day.name.toLowerCase()}"), Schedule::class.java)

    //endregion

    //region Top

    /**
     * Function to get all top anime on MyAnimeList.
     * @param subtype: Optional, subtype type (upcoming, airing, etc).
     * @param page: Optional, default is 1. Index of page, each page contain 50 items.
     * @return List of top anime on MyAnimeList.
     */
    suspend fun getTopAnime(page: Int? = 1, subtype: TopSubtype? = TopSubtype.NONE): TopAnime =
        gson.deserialize(
            restClient.request("top/anime/$page/${if (subtype == TopSubtype.NONE) "" else subtype?.name?.toLowerCase()}"),
            TopAnime::class.java
        )

    /**
     * Function to get all top manga on MyAnimeList.
     * @param page: Optional, default is 1. Index of page, each page contain 50 items.
     * @param subtype: Optional, subtype type (novel, manga, etc).
     * @return List of top manga on MyAnimeList.
     */
    suspend fun getTopManga(page: Int? = 1, subtype: TopSubtype? = TopSubtype.NONE): TopManga =
        gson.deserialize(
            restClient.request("top/manga/$page/${if (subtype == TopSubtype.NONE) "" else subtype?.name?.toLowerCase()}"),
            TopManga::class.java
        )

    /**
     * Function to get all top characters on MyAnimeList.
     * @param page: Optional, default is 1. Index of page, each page contain 50 items.
     * @return List of top characters on MyAnimeList.
     */
    suspend fun getTopCharacters(page: Int? = 1): TopCharacters =
        gson.deserialize(
            restClient.request("top/characters/$page"),
            TopCharacters::class.java
        )

    /**
     * Function to get all top people on MyAnimeList.
     * @param page: Optional, default is 1. Index of page, each page contain 50 items.
     * @return List of top people on MyAnimeList.
     */
    suspend fun getTopPeople(page: Int? = 1): TopPeople =
        gson.deserialize(
            restClient.request("top/people/$page"),
            TopPeople::class.java
        )

    //endregion

    //region Genre

    /**
     * Function to get genre detail on MyAnimeList.
     * @param requestType: Request type (anime, manga).
     * @param genreId: Genre ID from MyAnimeList.
     * @param page: Optional, default is 1. Index of page.
     * @return Genre detail on MyAnimeList with list of anime/manga on that genre, paginated.
     */
    suspend fun getGenreType(requestType: RequestType, genreId: Int, page: Int? = 1): Genre =
        gson.deserialize(
            restClient.request("genre/${requestType.name.toLowerCase()}/$genreId/$page"),
            Genre::class.java
        )

    //endregion

    //region Producer

    /**
     * Function to get list of anime based on their producer.
     * @param producerId: Producer ID from MyAnimeList.
     * @param page: Optional, default is 1. Index of page.
     * @return Metadata and anime list of that producer.
     */
    suspend fun getProducer(producerId: Int, page: Int? = 1): Producer =
        gson.deserialize(
            restClient.request("producer/$producerId/$page"),
            Producer::class.java
        )

    //endregion

    //region Magazine

    /**
     * Function to get list of manga based on their magazine/serializer/publisher.
     * @param magazineId: Magazine ID from MyAnimeList.
     * @param page: Optional, default is 1. Index of page.
     * @return Metadata and anime list of that magazine/serializer/publisher.
     */
    suspend fun getMagazine(magazineId: Int, page: Int? = 1): Magazine =
        gson.deserialize(
            restClient.request("magazine/$magazineId/$page"),
            Magazine::class.java
        )

    //endregion

    //region Club

    /**
     * A single club object with all its details.
     * @param clubId: Club ID from MyAnimeList.
     * @return Club details.
     */
    suspend fun getClub(clubId: Int): Club =
        gson.deserialize(
            restClient.request("club/$clubId"),
            Club::class.java
        )

    /**
     * Fetches list of club members.
     * @param clubId: Club ID from MyAnimeList.
     * @param page: Optional, default is 1. Index of page.
     * @return list of club members.
     */
    suspend fun getClubMembers(clubId: Int, page: Int? = 1): ClubMembers =
        gson.deserialize(
            restClient.request("club/$clubId/members/$page"),
            ClubMembers::class.java
        )

    //endregion

    //region Search

    //region Anime

    /**
     * Search results for the query.
     * NOTE: MyAnimeList only processes queries with a minimum of 3 letters.
     * @param query: String that will be the query. For UTF8 characters, percentage encoded and queries including back slashes
     * @param page: Optional, default is 1. Index of page.
     * @param additionalQuery: Optional, additional query.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchAnime(
        query: String,
        additionalQuery: AnimeSearchQuery? = null,
        page: Int? = 1
    ): AnimeSearchResult {
        val formattedQuery = query.replace(" ", "%20")
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""

        return gson.deserialize(
            restClient.request("search/anime/$page?q=$formattedQuery$formattedAdditionalQuery"),
            AnimeSearchResult::class.java
        )
    }

    /**
     * Search results for the query.
     * @param page: Optional, default is 1. Index of page.
     * @param additionalQuery: Optional, additional query.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchAnime(
        additionalQuery: AnimeSearchQuery? = null,
        page: Int? = 1
    ): AnimeSearchResult {
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""

        return gson.deserialize(
            restClient.request("search/anime/$page?$formattedAdditionalQuery"),
            AnimeSearchResult::class.java
        )
    }

    //endregion

    //region Manga

    /**
     * Search results for the query.
     * NOTE: MyAnimeList only processes queries with a minimum of 3 letters.
     * @param query: String that will be the query. For UTF8 characters, percentage encoded and queries including back slashes
     * @param page: Optional, default is 1. Index of page.
     * @param additionalQuery: Optional, additional query.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchManga(
        query: String,
        additionalQuery: MangaSearchQuery? = null,
        page: Int? = 1
    ): MangaSearchResult {
        val formattedQuery = query.replace(" ", "%20")
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""

        return gson.deserialize(
            restClient.request("search/manga/$page?q=$formattedQuery$formattedAdditionalQuery"),
            MangaSearchResult::class.java
        )
    }

    /**
     * Search results for the query.
     * @param page: Optional, default is 1. Index of page.
     * @param additionalQuery: Optional, additional query.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchManga(
        additionalQuery: MangaSearchQuery? = null,
        page: Int? = 1
    ): MangaSearchResult {
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""

        return gson.deserialize(
            restClient.request("search/manga/$page?$formattedAdditionalQuery"),
            MangaSearchResult::class.java
        )
    }

    //endregion

    //region Characters

    /**
     * Search results for the query.
     * NOTE: MyAnimeList only processes queries with a minimum of 3 letters.
     * @param query: String that will be the query. For UTF8 characters, percentage encoded and queries including back slashes
     * @param page: Optional, default is 1. Index of page.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchCharacter(
        query: String,
        page: Int? = 1
    ): CharacterSearchResult {
        val formattedQuery = query.replace(" ", "%20")

        return gson.deserialize(
            restClient.request("search/character/$page?q=$formattedQuery"),
            CharacterSearchResult::class.java
        )
    }

    //endregion

    //region People

    /**
     * Search results for the query.
     * NOTE: MyAnimeList only processes queries with a minimum of 3 letters.
     * @param query: String that will be the query. For UTF8 characters, percentage encoded and queries including back slashes
     * @param page: Optional, default is 1. Index of page.
     * @return list of anime that satisfy all the queries.
     */
    suspend fun searchPeople(
        query: String,
        page: Int? = 1
    ): PeopleSearchResult {
        val formattedQuery = query.replace(" ", "%20")

        return gson.deserialize(
            restClient.request("search/people/$page?q=$formattedQuery"),
            PeopleSearchResult::class.java
        )
    }

    //endregion

    //endregion

    //region User

    /**
     * Fetches MyAnimeList user related data.
     * Note: About is returned in HTML as MyAnimeList allows custom "about" sections for users that can consist of images,
     * formatting, etc.
     * @param username: User's username on MyAnimeList.
     * @return User's profile data.
     */
    suspend fun getUser(username: String): User = gson.deserialize(
        restClient.request("user/$username/"),
        User::class.java
    )

    /**
     * Fetches MyAnimeList user's history.
     * @param username: User's username on MyAnimeList.
     * @param type: History type (Anime, manga).
     * @return User's profile data.
     */
    suspend fun getUserHistory(username: String, type: HistoryType = HistoryType.All): UserHistory = gson.deserialize(
        restClient.request("user/$username/history/${if (type != HistoryType.All) type.name.toLowerCase() else ""}"),
        UserHistory::class.java
    )

    /**
     * Fetches MyAnimeList user's friend.
     * @param username: User's username on MyAnimeList.
     * @param page: Optional, default is 1. Index of page.
     * @return User's profile data.
     */
    suspend fun getUserFriends(username: String, page: Int = 1): UserFriends = gson.deserialize(
        restClient.request("user/$username/friends/$page"),
        UserFriends::class.java
    )

    /**
     * Fetches MyAnimeList user's anime list.
     * @param username: User's username on MyAnimeList.
     * @param filter: Optional, filter list.
     * @param page: Optional, default is 1. Index of page.
     * @return User's anime list.
     */
    suspend fun getUserAnimeList(
        username: String,
        filter: AnimeStatusType = AnimeStatusType.All,
        page: Int = 1
    ): UserAnimeList = gson.deserialize(
        restClient.request("user/$username/animelist/${filter.name.toLowerCase()}/$page"),
        UserAnimeList::class.java
    )

    /**
     * Fetches MyAnimeList user's manga list.
     * @param username: User's username on MyAnimeList.
     * @param filter: Optional, filter list.
     * @param page: Optional, default is 1. Index of page.
     * @return User's manga list.
     */
    suspend fun getUserMangaList(
        username: String,
        filter: MangaStatusType = MangaStatusType.All,
        page: Int = 1
    ): UserMangaList = gson.deserialize(
        restClient.request("user/$username/mangalist/${filter.name.toLowerCase()}/$page"),
        UserMangaList::class.java
    )

    /**
     * Fetches MyAnimeList user's anime list.
     * @param username: User's username on MyAnimeList.
     * @param query: Query to filter by.
     * @param additionalQuery: Optional, additional query.
     * @param page: Optional, default is 1. Index of page.
     * @return User's anime list.
     */
    suspend fun getUserAnimeList(
        username: String,
        query: String,
        page: Int? = 1,
        additionalQuery: AnimeListSearchQuery? = null
    ): UserAnimeList {
        val formattedQuery = query.replace(" ", "%20")
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""
        val formattedPage = "&page=${page}"

        return gson.deserialize(
            restClient.request("user/$username/animelist?q=${formattedQuery}${formattedAdditionalQuery}${formattedPage}"),
            UserAnimeList::class.java
        )
    }

    /**
     * Fetches MyAnimeList user's manga list.
     * @param username: User's username on MyAnimeList.
     * @param query: Query to filter by.
     * @param additionalQuery: Optional, additional query.
     * @param page: Optional, default is 1. Index of page.
     * @return User's manga list.
     */
    suspend fun getUserMangaList(
        username: String,
        query: String,
        page: Int? = 1,
        additionalQuery: MangaListSearchQuery? = null
    ): UserMangaList {
        val formattedQuery = query.replace(" ", "%20")
        val formattedAdditionalQuery = additionalQuery?.toString() ?: ""
        val formattedPage = "&page=${page}"

        return gson.deserialize(
            restClient.request("user/$username/mangalist?q=${formattedQuery}${formattedAdditionalQuery}${formattedPage}"),
            UserMangaList::class.java
        )
    }

    //endregion
}