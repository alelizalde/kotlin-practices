
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.util.HashSet


fun nextClosestTime(time: String): String {
    var cur = 60 * Integer.parseInt(time.substring(0, 2))
    cur += Integer.parseInt(time.substring(3))
    val allowed = HashSet<Int>()
    for (c in time.toCharArray())
        if (c != ':') {
            allowed.add(c - '0')
        }
    val pos = mutableMapOf<Int, StringArray>()
    while (true) {
        var valid=true
        cur = (cur + 1) % (24 * 60)
        val digits = intArrayOf(cur / 60 / 10, cur / 60 % 10, cur % 60 / 10, cur % 60 % 10)
        digits.forEach { if (!allowed.contains(it)) valid=false }
        if (valid) return String.format("%02d:%02d", cur / 60, cur % 60)
    }
}

fun main() {
    println("Closest time: ${nextClosestTime("19:59")}")
}