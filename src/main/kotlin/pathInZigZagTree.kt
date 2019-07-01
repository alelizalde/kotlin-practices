
import kotlin.math.*



fun main() {
    //println(pathInZigZagTree(14))
    //println(pathInZigZagTreeBinaryLevel(26))
    //println(pathInZigZagTree4(14))
    println(pathInZigZagTree5(14))
}

fun pathInZigZagTreeBinaryLevel(label: Int): List<Int> {
    val ret = mutableListOf<Int>()
    var cur = label
    while(true){
        ret.add(0, cur)
        if (cur == 1) break
        cur /= 2
        var height = Integer.highestOneBit(cur)
        println("$cur, ${height-1}")
        cur = cur xor height - 1
    }
    return ret
}

fun pathInZigZagTree(label: Int): List<Int> {
    var start = 1
    var end = 0
    val ans = mutableListOf<Int>()
    var x = label
    while (end < label) {
        end += start
        start *= 2
    }
    start /= 2

    ans.add(0, x)
    while (x > 1) {
        x /= 2
        end -= start
        start /= 2
        x = end - (start - 1 - (end - x))
        ans.add(0, x)
    }

    return ans
}

fun pathInZigZagTree3(label: Int): List<Int> {
    var label = label
    var rows = -1
    var cur = label
    while (cur > 0) {
        cur -= 2.0.pow((++rows).toDouble()).toInt()
    }

    val res = mutableListOf<Int>()
    res.add(0, label)
    while (label > 1) {
        val lastStart = 2.0.pow((--rows).toDouble()).toInt()
        val lastLabel = lastStart * 3 - 1 - label / 2
        res.add(0, lastLabel)
        label = lastLabel
    }
    return res
}

fun pathInZigZagTree4(label: Int): List<Int> {
    var label = label
    val res = mutableListOf<Int>()
    while (label > 0) {
        res.add(0, label)
        label /= 2
    }
    //reverse(res.begin(), res.end())
    for (i in 0 until res.size)
        if (i > 0 && (i + res.size) % 2 == 0)
            res[i] = res[i] xor (1 shl i) - 1
    return res
}

fun pathInZigZagTree5(label: Int): List<Int> {
    var label = label
    val result = mutableListOf<Int>()
    result.add(0, label) //taking bottom up approach, so the label itself must be included
    var height = log2(label.toDouble()).toInt() //height of label from root

    while (height != 0) {
        val left = 2.00.pow(height - 1).toInt() // rank of left limit of the previous level
        val right = 2.00.pow(height).toInt() - 1// rank of right limit of the previous level
        label = left + (right - label / 2)// The previous level is sorted in different order than current one.
        //So the new label is adjusted accordingly
        result.add(0, label)  //newly found label is appened to result
        height--
    }

    return result
}