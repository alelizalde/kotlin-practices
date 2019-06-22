fun main() {
    val s : String? = null
    s?.let { printTest(it) }
}

fun printTest(s: String){
    println(s)
}