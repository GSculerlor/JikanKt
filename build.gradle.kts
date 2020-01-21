plugins {
    kotlin("jvm") version "1.3.61"
}

group = "moe.ganen"
version = "0.0.1"

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/ktor")
    maven("https://kotlin.bintray.com/kotlinx")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.2.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.2.1")

    //Ktor
    implementation("io.ktor:ktor-client-core:1.2.1")
    implementation("io.ktor:ktor-client-core-jvm:1.2.1")
    implementation("io.ktor:ktor-client-json:1.2.1")
    implementation("io.ktor:ktor-client-json-jvm:1.2.1")
    implementation("io.ktor:ktor-client-okhttp:1.2.1")
    implementation("io.ktor:ktor-client-gson:1.2.1")

    //Gson
    implementation("com.google.code.gson:gson:2.8.5")

    //slf4j
    api("org.slf4j:slf4j-api:1.7.25")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}