package com.gclewis

import java.net.HttpURLConnection
import java.net.URI

fun main() {
    val url = URI.create("http://api.open-notify.org/astros.json").toURL()
    val conn = url.openConnection() as HttpURLConnection

    conn.requestMethod = "GET"
    conn.connect()

    val responseCode = conn.responseCode
    if (responseCode == HttpURLConnection.HTTP_OK) {
        val response = conn.inputStream.bufferedReader().use { it.readText() }
        println(response)
    } else {
        throw RuntimeException("HTTP GET request failed with error code: $responseCode")
    }
}