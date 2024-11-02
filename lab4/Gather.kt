package com.example.lab4saeyoungpark

import kotlin.random.Random

class Gather(
    minion: Minion,
    item: Item? = null,
    companion: Companion? = null
) : Mission(minion) {

    override fun determineMissionTime(): Int {
        return when {
            companion != null -> {
                ((minion.backpackSize * minion.baseSpeed + items?.timeModifier!!)
                        * Random.nextInt(from = 0, until = 5))
            }
            else -> {
                ((minion.backpackSize * minion.baseSpeed)
                        * Random.nextInt(from = 0, until = 5))
            }
        }
    }

    override fun reward(time: Int): String {
        return when (time) {
            in 11..21 -> "bronze"
            in 22..33 -> "silver"
            in 34..44 -> "gold"
            in 45..60 -> "diamond"
            else -> "nothing"
        }
    }
}