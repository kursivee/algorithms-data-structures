package leetcode.easy.baseballgame_682

import java.util.*

// https://leetcode.com/problems/baseball-game/
class Solution {
    fun calPoints(ops: Array<String>): Int {
        val scores = ArrayDeque<Int>()
        ops.forEach {
            when(it) {
                "D" -> {
                    scores.push(scores.peek() * 2)
                }
                "C" -> {
                    scores.pop()
                }
                "+" -> {
                    val x = scores.pop()
                    val y = scores.peek()
                    scores.push(x)
                    scores.push(x+y)
                }
                else -> {
                    scores.push(Integer.parseInt(it))
                }
            }
        }
        return scores.fold(0) { acc, i -> acc + i }
    }
}

fun main() {
    Solution().calPoints(arrayOf(
        "5","2","C","D","+"
    )).also {
        println(it)
    }

    Solution().calPoints(arrayOf(
        "5","-2","4","C","D","9","+","+"
    )).also {
        println(it)
    }
}