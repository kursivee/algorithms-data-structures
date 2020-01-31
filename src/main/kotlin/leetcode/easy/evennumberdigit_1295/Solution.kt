package leetcode.easy.evennumberdigit_1295

// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
class Solution {
    fun findNumbers(nums: IntArray = intArrayOf(12,345,2,6,7896)): Int {
        var count = 0
        nums.forEach {
            if(it.toString().length % 2 == 0) {
                count++
            }
        }
        return count
    }
}

fun main() {
    Solution().findNumbers().also { println(it) }
}