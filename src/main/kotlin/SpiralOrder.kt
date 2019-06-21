fun main() {
    val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    spiralOrder(matrix).forEach {print(" $it")}
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if(matrix.isEmpty()) return listOf()
    var limitTop = 0
    var limitDown = matrix.size - 1
    var limitRight = matrix[0].size - 1
    var limitLeft = 0
    var i=0
    var j=0
    var rowDir=1
    var colDir=1
    var moving = 'c' //c or r
    val ans = mutableListOf<Int>()
    while(limitLeft < limitRight && limitTop <= limitDown) {
        if (j > limitRight) {
            colDir = -1
            limitTop++
            i += rowDir
            j--
            moving = 'r'
        } else if (j < limitLeft) {
            colDir = 1
            i += rowDir
            j++
            limitDown--
            moving = 'r'
        }
        if (i > limitDown) {
            rowDir = - 1
            limitRight--
            i--
            j += colDir
            moving = 'c'
        } else if (i < limitTop) {
            rowDir = 1
            limitLeft++
            i++
            j+=colDir
            moving = 'c'
        }
        //print(" ${matrix[i][j]}, ")
        ans.add(matrix[i][j])
        if (moving == 'c') j+=colDir else i+=rowDir
    }


    return ans
}