package leetcode.easy.playwithchips_1217

// https://leetcode.com/problems/play-with-chips/
class Solution {
    fun minCostToMoveChips(chips: IntArray): Int {
        var even = 0
        var odd = 0
        chips.forEach {
            if(it % 2 == 0) {
                even++
            } else odd++
        }
        return Math.min(even, odd)
    }
}

fun main() {
    Solution().minCostToMoveChips(intArrayOf(
        1,2,3
    )).also {
        println(it)
    }

    Solution().minCostToMoveChips(intArrayOf(
        1,2,3,3,2,9,8,1,24,23,24,24,24
    )).also {
        println(it)
    }

    Solution().minCostToMoveChips(intArrayOf(
        2,2,2,3,3
    )).also {
        println(it)
    }
}