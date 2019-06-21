class ZigZagText {
    fun convert(s: String, numRows: Int): String {
        val pos = mutableMapOf<Int, String>()
        var curr = 0
        var direction = 1
        for (c in s) {

            if (curr == 2) direction = -1 else if (curr == 0) direction = 1

            if (pos.contains(curr)) {
                pos.put(curr, pos[curr] + c)
            } else {
                pos.put(curr, c.toString())
            }

            curr += direction

        }

        val sb = StringBuilder()
        for (i in 0 until pos.size) {
            sb.append(pos[i])
        }

        return sb.toString()
    }

    fun main() {
        print(convert("PAYPALISHIRING", 3))
    }
}

/*
Create a hash map with positions
tranverse string and add positions incrementing or dicreasing acordantly to the direction

pos = mutableMap<Int, StringArray>()
curr = 0
for (c in s) {
    if(pos.contains(curr)) {
        pos.put(curr, pos.get(curr) + c)
    } else {
        pos.put(curr, c)
    }

    StringBuilder sb
    for i=0 to pos.size{
        sb.append(pos[i])
    }

    return sb
}
*/

