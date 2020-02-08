package leetcode.easy.reversewordsinstring_557

// https://leetcode.com/problems/reverse-words-in-a-string-iii/
class Solution {
    fun reverseWords(s: String): String =
        s.split(" ").joinToString(" ") {
            it.reversed()
        }
}

fun main() {
    Solution().reverseWords("Let's take LeetCode contest").also { println(it) }
}