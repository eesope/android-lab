package com.example.miniapp2.data

enum class Endpoints(val url:String) {
    BASE_URL("https://hp-api.herokuapp.com/api"),
    CHARACTERS("${BASE_URL.url}/characters"),
    IMAGE_ENDPOINT("https://ik.imagekit.io/hpapi/character.jpg");

    fun format(str: String?): String{
        if (str == null) return ""
        return url.format(str)
    }
}