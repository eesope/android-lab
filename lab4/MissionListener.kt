package com.example.lab4saeyoungpark

interface MissionListener {
    fun missionStart(minion: Minion)
    fun missionProgress()
    fun missionComplete(minion: Minion, reward: String)
}

