package moe.ganen.jikankt.models.user.enums

enum class AnimeOrderBy(val queryString: String? = null) {
    None,
    Title,
    StartDate("start_date"),
    FinishDate("finish_date"),
    Score,
    LastUpdated("last_updated"),
    Type,
    Rated,
    Rewatch,
    Priority,
    EpisodesWatched("episodes_watched"),
    Storage,
    AirStart("air_start"),
    AirEnd("air_end"),
    Status
}

enum class MangaOrderBy(val queryString: String? = null) {
    None,
    Title,
    StartDate("start_date"),
    FinishDate("finish_date"),
    Score,
    LastUpdated("last_updated"),
    Type,
    Priority,
    ChaptersRead("chapters_read"),
    VolumesRead("volumes_read"),
    PublishStart("publish_start"),
    PublishEnd("publish_end"),
    Status
}