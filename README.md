# JikanKt

[![Discord Server](https://img.shields.io/discord/460491088004907029.svg?style=flat&logo=discord)](https://discord.gg/4tvCr36) [![CodeFactor](https://www.codefactor.io/repository/github/gsculerlor/jikankt/badge)](https://www.codefactor.io/repository/github/gsculerlor/jikankt)

![JikanKt Banner](https://raw.githubusercontent.com/GSculerlor/JikanKt/master/assets/JikanKt.png)

API wrapper for [Jikan API](https://jikan.moe) build using Kotlin + Kotlin DSL + Coroutines power 🚀

# Installation
with Gradle
```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
    
dependencies {
    implementation 'com.github.GSculerlor:JikanKt:1.0.0'
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
    <version>1.0.0</version>
</dependency>
```

# Example
```kotlin
fun main() {
    runBlocking {
        val anime = JikanKt.getAnime(38992)
        println(anime)
    }
}
```
# Status
JikanKt is under heavily development after revived from eternal slumber. At this point, some of the endpoints maybe still not wrapped yet, so please stay tune!
Also currently it only run on JVM, but don't worry, Kotlin multiplatform is already planned on next major release! Also test will added once all of the endpoint is mapped which is very very soon!

# Contribution
Want to help? I'm very open to contributors so just do it or contact me if you have any question (Discord: Ganen#0124)

