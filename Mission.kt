package com.example.lab4saeyoungpark

abstract class Mission(
    protected val minion: Minion,
    protected val items: Item? = null,
    protected val companion: Companion? = null
) {
    fun start(listener: MissionListener){
        val time = determineMissionTime()
        val reward = reward(time)

        listener.missionStart(minion)
        listener.missionProgress()
        listener.missionComplete(minion, reward)

    }
    protected abstract fun determineMissionTime(): Int
    protected abstract fun reward(time: Int): String
}
