fun main() {
    val candidates = intArrayOf(3,1,3,5,1,1)
    //val arr = intArrayOf(2, 4, 6, 10, 2, 6, 6, 2, 2)
    val target = 8
    val memo: MutableMap<String, Int> = mutableMapOf()
    val ans = mutableListOf<MutableList<Int>>()
    //println(dpMemo(arr, 16, arr.size - 1, memo))
    //println(dpMemoBottomUp(arr, 16, 0, memo))
    //dpMemoList(arr, 16, arr.size - 1, mutableMapOf(), ArrayList(), ans)
    val count = mutableMapOf<Int, Int>()
    candidates.forEach {count[it]=(count[it]?:0)+1}
    dpListRec(candidates.distinct().toIntArray(), target, 0, ArrayList(), ans, count)
    //dpMemoBottomUpList(arr, 16, 0)
    println(ans)
}

fun dpMemoBottomUp (arr : IntArray, total: Int, i: Int, memo: MutableMap<String, Int>): Int {
    val key = "$total:$i"
    if (memo.containsKey(key))
        return memo[key]?:0

    memo[key] = when {
        total == 0 -> return 1
        total < 0 -> return 0
        i >= arr.size -> return 0
        total < arr[i] -> dpMemoBottomUp (arr, total, i + 1, memo)
        else -> dpMemoBottomUp (arr, total - arr[i], i + 1, memo) + dpMemoBottomUp (arr, total, i + 1, memo)
    }
    return memo[key]?:0
}

fun dpMemoBottomUpList (arr : IntArray, total: Int, i: Int, memo: MutableMap<String, Boolean> = mutableMapOf(), list: ArrayList<Int> = arrayListOf(), ans: ArrayList<List<Int>>  = arrayListOf()) {
    val key = "$total:$i"
    if (memo.containsKey(key)) {
        return
    }
    when {
        total == 0 -> ans.add(ArrayList(list))
        total < 0 -> return
        i >= arr.size -> return
        total < arr[i] -> {
            memo[key] = true
            dpMemoBottomUpList (arr, total, i + 1, memo, list, ans)
        }
        else -> {
            list.add(arr[i])
            dpMemoBottomUpList (arr, total - arr[i], i + 1, memo, list, ans)
            list.remove(arr[i])
            dpMemoBottomUpList (arr, total, i + 1, memo, list, ans)
        }
    }
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

fun dpListRec(candidates: IntArray, total: Int, pointer: Int, list: MutableList<Int>, ans: MutableList<MutableList<Int>>, count: MutableMap<Int, Int>){
    when {
        total == 0 -> ans.add(ArrayList(list))
        total < 0 || pointer > candidates.size -1 -> return
        total < candidates[pointer] || count[candidates[pointer]]?:0 <= 0 -> {
            dpListRec (candidates, total, pointer + 1, list, ans, count)
        }
        else -> {
            list.add(candidates[pointer])
            count[candidates[pointer]] = count[candidates[pointer]]!!.minus(1)
            dpListRec (candidates, total - candidates[pointer], pointer, list, ans, count)
            count[candidates[pointer]] = count[candidates[pointer]]!!.plus(1)
            list.remove(candidates[pointer])
            dpListRec (candidates, total, pointer + 1, list, ans, count)
        }
    }
}
