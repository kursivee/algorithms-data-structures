package leetcode.easy.runningsum1darray_1480

class Solution {
    fun runningSum(nums: IntArray): IntArray {
        for(i in 1 until nums.size) {
            nums[i] = nums[i - 1] + nums[i]
        }
        return nums
    }
}

fun main() {
    val solution = Solution()
    solution.runningSum(intArrayOf(1,2,3,4)).also { arr ->
        println(arr.joinToString(", "))
    }
}