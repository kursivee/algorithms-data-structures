package hackerrank.implementations.easy.countingvalleys

import java.util.*

// https://www.hackerrank.com/challenges/counting-valleys/problem
fun main() {
    countingValleys(0, "UDDDUDUU").also {
        println(it)
    }

    countingValleys(0, "DDUUUUDD").also {
        println(it)
    }

    countingValleys(0, "DUDUDU").also {
        println(it)
    }
}

fun countingValleys(n: Int, s: String): Int {
    val stack = ArrayDeque<Char>()
    var count = 0
    s.forEach {
        if(stack.isEmpty()) {
            stack.push(it)
        } else {
            if(stack.peek() == it) {
                stack.push(it)
            } else {
                stack.pop()
                if(stack.isEmpty() && it == 'U') count++
            }
        }
    }
    return count
}