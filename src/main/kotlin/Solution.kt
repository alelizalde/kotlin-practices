fun main() {
    val candidates = intArrayOf(2, 4, 6, 10)
    val memo: MutableMap<String, Int> = mutableMapOf()
    val counter = mutableMapOf<Int, Int>()
    val ans = mutableListOf<List<Int>>()
    candidates.forEach {counter[it] = (counter[it]?:0) + 1}
    println(dpMemoPractice(candidates, 16, 0, memo))
}

fun dpMemoPractice (arr : IntArray, total: Int, start: Int, memo: MutableMap<String, Int>): Int {
    val key = "$total:$start"
    if (memo.containsKey(key))
        return memo[key]?:0

    //println("total: $total, start: $start")
    print("{$total, $start}")
    memo[key] = when {
        total == 0 -> return 1
        total < 0 -> return 0
        start >= arr.size -> return 0
        total < arr[start] -> dpMemoPractice (arr, total, start + 1, memo)
        else -> dpMemoPractice (arr, total - arr[start], start + 1, memo) + dpMemoPractice (arr, total, start + 1, memo)
    }
    //println(memo)
    return memo[key]?:0
}

