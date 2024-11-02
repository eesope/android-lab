package com.example.lab4saeyoungpark

/*
    Saeyoung Park
    A01344898
*/

fun main() {

    val human = Human()
    val dwarf = Dwarf()
    val elf =  Elf()
    val orc = Orc(elf)
    val item1 = Item.MAP
    val item2 = Item.COMPASS

    val orcGathering = Gather(orc, item1)

    val humanGathering = Gather(human)
    val dwarfHunting = Hunt(dwarf, item2, elf)
    val elfGathering = Gather(elf)

    val huntListener = object : MissionListener {
        override fun missionStart(minion: Minion) {
            println("""
                ${minion.catchphrase}  
                A ${minion.race} started a new hunt!
                """.trimIndent())
        }
        override fun missionProgress() {
            println("""
                ...
                ...
                ...
            """.trimIndent())
        }
        override fun missionComplete(minion: Minion, reward: String) {
            println("""
                 A ${minion.race} has returned from a hunt and found $reward!
                """.trimIndent())
        }
    }

    val gatherListener = object : MissionListener {
        override fun missionStart(minion: Minion) {
            println("""
                ${minion.catchphrase}  
                A ${minion.race} was sent off to gather some resources!
                """.trimIndent())
        }
        override fun missionProgress() {
            println("""
                ...
                ...
                ...
            """.trimIndent())
        }
        override fun missionComplete(minion: Minion, reward: String) {
            println("""
                 A ${minion.race} has returned from gathering, and found $reward!
                """.trimIndent())
        }
    }

    dwarfHunting.repeat(4, huntListener)
    orcGathering.start(gatherListener)

    println("""            
        ⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀
        ⠀⠀⠀⠀⢀⣴⠾⠛⠉⠉⠉⠉⠛⠿⣦⡀⠀⠀⠀⠀
        ⠀⠀⠀⢠⡿⠁⠀⢀⣠⣤⣤⣄⡀⠀⠈⢿⡆⠀⠀⠀
        ⠀⠀⢀⣿⣁⣀⣠⡿⠋⠀⠀⠙⢿⣄⣀⣈⣿⡀⠀⠀
        ⠀⠀⢸⣿⠛⠛⢻⣧⠀⠿⠇⠀⣼⡟⠛⠛⣿⡇⠀⠀
        ⠀⠀⢸⣿⠀⠀⠀⠙⢷⣦⣴⡾⠋⠀⠀⠀⣿⡇⠀⠀
        ⠀⠀⢸⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⠀⠀
        ⠀⠀⣸⣿⠀⠀⠀⠛⠷⠶⠶⠾⠛⠀⠀⠀⣿⣇⠀⠀
        ⠀⣸⣿⣿⢷⣦⣀⣀⣀⣀⣀⣀⣀⣀⣴⡾⣿⣿⣇⠀
        ⢠⣿⢸⣿⠀⣿⡏⠉⠉⠉⠉⠉⠉⢹⣿⠀⣿⡇⣿⡄
        ⢸⡏⢸⣿⣀⣿⡇⠀⠀⠀⠀⠀⠀⢸⣿⣀⣿⡇⢹⡇
        ⢸⡇⠀⢿⣏⠉⠁⠀⠀⠀⠀⠀⠀⠈⠉⣹⡿⠀⢸⡇
        ⢸⣿⣤⣌⠛⠷⣶⣶⣶⣶⣶⣶⣶⣶⠾⠛⣡⣤⣿⡇
        ⠘⠿⠿⠇⠀⠀⠀⢿⡾⠇⠸⢷⡿⠀⠀⠀⠸⠿⠿⠃
        ⠀⠀⠀⠀⠀⠀⠀⠛⠛⠁⠈⠛⠛⠀⠀⠀⠀⠀⠀⠀
    """.trimIndent())
}