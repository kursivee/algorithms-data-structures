package leetcode.easy.splitbalancedstring_1221

// https://leetcode.com/problems/split-a-string-in-balanced-strings/
class Solution {
    fun balancedStringSplit(s: String = "RLRRRLLRLL"): Int {
        var rCount = 0
        var lCount = 0
        var sum = 0
        s.forEach {
            if(it == 'R') {
                rCount++
            } else {
                lCount++
            }
            if(rCount == lCount) {
                sum++
                rCount = 0
                lCount = 0
            }
        }
        return sum
    }
}

fun main() {
    Solution().balancedStringSplit().also { println(it) }
}