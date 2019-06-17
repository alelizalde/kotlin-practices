/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

tailrec fun factorial(n: Int, memo: Array<Int>): Int{
    return when(memo[n -1]) {
         0 -> {
            val x = factorial(n-1, memo) * n
            memo[n-1] = x
            memo[n-1]
        } else -> memo[n -1]
    }
}

fun main(args: Array<String>) {
    val num = 14
    var memo = Array(num){0}
    memo[0] = 1
    println(
        factorial(num, memo)
    )
}

