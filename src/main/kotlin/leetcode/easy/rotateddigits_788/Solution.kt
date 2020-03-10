package leetcode.easy.rotateddigits_788

// https://leetcode.com/problems/rotated-digits/
class Solution {
    fun rotatedDigits(N: Int): Int {
        var count = 0
        for(i in 1..N) {
            val s = i.toString()
            if((s.contains("2") || s.contains("5") || s.contains("6") || s.contains("9")) &&
                (!s.contains("7") && !s.contains("3") && !s.contains("4"))) {
                count++
            }
        }
        return count
    }
}

fun main() {
    Solution().rotatedDigits(10000).also {
        println(it)
    }
}