
import java.util.TreeMap

internal class CalendarTwo() {
    private val deltas = TreeMap<Int, Int>()

    fun book(start: Int, end: Int): Boolean {
        deltas[start] = deltas.getOrPut(start){0} + 1
        deltas[end] = deltas.getOrPut(end){0} - 1

        var active = 0
        for(delta in deltas.values) {
            active+=delta
            if(active > 2) {
                deltas[start] = deltas[start]!! - 1
                deltas[end] = deltas[end]!! + 1
                if (deltas[start] == 0) deltas.remove(start)
                if (deltas[end] == 0) deltas.remove(end)
                return false
            }
        }

        return true
    }

}

fun main() {
    val cal = CalendarTwo()
    println(if(cal.book(10, 20)) "booked" else "not booked")
    println(if(cal.book(50, 60)) "booked" else "not booked")
    println(if(cal.book(10, 40)) "booked" else "not booked")
    println(if(cal.book(5, 15)) "booked" else "not booked")
    println(if(cal.book(5, 10)) "booked" else "not booked")
    println(if(cal.book(25, 55)) "booked" else "not booked")
}