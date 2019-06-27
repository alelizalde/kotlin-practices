fun main() {
    val arr = intArrayOf(2, 10, 6, 16, 4)
    val memo: MutableMap<String, Int> = mutableMapOf()
    val ans: ArrayList<List<Int>> = arrayListOf()
    //println(dpMemo(arr, 16, arr.size - 1, memo))
    //dpMemoList(arr, 16, arr.size - 1, mutableMapOf(), ArrayList(), ans)
    dpMemoListButtomUp(arr, 16, 0, mutableMapOf(), ArrayList(), ans)
    println(ans)
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

fun dpMemoList(arr: IntArray, total: Int, pointer: Int, memo: MutableMap<String, Boolean>, list: ArrayList<Int>, ans: ArrayList<List<Int>>){
    val key = "$total-$pointer"
    if (memo.containsKey(key)) {
        println("returning $key: ${memo[key]}")
        return
    }

    println("memo: $memo, total: $total, pointer: $pointer")
    when {
        total == 0 -> ans.add(ArrayList(list))
        total < 0 -> return
        pointer < 0 -> return
        total < arr[pointer] -> {
            dpMemoList (arr, total, pointer - 1, memo, list, ans)
        }
        else -> {
            list.add(arr[pointer])
            dpMemoList (arr, total - arr[pointer], pointer - 1, memo, list, ans)
            list.remove(arr[pointer])
            dpMemoList (arr, total, pointer - 1, memo, list, ans)
        }
    }
    println("key: $key=${memo[key]}")
    memo[key] = true
}

fun dpMemoListButtomUp(arr: IntArray, total: Int, pointer: Int, memo: MutableMap<String, Boolean>, list: ArrayList<Int>, ans: ArrayList<List<Int>>){
    val key = "$total-$pointer"
    if (memo.containsKey(key)) {
        println("returning $key: ${memo[key]}")
        return
    }

    println("memo: $memo, total: $total, pointer: $pointer")
    when {
        total == 0 -> ans.add(ArrayList(list))
        total < 0 -> return
        pointer > arr.size -1 -> return
        total < arr[pointer] -> {
            dpMemoListButtomUp (arr, total, pointer + 1, memo, list, ans)
        }
        else -> {
            list.add(arr[pointer])
            dpMemoListButtomUp (arr, total - arr[pointer], pointer + 1, memo, list, ans)
            list.remove(arr[pointer])
            dpMemoListButtomUp (arr, total, pointer + 1, memo, list, ans)
        }
    }
    println("key: $key=${memo[key]}")
    memo[key] = true
}