import kotlin.system.measureNanoTime

enum class Result {
    TRUE, FALSE, NULL
}

lateinit var memo : Array<Array<Result>>

fun isMatch(text: String, pattern: String): Boolean {
    memo = Array(text.length + 1) {Array(pattern.length + 1) {Result.NULL} }
    return dp(0, 0, text, pattern)
}

fun dp(i: Int, j: Int, text: String, pattern: String): Boolean {
    if (memo[i][j] != Result.NULL) {
        return memo[i][j] == Result.TRUE
    }
    val ans =
    if (j == pattern.length) {
        i == text.length
    } else {
        val firstMatch = i < text.length && (pattern[j] == text[i] || pattern[j] == '.')
        if (j + 1 < pattern.length && pattern[j + 1] == '*') {
            dp(i, j + 2, text, pattern) || firstMatch && dp(i + 1, j, text, pattern)
        } else {
            firstMatch && dp(i + 1, j + 1, text, pattern)
        }
    }
    memo[i][j] = if (ans) Result.TRUE else Result.FALSE
    return ans
}

fun isMatchTabulation(text: String, pattern: String): Boolean {
    val dp = Array(text.length + 1) { BooleanArray(pattern.length + 1) }
    dp[text.length][pattern.length] = true

    for (i in text.length downTo 0) {
        for (j in pattern.length - 1 downTo 0) {
            val firstMatch = i < text.length && (pattern[j] == text[i] || pattern[j] == '.')
            if (j + 1 < pattern.length && pattern[j + 1] == '*') {
                dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j]
            } else {
                dp[i][j] = firstMatch && dp[i + 1][j + 1]
            }
        }
    }
    return dp[0][0]
}


fun main() {
    var time : Long
    var ans  = false

    time = measureNanoTime {
        ans = isMatch("holla", "hol*a")
    }
    println("Memo $ans in $time")

    time = measureNanoTime {
        ans = isMatchTabulation("holla", "hol*a")
    }
    println("Tabulation $ans in $time")
}