package popcornbyte.com

import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis
import kotlinx.coroutines.*

fun sync(){
    var counter = 0
    val numberOfThreads = 1_000_000

    val time = measureTimeMillis {
        for (i in 1..numberOfThreads) {
            thread() {
                counter += 1
            }
        }
    }

    println("Created ${numberOfThreads} threads in ${time}ms.")
}

fun asyncThread(){
    var counter = 0
    val numberOfCoroutines = 1_000_000
    val time = measureTimeMillis {
        for (i in 1..numberOfCoroutines) {
            GlobalScope.launch {
                counter += 1
            }
        }
    }

    println("Created ${numberOfCoroutines} threads in ${time}ms.")
}

fun main(args:Array<String>){
    asyncThread()
}
