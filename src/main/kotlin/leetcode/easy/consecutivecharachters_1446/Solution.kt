package leetcode.easy.consecutivecharachters_1446

class Solution {
    fun maxPower(s: String): Int {
        var max = 1
        var count = 0
        var prev = s[0]
        for(c in s) {
            if(c == prev) count++
            else {
                max = maxOf(max, count)
                prev = c
                count = 1
            }
        }
        max = maxOf(max, count)
        return max
    }
}