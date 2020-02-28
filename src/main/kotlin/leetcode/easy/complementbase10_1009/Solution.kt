package leetcode.easy.complementbase10_1009

// https://leetcode.com/problems/complement-of-base-10-integer/
class Solution {
    fun bitwiseComplement2(N: Int): Int {
        val s = Integer.toBinaryString(N).map {
            if(it == '0') 1 else 0
        }.joinToString("")
        return Integer.parseInt(s, 2)
    }

    fun bitwiseComplement(N: Int): Int {
        return N xor ((1.shl(N.toString(2).length) - 1))
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