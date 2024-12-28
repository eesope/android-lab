package com.example.miniapp2.data

import com.google.gson.annotations.SerializedName

data class Character (
    val name:String,
    val house: String,
    val patronus: String,
    @SerializedName("image")
    val profileImg: String?
)
