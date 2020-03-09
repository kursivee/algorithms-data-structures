package leetcode.easy.nthtribonaccinumber_1137

// https://leetcode.com/problems/n-th-tribonacci-number/
class Solution {
    private val cache: MutableMap<Int, Int> = mutableMapOf()

    fun tribonacci(n: Int): Int {
        if(n <= 0) return 0
        if(n == 1 || n == 2) return 1
        val a = cache[n - 1] ?: tribonacci(n - 1).also { cache[n - 1] = it }
        val b = cache[n - 2] ?: tribonacci(n - 2).also { cache[n - 2] = it }
        val c = cache[n - 3] ?: tribonacci(n - 3).also { cache[n - 3] = it }
        return a + b + c
    }
}

fun main() {
//    Solution().tribonacci(4).also {
//        println(it)
//    }
//
//    Solution().tribonacci(25).also {
//        println(it)
//    }

    for(i in 0..36) {
        Solution().tribonacci(i).also {
            println(it)
        }

    }
}