plugins {
    kotlin("jvm") version "1.3.61"
    maven
}

repositories {
    mavenCentral()
    jcenter()
    maven("https://kotlin.bintray.com/ktor")
    maven("https://kotlin.bintray.com/kotlinx")
}

group = "com.github.GSculerlor"
version = "1.3.0"

val ktorVersion: String by project
val gsonVersion: String by project
val coroutinesVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:$coroutinesVersion")

    //Ktor
    implementation("io.ktor:ktor-client-core:$ktorVersion")
    implementation("io.ktor:ktor-client-core-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-json:$ktorVersion")
    implementation("io.ktor:ktor-client-json-jvm:$ktorVersion")
    implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
    implementation("io.ktor:ktor-client-gson:$ktorVersion")

    //Gson
    implementation("com.google.code.gson:gson:$gsonVersion")

    //kotlin-logging
    implementation("io.github.microutils:kotlin-logging:1.7.7")
    implementation("org.slf4j:slf4j-simple:1.7.26")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }

    test {
        useJUnitPlatform()
    }
}