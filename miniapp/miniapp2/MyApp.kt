package com.example.miniapp2

import android.app.Application
import com.example.miniapp2.data.CharRepository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.gson.gson

class MyApp : Application() {

    private val client = HttpClient{
        install(ContentNegotiation){
            gson()
        }
    }

    val charRepository by lazy {
        CharRepository(client)
    }
}