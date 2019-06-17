/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

import kotlinx.coroutines.delay
import java.lang.Thread.sleep
import kotlin.concurrent.thread
import kotlinx.coroutines.*

fun main(args: Array<String>) = coroutines(100_000)

//Not efficient
fun threads(n: Int) {
    val threads = List(n) {
        thread {
            sleep(1000L)
            println(it)
        }
    }

    threads.forEach { it.join() }
}

//Efficient
fun coroutines(n: Int) = runBlocking{
    val jobs = List(n) {
        async {
            delay(1000L)
            println(it)
        }
    }

    jobs.forEach { it.join() }
}