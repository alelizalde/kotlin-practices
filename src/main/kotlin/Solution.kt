
import java.util.Stack


fun main() {

    println(
        parseBoolExpr("&(t,f)")
    )
}

fun parseBoolExpr(expression: String): Boolean {
    val operands = Stack<Char>()
    val operators = Stack<Char>()
    for (ch in expression.toCharArray()) {
        if (ch == ',') {
            continue
        } else if (ch == '(' || ch == 't' || ch == 'f') {
            operands.push(ch)
        } else if (ch == ')') {
            //pop until open bracket
            var `val` = false
            val opr = operators.pop()
            var popped = ""
            while (!operands.isEmpty() && operands.peek() != '(') {
                popped += operands.pop()
            }
            `val` = eval(opr, popped)
            if (!operands.isEmpty())
                operands.pop()
            if (`val`)
                operands.push('t')
            else
                operands.push('f')
        } else if (ch == '&' || ch == '|' || ch == '!') {
            operators.push(ch)
        }
    }
    val res = operands.pop()
    return res == 't'
}

fun eval(opr: Char, popped: String): Boolean {
    var tcount = 0
    for (ch in popped.toCharArray()) {
        if (ch == 't')
            tcount++
        if (opr == '&' && ch == 'f')
            return false
        else if (opr == '!' && ch == 't')
            return false
        else if (opr == '!' && ch == 'f')
            return true
    }
    return tcount > 0
}