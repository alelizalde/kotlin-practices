/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

import java.math.BigInteger

fun main(args: Array<String>) {
    val n = 10
    val first = BigInteger("0")
    val second = BigInteger("1")

    println(fibonacci(n, first, second))
}

tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacci(n-1, b, a+b)
}