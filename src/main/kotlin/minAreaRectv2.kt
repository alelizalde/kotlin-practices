
import java.util.HashSet

fun minAreaRect(points: Array<IntArray>): Int {
    val pointSet = HashSet<Int>()
    for (point in points)
        pointSet.add(40001 * point[0] + point[1])

    var ans = Integer.MAX_VALUE
    for (i in points.indices)
        for (j in i + 1 until points.size) {
            if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) {
                if (pointSet.contains(40001 * points[i][0] + points[j][1]) && pointSet.contains(40001 * points[j][0] + points[i][1])) {
                    ans =
                        Math.min(ans, Math.abs(points[j][0] - points[i][0]) * Math.abs(points[j][1] - points[i][1]))
                }
            }
        }

    return if (ans < Integer.MAX_VALUE) ans else 0
}


fun main() {
    println(minAreaRect(
        //[[3,2],[3,1],[4,4],[1,1],[4,3],[0,3],[0,2],[4,0]]
        arrayOf(intArrayOf(3, 2), intArrayOf(3, 1), intArrayOf(4, 4),
            intArrayOf(1, 1), intArrayOf(4, 3), intArrayOf(0, 3),
        intArrayOf(0, 2), intArrayOf(4, 0))
    ))
}