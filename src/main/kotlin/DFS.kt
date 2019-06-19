//Node class is on BFS file

fun main() {
    var node0 = Node(0)
    var node1 = Node(1)
    var node2 = Node(2)
    var node3 = Node(3)
    var node4 = Node(4)
    node0.neighbors = mutableListOf(node1, node2)
    node1.neighbors = mutableListOf(node2, node4)
    node2.neighbors = mutableListOf(node3)
    node3.neighbors = mutableListOf(node4)
    node4.neighbors = mutableListOf()
    val visited = mutableListOf<Node>()

    val q = mutableListOf<Node>()
    q.add(node0)
    visited.add(node0)
    println("Mark as visited: ${node0.value}")
    while(q.isNotEmpty()) {
        val curr = q.removeAt(q.count() -1)
        println("current: ${curr.value}")
        for(v in curr.neighbors) {
            if(!visited.contains(v)){
                q.add(v)
                visited.add(v)
                println("Mark as visited: ${v.value}")
            }
        }
    }
}