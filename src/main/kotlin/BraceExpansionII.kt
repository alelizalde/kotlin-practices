fun braceExpansionII(expression: String): List<String> {
    val ans : MutableList<String> = mutableListOf()
    val list : MutableList<String> = mutableListOf()
    var start = 0
    while (start < expression.length) {
        if (expression[start] == '{') {
            start++
            var tmp = ""
            while (expression[start] != '}') {
                if (expression[start] != '{')
                    if (expression[start] != ',') {
                        tmp += expression[start].toString()
                        print(tmp)
                    }
                start++
            }
            start++
            list.add(tmp)
        }
    }
    //print(list)
    return list
}

fun main() {
    println(braceExpansionII("{a,b}{c{d,e}}"))
}