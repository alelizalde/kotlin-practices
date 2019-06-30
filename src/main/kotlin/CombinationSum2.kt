fun main() {
    println(combinationSum2(intArrayOf(3,1,3,5,1,1), 8))
    //println(combinationSum2(intArrayOf(2, 4, 6, 10, 2), 16))
    //println(combinationSum2(intArrayOf(10,1,2,7,6,1,5), 8))
}

fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    val map = mutableMapOf<Int, Int>()
    candidates.forEach { map[it] = (map[it]?:0) + 1 }
    combinationSum2(candidates.distinct().toIntArray(), target, map = map, ans = ans)
    return ans
}

fun combinationSum2(candidates: IntArray, target: Int, list: ArrayList<Int> = ArrayList(), map: MutableMap<Int, Int>,
                    ans: MutableList<List<Int>>, pointer: Int = 0) {

    when {
        pointer > candidates.size - 1 || target < 0 -> return
        map[candidates[pointer]]?:0 <= 0 -> {
            combinationSum2(candidates, target, list, map, ans, pointer + 1)
            return
        }
        target == candidates[pointer] -> {
            list.add(target)
            ans.add(ArrayList(list))
            list.remove(target)
        }
        else -> {
            list.add(candidates[pointer])
            map[candidates[pointer]] = map[candidates[pointer]]!!.minus(1)
            combinationSum2(candidates, target - candidates[pointer], list, map, ans, pointer)
            map[candidates[pointer]] = map[candidates[pointer]]!!.plus(1)
            list.remove(candidates[pointer])
        }
    }
    combinationSum2(candidates, target, list, map, ans, pointer + 1)
}