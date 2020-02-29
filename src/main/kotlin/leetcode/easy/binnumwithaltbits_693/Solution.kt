package leetcode.easy.binnumwithaltbits_693

// https://leetcode.com/problems/binary-number-with-alternating-bits/
class Solution {
    fun hasAlternatingBits(n: Int): Boolean {
        return n.toString(2).findAnyOf(listOf("11", "00")) == null
    }
}

fun main() {
    Solution().hasAlternatingBits(5).also {
        println(it)
    }

    Solution().hasAlternatingBits(7).also {
        println(it)
    }

    Solution().hasAlternatingBits(11).also {
        println(it)
    }

    Solution().hasAlternatingBits(10).also {
        println(it)
    }

    Solution().hasAlternatingBits(8).also {
        println(it)
    }
}