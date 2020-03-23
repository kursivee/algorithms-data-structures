package hackerrank.implementations.easy.kangaroo

class Solution {
    fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
        // x1 + v1j = x2 + v2j
        // (v1j - v2j) = x2 - x1
        val target = x2 - x1
        val v = v1 - v2
        return if(v > 0 && target > 0 && target % v == 0) "YES" else "NO"
    }
}

fun main() {
    Solution().kangaroo(5, 3, 0, 2).also {
        println(it)
    }

    Solution().kangaroo(0,3,4,2).also {
        println(it)
    }
}