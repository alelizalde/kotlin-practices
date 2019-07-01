import java.lang.StringBuilder

fun main() {
    //print(combination("abc", 0, ""))
    print(permutation("abc", 0, ""))
}


fun combination(input: String, start: Int, output: String) {
    if (start == input.length) return
    for (i in start until input.length) {
        val newOutput = output + input[i]
        println(newOutput)
        combination(input, i + 1, newOutput)
    }
}

fun permutation(input: String, start: Int, output: String) {
    var str = input
    if (start == str.length) {
        println(str)
    } else {
        for (i in start until str.length) {
            val newOutput = output + str[i]
            str = swap(str, start, i)
            permutation(str, i + 1, newOutput)
            str = swap(str, start, i)
        }
    }
}

fun swap(a: String, i: Int, j: Int): String {
    val temp: Char
    val charArray = a.toCharArray()
    temp = charArray[i]
    charArray[i] = charArray[j]
    charArray[j] = temp
    return String(charArray)
}