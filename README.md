![JikanKt Banner](https://raw.githubusercontent.com/GSculerlor/JikanKt/master/assets/JikanKt.png)

[![Discord Server](https://img.shields.io/discord/460491088004907029.svg?style=flat&logo=discord)](https://discord.gg/4tvCr36) [![CodeFactor](https://www.codefactor.io/repository/github/gsculerlor/jikankt/badge)](https://www.codefactor.io/repository/github/gsculerlor/jikankt) [![](https://jitpack.io/v/GSculerlor/JikanKt.svg)](https://jitpack.io/#GSculerlor/JikanKt)
 ![Master build](https://github.com/GSculerlor/JikanKt/workflows/Master%20build/badge.svg)

API wrapper for [Jikan API](https://jikan.moe) build using Kotlin + Kotlin DSL + Coroutines power 🚀

# Installation
with Gradle
```groovy
repositories {
    jcenter()
    maven { url 'https://jitpack.io' }
}
    
dependencies {
    implementation 'com.github.GSculerlor:JikanKt:1.3.2'
}
```
with Maven
```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.GSculerlor</groupId>
    <artifactId>JikanKt</artifactId>
    <version>1.3.2</version>
</dependency>
```

# Example
```kotlin
fun main() {
    runBlocking {
        val anime = JikanKt.getAnime(38992)
        println(anime)
    }
    
    //Using custom domain
    runBlocking {
        val manga = JikanKt.apply { restClient = RestClient(url = "http://ganen.moe:8800/v3/")  }.getManga(2)
        println(manga)
    }
}
```
Note that `JikanKt` is an object, so it's singleton. So `apply { }` will be applied on every request. If you have to request
to multiple domains, make sure to apply it per-request!

For documentation, please check [here](https://ganen.moe/jikankt/docs/).

# Release
For latest release or to check the changelogs, please check Release tab.

# Status
JikanKt is under heavily development after revived from eternal slumber. At this point, some of the endpoints maybe still not wrapped yet, so please stay tune!
Also currently it only run on JVM, but don't worry, Kotlin multiplatform is already planned on next major release! Also test will added once all of the endpoint is mapped which is very very soon!

# Contribution
Want to help? I'm very open to contributors so just do it or contact me if you have any question (Discord: Ganen#0124)

