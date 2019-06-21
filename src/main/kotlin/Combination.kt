fun main() {
    print(combine("abc", 0, ""))
}


fun combine(input: String, start: Int, output: String) {
    if (start == input.length) return
    for (i in start until input.length) {
        val newOutput = output + input[i]
        println(newOutput)
        combine(input, i + 1, newOutput)
    }
}