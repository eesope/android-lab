package com.example.lec10

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {

    // asynchronous programming
    // non-blocking 뒤에 오는 실행 블록이 앞이랑 상관 없이 실행될 때; 프린트문 두개면 뒤가 앞에 의해 블로킹 되어 있음

    runBlocking {

        val job = launch { // launch 대신 async 쓸수도 있음
            repeat(1000){
                println("...")
                delay(800L)
            }
        }

        delay(5000L)
        job.cancel() // 남은 jobs 는 캔슬됨
        println("The sponge ha arrived")

//        print("The sponge")
        // job.join()
//        print( job.await())
//        print(" back")

        coroutineScope { 1 }
        coroutineScope { 2 } // coroutineScope 1 이 끝나야 coroutineScope 2 가 시작될 수 있음 **


//        someFun()

//        // block the main thread; able to run coroutine
//        launch { // launch get suspended **launch 는 runBlocking 을 inherit 하기 때문에 suspend 키워드 필요 없음; runblocking scope 안에 있을 때만 inherit
//            delay(1000L)
//            print("is back")
//        }
//        print("The sponge...")

    }


}

suspend fun someFun(){
    coroutineScope {
        launch { // now coroutineScope 으로 스콥 지정해서 launch 오류 안 남
            delay(1000L) // suspend for a second
            print("is back")
        }
        print("The sponge...")
    }

}

// suspend 실행시키려면 시그니쳐 필요
suspend fun test(){
    someFun()
}