fun main() {
    println(combinationSum3(3, 9))

}

fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val ans = mutableListOf<List<Int>>()
    combinationSum3(k, n, ArrayList(), ans, 1)
    return ans
}

fun combinationSum3(k: Int, target: Int, list: MutableList<Int>, ans: MutableList<List<Int>>, start: Int) {
    print("{$target, $start}")
    when {
        list.size == k && target == 0 -> ans.add(ArrayList(list))
        else -> {
            for (i in start..9) {
                if (i > target)
                    break
                list.add(i)
                combinationSum3(k, target - i, list, ans, i + 1)
                list.remove(i)
            }
        }
    }
}