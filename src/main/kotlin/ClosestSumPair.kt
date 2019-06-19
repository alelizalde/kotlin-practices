import java.util.Arrays



fun main(args: Array<String>) {
    // NOTE: You can use the following input values to test this function.
    val a1 = intArrayOf(-1, 3, 8, 2, 9, 5)
    val a2 = intArrayOf(4, 1, 2, 10, 5, 20)
    val aTarget = 24
    // closestSumPair(a1, a2, aTarget) should return {5, 20} or {3, 20}

    val b1 = intArrayOf(7, 4, 1, 10)
    val b2 = intArrayOf(4, 5, 8, 7)
    val bTarget = 13
    // closestSumPair(b1, b2, bTarget) should return {4, 8}, {7, 7}, {7, 5}, or {10, 4}

    val c1 = intArrayOf(6, 8, -1, -8, -3)
    val c2 = intArrayOf(4, -6, 2, 9, -3)
    val cTarget = 3
    // closestSumPair(c1, c2, cTarget) should return {-1, 4} or {6, -3}

    val d1 = intArrayOf(19, 14, 6, 11, -16, 14, -16, -9, 16, 13)
    val d2 = intArrayOf(13, 9, -15, -2, -18, 16, 17, 2, -11, -7)
    val dTarget = -15
    closestSumPair(d1, d2, dTarget).forEach { print("$it, ") } //should return {-16, 2}, {-9, -7}
}

// a1 and a2 are the given arrays, and target is the target sum.
// It should return an array of two numbers as the result,
// one from each array.
fun closestSumPair(a1: IntArray, a2: IntArray, target: Int): IntArray {
    val a1Sorted = Arrays.copyOf(a1, a1.size)
    Arrays.sort(a1Sorted)
    val a2Sorted = Arrays.copyOf(a2, a2.size)
    Arrays.sort(a2Sorted)

    var i = 0
    var j = a2Sorted.size - 1
    var smallestDiff = Math.abs(a1Sorted[0] + a2Sorted[0] - target)
    val closestPair = intArrayOf(a1Sorted[0], a2Sorted[0])

    while (i < a1Sorted.size && j >= 0) {
        val v1 = a1Sorted[i]
        val v2 = a2Sorted[j]
        val currentDiff = v1 + v2 - target
        if (Math.abs(currentDiff) < smallestDiff) {
            smallestDiff = Math.abs(currentDiff)
            closestPair[0] = v1
            closestPair[1] = v2
        }

        if (currentDiff == 0) {
            return closestPair
        } else if (currentDiff < 0) {
            i += 1
        } else {
            j -= 1
        }
    }

    return closestPair
}

