package com.example.lab2saeyoungpark

fun main() {
    val strArr = arrayOf("The", "Quick", "Brown", "Fox", "Went", "Over", "The", "Lazy", "Android")

    val lengLst = mutableListOf<String>() // initiate without any element
    strArr.forEach { length -> // able to use smth-like it
        lengLst.add(length.length.toString())
    }

    val lngestLst = mutableListOf<String>()
    val maxLength = strArr.sortedBy { it.length }.last().length
    for (element in strArr) {
        if (element.length < maxLength) continue
        lngestLst.add(element)}

    val shrtestLst = mutableListOf<String>()
    var index = 0
    val minLength = strArr.sortedBy { it.length }[0].length
    while (index < strArr.size && strArr[index].length < minLength) shrtestLst.add(strArr[index++])

    println(
        """
        Words: ${strArr.contentToString()}
        Word length: ${lengLst}
        Longest word(s): ${lngestLst.distinct()}
        Shortest word(s): ${shrtestLst.distinct()}
        """.trimIndent()
    )
}
