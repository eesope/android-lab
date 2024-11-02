package com.example.lab4saeyoungpark

interface Repeatable {

    val repeatNum: Int
    fun repeat(number: Int, listener: MissionListener)
}