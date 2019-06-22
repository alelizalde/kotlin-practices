
import java.util.*

fun minAreaRectV1(points: Array<IntArray>): Int {
    val rows: TreeMap<Int, MutableList<Int>> = TreeMap()
    for (point in points) {
        val x = point[0]
        val y = point[1]
        rows.computeIfAbsent(x) { ArrayList() }.add(y)
    }

    var ans = Integer.MAX_VALUE
    val lastx = mutableMapOf<Int, Int>()
    for (x in rows.keys) {
        val row = rows[x]
         row!!.sort()
        for (i in row.indices)
            for (j in i + 1 until row.size) {
                val y1 = row[i]
                val y2 = row[j]
                val code = 40001 * y1 + y2
                if (lastx.containsKey(code))
                    ans = Math.min(ans, (x - lastx[code]!!) * (y2 - y1))
                lastx[code] = x
            }
    }

    return if (ans < Integer.MAX_VALUE) ans else 0
}


fun main() {
    println(minAreaRectV1(
        arrayOf(intArrayOf(1, 1), intArrayOf(1, 3), intArrayOf(3, 1),
        intArrayOf(3, 3), intArrayOf(4, 1), intArrayOf(4, 3))
    ))
}