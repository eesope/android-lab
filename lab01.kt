package com.example.lc1dtc

const val NUM:Int = 10 // can't be var

fun main() {
//    beware auto complete
//    pixel 3a api 30 instead of medium phone api 34

//
//    var str:String = "Sponge"
//    // if val can't be updated versus var : use val as much
//    str = "Bob"

    val num:Int = 5

    // everything primitives are class which means you can do Any (super class)
    val a: Any = 5.5

    val d: Double = 5.5
    val l:Long = 500L
    val f:Float = 2.3F
    val b:Boolean = true
    val s:String = "yay"
    val c:Char = 'g'
   // char for SINGLE quote

    // type inferred
    val numex = 6

    // const can't be local var

    val str:String? = null // nullable type
    val str2:String = "Spongebob" // can't be null

    println(str?.length) // safe call operator *use operators*

//    println(str!!.length) // sure operator


    val name:String = "haibara"
    println(name.length)
    println(name.uppercase())
    println(name.isEmpty())
    println(name[3]) // no outer bound for index is a thing



    val who = "Jerry"
    val height = 5
    println("$who is $height feet tall.")
    println("${name.length} letters")
    println(name.format("Alex", 4))

    val lngstr = """
        hi there
        this is kotlin classssssss
        hahihuheho
    """.trimIndent()
    println(lngstr)

    // string comparison with == for value, === for reference

    val n1 = "Jerry"
    val n2 = String("Jerry".toCharArray())
    val n3 = "Jerry"

    println(n1 === n2)
    println(n1 === n3)     // kotlin has string pool memory === is referential equality memory

// import kotlin.math.sqrt : importing dependency


// if statement

    if (n1 === n3) { println("referential equality memory")
    } else { println("only in kotlin")
    }

    // Unit like Java void
    val result = if (n1 === n3) { println("referential equality memory")
    } else { println("only in kotlin")
    }

    val species = 'W'

    // switch if
    when (species) {
        'C' -> println("Crab")
        'S' -> println("Squirrel")
        'W' -> println("Whale")
        else -> println("Human")

    }

// or

    val unit =     when (species) {
        'C' -> println("Crab")
        'S' -> println("Squirrel")
        'W' -> println("Whale")
        // expression for condition value like
//        4 > 3 -> "math"
        else -> println("Human") }



    }