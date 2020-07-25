package leetcode.easy.countoddinrange_1523

class Solution {
    fun countOdds(low: Int, high: Int): Int {
        var oddCount = 0
        for(i in low..high) {
            if(i % 2 == 1) oddCount++
        }
        return oddCount
    }
}

fun main() {
    Solution().countOdds(3, 7).also {
        println(it)
    }
}