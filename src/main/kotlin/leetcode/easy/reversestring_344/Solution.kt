package leetcode.easy.reversestring_344

// https://leetcode.com/problems/reverse-string/
class Solution {
    fun reverseString(s: CharArray): Unit {
        val end = s.size - 1
        for(i in 0 until s.size/2) {
            val c = s[i]
            s[i] = s[end - i]
            s[end - i] = c
        }
        println(s.joinToString(""))
    }
}

fun main() {
    Solution().reverseString(charArrayOf(
        'h', 'e', 'l', 'l', 'o'
    ))

    Solution().reverseString(charArrayOf(
        'H','a','n','n','a','h'
    ))
}