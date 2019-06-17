/*
author: Al Elizalde
date: June 15 2019
web site: http://popcornbyte.com
*/

val String.firstWord: String

get(){
    val index = indexOf(" ")
    return if(index<0) this else substring(0, index)
}

fun String.CountX(): Int{
    return length - replace("x", "").length
}

fun main (args: Array<String>){
    println(
        "Al Elizalde".firstWord
    )

    println(
        "xFunxWithxKotlinx".CountX()
    )
}