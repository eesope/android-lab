package com.example.lec10

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    val sequence = sequenceOf(1, 2, 3, 4) // collection but access lazliy 하나하나
    val list = sequence.toList() // step 늘어남 all at once 처리하기 때문

    val story = sequence { //suspend function; no asynchronous; delay 불가
       yield("Once")
        yieldAll(sequence)

    }

    val flow = flow { // flow 는 asynchronous; delay 가능

    }

}

