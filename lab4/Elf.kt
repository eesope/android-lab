package com.example.lab4saeyoungpark

class Elf : Minion, Companion {
    override val race: String = "Elf"
    override val baseHealth: Int = 2
    override val baseSpeed: Int = 8
    override val backpackSize:Int = 3
    override val catchphrase:String = "My arrows never miss!"

    override fun huntReward(time: Int): String {
        return when (time) {
            in 11..20 -> "fish"
            in 21..30 -> "forest bear"
            in 31..40 -> "orc"
            in 41..60 -> "troll"
            else -> "nothing"
        }
    }
}

