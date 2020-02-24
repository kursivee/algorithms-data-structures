package leetcode.easy.distributecandies_575

// https://leetcode.com/problems/distribute-candies/
class Solution {
    fun distributeCandies(candies: IntArray): Int {
        return Math.min(candies.toSet().size, candies.size / 2)
    }
}

fun main() {
    Solution().distributeCandies(intArrayOf(
        1,1,2,2,3,3
    )).also {
        println(it)
    }

    Solution().distributeCandies(intArrayOf(
        1,1,2,2,3,3,4,5,2,2,3,3,4,5
    )).also {
        println(it)
    }
}