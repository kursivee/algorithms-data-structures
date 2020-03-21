package hackerrank.implementations.easy.gradingstudents

class Solution {
    fun solve(grades: IntArray): Array<Int> {
        return grades.map {
            val x = ((it / 5) + 1) * 5
            if(it < 38) {
                it
            } else if(x - it < 3) {
                x
            } else it
        }.toTypedArray()
    }
}

fun main() {
    Solution().solve(intArrayOf(
        73, 67, 38, 33
    )).also {
        println(it.joinToString(", "))
    }
}