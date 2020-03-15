package leetcode.easy.nondecreasingarray_665

// https://leetcode.com/problems/non-decreasing-array/submissions/
class Solution {
    fun checkPossibility(nums: IntArray): Boolean {
        var count = 0
        for(i in 0 until nums.size - 1) {
            if(nums[i] > nums[i + 1]) {
                if(count++ == 1) return false
                if(i == 0 || nums[i - 1] < nums[i + 1]) {
                    nums[i] = nums[i + 1]
                } else {
                    nums[i + 1] = nums[i]
                }
            }
        }
        return true
    }
}

fun main() {
    Solution().checkPossibility(
        intArrayOf(
            3,4,2,3
        )
    ).also {
        println(it == false)
    }

    Solution().checkPossibility(
        intArrayOf(
            2,3,3,2,4
        )
    ).also {
        println(it == true)
    }

    Solution().checkPossibility(
        intArrayOf(
            4,2,3
        )
    ).also {
        println(it == true)
    }

    Solution().checkPossibility(
        intArrayOf(
            1,4,2,3
        )
    ).also {
        println(it == true)
    }

    Solution().checkPossibility(
        intArrayOf(
            4,2,1
        )
    ).also {
        println(it == false)
    }
}