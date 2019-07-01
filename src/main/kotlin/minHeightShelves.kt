import kotlin.math.*

fun main() {

    println(
        Solution().minHeightShelves(
            arrayOf(
                intArrayOf(1, 1), intArrayOf(2, 3),
                intArrayOf(2, 3), intArrayOf(1, 1),
                intArrayOf(1, 1), intArrayOf(1, 1),
                intArrayOf(1, 2)
            )
            , 4)
    )
}

class Solution {
    fun minHeightShelves1(books: Array<IntArray>, shelf_width: Int): Int {
        val dp = IntArray(books.size + 1)

        dp[0] = 0
        for (i in 1..books.size) {
            var width = books[i - 1][0]
            var height = books[i - 1][1]
            dp[i] = dp[i - 1] + height
            var j = i - 1
            while (j > 0 && width + books[j - 1][0] <= shelf_width) {
                height = max(height, books[j - 1][1])
                width += books[j - 1][0]
                dp[i] = min(dp[i], dp[j - 1] + height)
                --j
            }
        }
        return dp[books.size]
    }


    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        val dp = IntArray(books.size + 1){Integer.MAX_VALUE}
        dp[0] = 0
        for (i in 0 until books.size) {
            var width = 0
            var height = 0;
            for (j in i until books.size) {
                width += books[j][0]
                height = max(height, books[j][1])
                if (width <= shelf_width)
                    dp[j + 1] = min(dp[j + 1], dp[i] + height)
            }
        }

        return dp[books.size];
    }
}