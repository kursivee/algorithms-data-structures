package leetcode.easy.largestuncommonseq_521

// https://leetcode.com/problems/longest-uncommon-subsequence-i/
class Solution {
    fun findLUSlength(a: String, b: String): Int {
        return when {
            a.length > b.length -> a.length
            a.length < b.length -> b.length
            a.contains(b) -> -1
            else -> a.length
        }
    }
}

fun main() {
    Solution().findLUSlength("abac", "abcd").also {
        println(it)
    }
}