package leetcode.easy.maxconsecutiveones_485

// https://leetcode.com/problems/max-consecutive-ones/
class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var max = 0
        var count = 0
        nums.forEach {
            if(it == 1) {
                count++
            } else {
                max = Math.max(max, count)
                count = 0
            }
        }
        return Math.max(max, count)
    }
}

fun main() {
    Solution().findMaxConsecutiveOnes(
        intArrayOf(
            1,1,0,1,1,1
        )
    ).also {
        println(it)
    }


    Solution().findMaxConsecutiveOnes(
        intArrayOf(
            1,0,1,1,0,1
        )
    ).also {
        println(it)
    }
}