import kotlin.system.measureNanoTime

//Bubble Sort
fun bubble(arr: MutableList<Int>) {
    var swap = false
    var curr = 0
    var limit = arr.count() - 1
    while(true){
        if (arr[curr] > arr[curr + 1]){
            val sum = arr[curr] + arr[curr + 1]
            arr[curr] = sum - arr[curr]
            arr[curr + 1] = sum - arr[curr + 1]
            swap = true
        }

        curr++

        if(curr >= limit){
            if(!swap) break
            curr = 0
            swap = false
            limit--
        }
    }
}

//Selection Sort
fun selection(arr: MutableList<Int>) {
    var minPos = 0

    for (curr in 0 until arr.count()) {
        var min = Integer.MAX_VALUE
        for (i in curr + 1 until arr.count()) {
            if (arr[i] < min) {
                min = arr[i]
                minPos = i
            }
        }
        if( arr[curr] > min){
            val tmp = arr[curr]
            arr[curr] = min
            arr[minPos] = tmp
        }
    }
}

//Insertion Sort
fun insertion(items: MutableList<Int>):List<Int> {

    if (items.isEmpty() || items.count() < 2) {
        return items
    }

    for (curr in 1 until items.count()) {
        // println(items)
        val item = items[curr]
        var i = curr
        while (i>0 && item < items[i - 1]) {
            items[i] = items[i - 1]
            i--
        }
        items[i] = item
    }
    return items
}

//Merge Sort
fun merge(arr: MutableList<Int>): MutableList<Int> {
    if(arr.count() <= 1) return arr
    val middle = arr.count() / 2
    val left = arr.subList(0, middle)
    val right = arr.subList(middle, arr.count())
    return merge(merge(left), merge(right))

}

fun merge(left: MutableList<Int>, right: MutableList<Int>): MutableList<Int>  {
    var indexLeft = 0
    var indexRight = 0
    val newList : MutableList<Int> = mutableListOf()

    while (indexLeft < left.count() && indexRight < right.count()) {
        if (left[indexLeft] <= right[indexRight]) {
            newList.add(left[indexLeft])
            indexLeft++
        } else {
            newList.add(right[indexRight])
            indexRight++
        }
    }

    while (indexLeft < left.count()) {
        newList.add(left[indexLeft])
        indexLeft++
    }

    while (indexRight < right.count()) {
        newList.add(right[indexRight])
        indexRight++
    }

    return newList
}

//Quick Sort
fun quickSort(arr: MutableList<Int>, p: Int, r: Int) {
    if (p < r) {
        var q: Int = partition(arr, p, r)
        quickSort(arr, p, q - 1)
        quickSort(arr, q + 1, r)

    }
}

fun partition(arr: MutableList<Int>, p: Int, r: Int): Int {
    var x = arr[r]
    var i = p - 1
    for (j in p until r) {
        if (arr[j] <= x) {
            i++
            exchange(arr, i, j)
        }
    }
    exchange(arr, i + 1, r)
    return i + 1
}

fun exchange(arr: MutableList<Int>, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

//Heap Sort
var heapSize = 0

fun left(i: Int): Int {
    return 2 * i
}

fun right(i: Int): Int {
    return 2 * i + 1
}

fun swap(arr: MutableList<Int>, i: Int, j: Int) {
    var temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

fun maxHeapify(arr: MutableList<Int>, i: Int) {
    var l = left(i)
    var r = right(i)
    var largest: Int

    if ((l <= heapSize - 1) && (arr[l] > arr[i])) {
        largest = l
    } else
        largest = i

    if ((r <= heapSize - 1) && (arr[r] > arr[l])) {
        largest = r
    }

    if (largest != i) {
        swap(arr, i, largest)
        maxHeapify(arr, largest)
    }
}

fun buildMaxheap(arr: MutableList<Int>) {
    heapSize = arr.size
    for (i in heapSize / 2 downTo 0) {
        maxHeapify(arr, i)
    }
}

fun heapSort(arr: MutableList<Int>) {
    buildMaxheap(arr)
    for (i in arr.size - 1 downTo 1) {
        swap(arr, i, 0)
        heapSize--
        maxHeapify(arr, 0)

    }
}

fun main() {
    val bubbleArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    var time: Long
    time = measureNanoTime {
        bubble(bubbleArr)
    }
    println("Bubble sort $bubbleArr took $time")

    val selectionArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    time = measureNanoTime {
        selection(selectionArr)
    }
    println("Selection sort $selectionArr took $time")

    val insertionArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    time = measureNanoTime {
        insertion(insertionArr)
    }
    println("Insertion sort $insertionArr took $time")

    val quickArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    time = measureNanoTime {
        quickSort(quickArr, 0, quickArr.count() -1 )
    }
    println("Quick sort $quickArr took $time")

    val heapArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    time = measureNanoTime {
        heapSort(heapArr)
    }
    println("Heap sort $heapArr took $time")

    val mergeArr = mutableListOf(8, 3, 4, 6, 7, 1, 2, 5)
    var mergeRes = MutableList(0){0}
    time = measureNanoTime {
       mergeRes = merge(mergeArr)
    }
    println("Merge sort $mergeRes took $time")
}

