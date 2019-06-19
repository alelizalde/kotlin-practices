/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

import java.math.BigInteger
import kotlin.system.measureNanoTime

fun main(args: Array<String>) {
    val n = 10
    var fib = BigInteger("0")

    var time = measureNanoTime {
        fib = fibonaccidp(n)
    }
    println("fibonacci $fib time $time")

    time = measureNanoTime {
        fib = fibonacci(n, BigInteger("0"), BigInteger("1"))
    }
    println("fibonacci $fib time $time")

    time = measureNanoTime {
        fib = fibonacciMulti(n, Array(n){BigInteger("0")})
    }
    println("fibonacci $fib time $time")

}

tailrec fun fibonacci(n: Int, a: BigInteger, b: BigInteger): BigInteger {
    return if (n == 0) a else fibonacci(n-1, b, a+b)
}

tailrec fun fibonacciMulti(n: Int, memo: Array<BigInteger>): BigInteger {
    return if (n < 2) n.toBigInteger()
    else {
        if (memo[n-1] != BigInteger("0"))
            memo[n-1]
        else {
            memo[n-1] = fibonacciMulti(n - 1, memo) + fibonacciMulti(n - 2, memo)
            memo[n-1]
        }
    }
}

fun fibonaccidp(n: Int): BigInteger {
    var dpt = Array<BigInteger>(n + 2){BigInteger("0")}
    dpt[0] = BigInteger("0")
    dpt[1] = BigInteger("1")
    for(i in 2..n){
        dpt[i] = dpt[i-2] + dpt[i-1]
    }

    return dpt[n]
}