
fun generateParenthesis(ans: MutableList<String>, cur: String = "", open: Int = 0, close: Int = 0, max: Int) {
    if (cur.length == max * 2) {
        ans.add(cur)
        return
    }

    if (open < max)
        generateParenthesis(ans, "$cur(", open + 1, close, max)
    if (close < open)
        generateParenthesis(ans, "$cur)", open, close + 1, max)
}

fun main() {
    val ans = ArrayList<String>()
    generateParenthesis(ans = ans, max = 3)
    println(ans)
}
