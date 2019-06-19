val storage = mutableListOf<Int>()


fun peek(): Int {
    return storage[0]
}

fun size(): Int {
    return storage.size
}

fun insert(value: Int) {
    storage.add(value)
    bubbleUp(size() - 1)
}

fun getParent(child: Int): Int {
    return if (child % 2 ==0){
        (child - 2) / 2
    } else {
        (child - 1) / 2
    }
}

fun bubbleUp(childToBubble: Int) {
    var parent = getParent(childToBubble)
    var child = childToBubble
    while (child > 0 && storage[child] < storage[parent]) {
        swap(child, parent)
        child = parent
        parent = getParent(child)
    }
}

fun getChild(parent: Int): Int {
    val child1 = 2 * parent + 1
    val child2 = 2 * parent + 2
    return if ( child1 >= size() ||
                child2 >= size() ||
                storage[child1] < storage[child2]) {
        child1
    } else {
        child2
    }
}

fun bubbleDown(parentToBubble: Int) {
    var parent = parentToBubble
    var child = getChild(parentToBubble)
    while(child < storage.size && storage[parent] > storage[child]) {
        swap(parent, child)
        parent = child
        child = getChild(parent)
    }
}

fun removePeak() {
    swap(0, size() - 1)
    storage.removeAt(storage.size - 1)
    bubbleDown(0)
}

fun swap(x: Int, y: Int) {
    val tmp = storage[x]
    storage[x] = storage[y]
    storage[y] = tmp
}

fun remove(value: Int): Int {
    var removeIndex = Integer.MIN_VALUE // Min valid represent invalid value on the tree
    for (i in 0 until storage.size) {
        if (storage[i] == value) {
            removeIndex = i
            break
        }
    }

    if (removeIndex  == Integer.MIN_VALUE){
        return Integer.MIN_VALUE
    }

    swap(removeIndex, size() -1)
    val result = storage.removeAt(storage.size - 1)
    bubbleUp(removeIndex)
    bubbleDown(removeIndex)
    return result

}

fun main() {
    insert(4)
    insert(5)
    insert(9)
    insert(6)
    insert(8)
    insert(7)
    insert(2)

    println(storage)
    //removePeak()
    remove(6)
    println(storage)
}

