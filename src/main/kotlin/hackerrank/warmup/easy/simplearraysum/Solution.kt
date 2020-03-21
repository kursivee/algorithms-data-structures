package hackerrank.warmup.easy.simplearraysum

class Solution {
    fun sum(a: IntArray): Int {
        return a.reduce { acc, i -> acc + i }
    }
}

fun main() {
    Solution().sum(
        intArrayOf(
            1,2,3,4,10,11
        )
    ).also {
        println(it)
    }
}