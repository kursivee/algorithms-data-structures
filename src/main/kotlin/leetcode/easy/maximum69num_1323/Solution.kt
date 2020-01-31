package leetcode.easy.maximum69num_1323

// https://leetcode.com/problems/maximum-69-number/
class Solution {
    fun maximum69Number (num: Int): Int {
        var locked = false
        return num.toString().map {
            if(!locked && it == '6') {
                locked = true
                '9'
            } else it
        }.joinToString("").toInt()
    }
}

fun main() {
    Solution().maximum69Number(9669).also { println(it) }
}
