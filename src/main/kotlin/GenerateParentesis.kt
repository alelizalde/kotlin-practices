
fun generateParenthesis(n: Int): List<String> {
    val ans = ArrayList<String>()
    backtrack(ans, "", 0, 0, n)
    return ans
}

fun backtrack(ans: MutableList<String>, cur: String, open: Int, close: Int, max: Int) {
    if (cur.length == max * 2) {
        ans.add(cur)
        return
    }

    if (open < max)
        backtrack(ans, "$cur(", open + 1, close, max)
    if (close < open)
        backtrack(ans, "$cur)", open, close + 1, max)
}

fun main() {
    println(generateParenthesis(3))
}