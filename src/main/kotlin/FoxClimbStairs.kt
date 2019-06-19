import kotlin.system.measureNanoTime

fun climbMemo(n: Int, memo: Array<Int>): Int {
    return when(memo[n - 1]) {
        0 -> {
            memo[n - 1] = climbMemo(n -1, memo ) + climbMemo( n - 2, memo ) + climbMemo( n - 3, memo )
            memo[n - 1]
        }
        else -> memo[n - 1]
    }
}

fun climbTab(n: Int): Int {
    var dp = Array(n + 3){0}
    dp[0] = 1
    dp[1] = 1
    dp[2] = 2
    for(i in 3..n){
        dp[i] = dp[i - 3] + dp[i - 2] + dp[i -1]
    }
    return dp[n]
}

fun climbWithSteps(n: Int, jumps: Array<Int>): Int {
    val steps = Array(n + 1){0}
    steps[0]=1

    for (curr in 0 until jumps.size){
        for (step in jumps[curr] until steps.size){
            var stepSum = 0
            for (prev in 0..curr){
                stepSum += steps[step - jumps[prev]]
            }
            steps[step] = stepSum
        }
    }
    return steps[n]
}

fun main(args: Array<String>) {
    var steps = 6
    val memo = Array(steps  + 1){0}
    memo[0] = 1
    memo[1] = 1
    memo[2] = 2
    var comb = 0
    var time = measureNanoTime {
        comb = climbMemo(steps  + 1, memo)
    }
    println("Fox steps combination memo $comb time $time")

    time = measureNanoTime {
        comb = climbTab(steps)
    }
    println("Fox steps combination tabulation $comb time $time")

    steps = 10
    time = measureNanoTime {
        comb = climbWithSteps(steps, arrayOf(2, 3, 5))
    }
    println("Fox steps combination with dynamic steps $comb time $time")
}