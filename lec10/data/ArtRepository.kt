package com.example.lec10.data

import com.google.gson.Gson
import com.google.gson.JsonObject
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ArtRepository(private val client: HttpClient) {

    // get 때문에 suspend 필요
    suspend fun getArtwork() : Art {
        val response = client.get(Endpoints.FIELDS1.url)
        val json = response.body<JsonObject>().toString()
        return deserializeJson(json)
    }

    private fun deserializeJson(json:String):Art{
        return Gson().fromJson(json, Art::class.java)
    }

    fun search(str: Any): Any {

    }
}