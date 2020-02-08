package leetcode.easy.fibonacci_509

// https://leetcode.com/problems/fibonacci-number/
class Solution {
    fun fib(N: Int): Int {
        if(N == 1) return 1
        if(N == 0) return 0
        return fib(N - 1) + fib(N - 2)
    }
}

fun main() {
    Solution().fib(4).also { println(it) }
}