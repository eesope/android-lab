package com.example.miniapp2.data

import com.google.gson.Gson
import com.google.gson.JsonArray
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class CharRepository(private val client: HttpClient) {

    suspend fun getCast(): List<Character>  {
        val response = client.get(Endpoints.CHARACTERS.url)
        val json = response.body<JsonArray>().toString()
        val art = Gson().fromJson(json, Array<Character>::class.java).toList()
        return art
    }

}