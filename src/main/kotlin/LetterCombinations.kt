var count = 0
class LetterCombinations {

    private val dic = mapOf(
        '2' to listOf('a', 'b', 'c'),
        '3' to listOf('d', 'e', 'f'),
        '4' to listOf('g', 'h', 'i'),
        '5' to listOf('j', 'k', 'l'),
        '6' to listOf('m', 'n', 'o'),
        '7' to listOf('p', 'q', 'r', 's'),
        '8' to listOf('t', 'u', 'v'),
        '9' to listOf('w', 'x', 'y', 'z'))

    fun combine(digits: String, output: String, ans: MutableList<String>) {
        if (digits.isEmpty()) {
            ans.add(output)
        } else {
            val digit = digits[0]
            var letters = dic[digit]
            for (letter in letters!!) {
                count++
                this.combine(digits.substring(1), output + letter, ans)
            }
        }
    }
}

fun main() {
    val combine = LetterCombinations()
    val output = mutableListOf<String>()

    combine.combine("23", "", output)
    println("combination: $output, cycles: $count")
    output.clear()
}