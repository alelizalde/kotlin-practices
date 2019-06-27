fun main() {
    val arr = intArrayOf(2, 10, 4, 16, 6)
    val memo: MutableMap<String, Int> = mutableMapOf()
    //println(dpMemo(arr, 16, arr.size - 1, memo))
    println(dpTab(arr, 16))
}

fun dpMemo (arr: IntArray, total: Int, pointer: Int, memo: MutableMap<String, Int>): Int {
    val key = "$total-$pointer"
    if (memo.containsKey(key)) {
        println("returning $key: ${memo[key]}")
        return memo[key] ?: 0
    }

    println("memo: $memo, total: $total, pointer: $pointer")
    val result = when {
        total == 0 -> return 1
        total < 0 -> return 0
        pointer < 0 -> return 0
        total < arr[pointer] -> dpMemo (arr, total, pointer - 1, memo)
        else -> dpMemo (arr, total - arr[pointer], pointer - 1, memo) + dpMemo (arr, total, pointer - 1, memo)
    }
    println("key: $key=$result")
    memo[key] = result
    return result

}

fun dpTab (arr: IntArray, total: Int): Int {
    val dp = IntArray(arr.size + 1)
    dp[0] = 1
    for (i in 0 until arr.size){
        var currTotal = total
        for (j in i + 1 until arr.size) {
            println("total: $total, pointer: ${arr[j]}")
            dp[j] = when {
                currTotal == 0 -> 1
                currTotal < 0 -> 0
                arr[j] > arr.size -> 0
                currTotal < arr[j] -> dp[j - 1]
                else -> {
                    currTotal -= arr[j]
                    dp[j - 1]
                }
            }
        }
    }

    return dp[arr.size]

}