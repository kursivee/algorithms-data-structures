package leetcode.easy.movezeroes_283

// https://leetcode.com/problems/move-zeroes/
class Solution {
    fun moveZeroes(nums: IntArray): IntArray {
        for(i in nums.size - 1 downTo 0) {
            if(nums[i] == 0) {
                nums.shiftLeft(i)
            }
        }
        return nums
    }

    private fun IntArray.shiftLeft(startIndex: Int) {
        for(i in startIndex until size - 1) {
            this[i] = this[i + 1]
        }
        this[size - 1] = 0
    }
}

fun main() {
    Solution().moveZeroes(intArrayOf(
        0,1,0,3,12
    )).also {
        println(it.joinToString(", "))
    }
}