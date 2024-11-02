package com.example.lab4saeyoungpark

import kotlin.properties.Delegates
import kotlin.random.Random

class Hunt(
    minion: Minion,
    item: Item? = null,
    companion: Companion? = null
) : Mission(minion), Repeatable {

    override fun determineMissionTime(): Int {
        return when {
            companion != null -> {
                ((minion.baseHealth * minion.baseSpeed + items?.timeModifier!!)
                        * Random.nextInt(from = 0, until = 5))

            }
            else -> {
                ((minion.baseHealth * minion.baseSpeed)
                        * Random.nextInt(from = 0, until = 5))
            }
        }
    }

    override fun reward(time: Int): String {
        return if (companion != null) {
            companion.huntReward(time)
        } else {
            when (time) {
                in 11..20 -> "mouse"
                in 21..30 -> "fox"
                in 31..40 -> "buffalo"
                in 41..60 -> "dinosaur"
                else -> "nothing"
            }
        }
    }

    override var repeatNum: Int by Delegates.vetoable(3) {
        _, _, newValue ->
        if (newValue > 3) {
            println("A minion cannot repeat hunt more than 3 times!\n")
            false
        } else {
            true
        }
    }

    override fun repeat(number: Int, listener: MissionListener) {
        repeatNum = number
        println("Repeating a hunt $repeatNum times...\n")
        for (i in 1..repeatNum) {
            start(listener)
        }
    }
}