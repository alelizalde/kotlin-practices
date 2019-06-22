
fun threeSum(nums: IntArray): List<List<Int>> {
    val results : MutableList<MutableList<Int>> = mutableListOf()
    var i = 0
    nums.sort()
    while (i < nums.size - 2 && nums[i] <= 0) {
        var left = i + 1
        var right = nums.size - 1
        while (left < right) {

            when(nums[left] + nums[right] + nums[i]) {
                0 -> {
                    results.add(mutableListOf(nums[i], nums[left], nums[right]))
                    while (++left < right && nums[left] == nums[left - 1]) {}
                    while (left < --right && nums[right] == nums[right + 1]) {}
                }
                in 0..Integer.MAX_VALUE -> right--
                else -> left++
            }
        }
        while (++i < nums.size && nums[i] == nums[i - 1]) {}
    }
    return results
}

fun main() {
    println(threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)))
}