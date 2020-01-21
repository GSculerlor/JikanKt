package moe.ganen.jikankt

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import moe.ganen.jikankt.connection.RestClient

fun main() {
    val client = RestClient()
    runBlocking {
        val clientTest = client.request("/anime/38992")
        println(clientTest)
        delay(5000)
    }
}