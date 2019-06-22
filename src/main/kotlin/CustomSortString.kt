
fun customSortString(S: String, T: String): String {
    val position = mutableMapOf<Char, Int>()
    val ans = StringBuilder()
    for (s in S) {
        position[s] = 0
    }

    val tmpStr = StringBuilder()
    for(t in T){
        if(position.contains(t)) {
            position[t] = position[t]?:0.plus(1)
        } else {
            tmpStr.append(t.toString())
        }
    }
    //print(position)
    for(s in S) {
        val count = position[s]?:0
        for(j in 0 until count) ans.append(s)
    }
    ans.append(tmpStr)

    return ans.toString()
}

fun main() {
    println(customSortString("gfdsa", "asdfghre"))
}
/*
loop though T
take current letter

pattern=cba
text=abcd

create a map of positions
if current is on map concatenate
else append to string
O(n)
O(t+p)

*/