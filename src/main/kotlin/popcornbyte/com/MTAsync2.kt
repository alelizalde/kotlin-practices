package popcornbyte.com

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun meaninglessCounter(): Int {
    var counter = 0
    for (i in 1..10_000_000_000) {
        counter += 1
    }
    return counter
}
fun main(args: Array<String>) {
    // Sequential execution.
    var time = measureTimeMillis {
        val one = meaninglessCounter()
        val two = meaninglessCounter()
        println("The answer is ${one + two}")
    }
    println("Sequential completed in $time ms")

    // Concurrent execution.
    var time2 = measureTimeMillis {
        val one = GlobalScope.async { meaninglessCounter() }
        val two = GlobalScope.async { meaninglessCounter() }
        runBlocking {
            println("The answer is ${one.await() + two.await()}")
        }
    }
    println("Concurrent completed in $time2 ms\n")
}