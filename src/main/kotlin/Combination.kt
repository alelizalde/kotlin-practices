fun main() {
    print(combination("abc", 0, ""))
}


fun combination(input: String, start: Int, output: String) {
    if (start == input.length) return
    for (i in start until input.length) {
        val newOutput = output + input[i]
        println(newOutput)
        combination(input, i + 1, newOutput)
    }
}