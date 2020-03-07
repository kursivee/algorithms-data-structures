package leetcode.easy.largestuncommonseq_521

import kotlin.math.max

// https://leetcode.com/problems/longest-uncommon-subsequence-i/
class Solution {
    fun findLUSlength2(a: String, b: String): Int {
        return when {
            a.length > b.length -> a.length
            a.length < b.length -> b.length
            a.contains(b) -> -1
            else -> a.length
        }
    }

    fun findLUSlength(a: String, b: String): Int {
        return if(a == b) -1 else Math.max(a.length, b.length)
    }
}

fun main() {
    Solution().findLUSlength("abac", "abcd").also {
        println(it)
    }
}