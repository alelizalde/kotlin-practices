class CombineTwoStrings {
    fun `do`(input: List<List<Char>>, start: Int, output: String) {
        if (start == input.size) return

        for (i in start until input.size) {
            for(letter in input[i]) {
                val newOutput = output + letter
                println(newOutput)
                `do`(input, i + 1, newOutput)
            }
        }
    }
}

fun main() {
    val combine = CombineTwoStrings()
    val dic = listOf(listOf('a', 'b', 'c'), listOf('d', 'e', 'f'))
    combine.`do`(dic, 0, "")
}