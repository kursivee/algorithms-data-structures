package leetcode.easy.complementbase10_1009

// https://leetcode.com/problems/complement-of-base-10-integer/
class Solution {
    fun bitwiseComplement(N: Int): Int {
        val s = Integer.toBinaryString(N).map {
            if(it == '0') 1 else 0
        }.joinToString("")
        return Integer.parseInt(s, 2)
    }
}

fun main() {
    Solution().bitwiseComplement(5).also {
        println(it)
    }
    Solution().bitwiseComplement(7).also {
        println(it)
    }
    Solution().bitwiseComplement(10).also {
        println(it)
    }
}