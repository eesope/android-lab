package com.example.lec10

import android.app.Application
import com.example.lec10.data.ArtRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson


class MyApp : Application(){ // manifest manipulate mandatory

    private val client = HttpClient { // manifest manipulate mandatory && build.gradle module

        install(ContentNegotiation) {
            gson()
        }
    }

    val artRepository by lazy {
        ArtRepository(client)
    }

}