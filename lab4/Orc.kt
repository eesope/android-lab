package com.example.lab4saeyoungpark

class Orc(minion: Minion) : Minion by minion {
    override val race: String = "Orc"
    override val catchphrase: String = "ARRGH!"
}
