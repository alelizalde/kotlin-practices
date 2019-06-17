/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

class Example(val a:Int, val b:Int, val c:Int)
fun main(args: Array<String>){
    val ex = Example(1, 2,3 )
    with(ex) {
        println("a=$a, b=$b, c=$c")
    }

    val map = mapOf(
        "k1" to 1,
        "k2" to 2,
        "k3" to 3
    )

    for((k, v) in map.entries)
        println("k=$k, v=$v")

    var s: String
    s = if (System.currentTimeMillis() % 2 == 0L) {
        println("Yay!")
        "Luck!"
    } else{
        "No this time"
    }
    println(s)

    fun test(e: Example) = when(e.a) {
        1, 2, 3 -> "Odd"
        in setOf(2, 4, 6) -> "Even"
        else -> "Too big"
    }

    val numbers = (1..100).toList()

    val list = numbers
        .filter { it % 16 == 0}
        .also { println(it) }
        .map { "0x" + it.toString(16) }

    repeat(6) {
        println(list)
    }

}

inline fun repeat(times: Int, body: (Int) -> Unit) {
    for (index in 0 until times) {
        body(index)
    }
}