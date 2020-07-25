package leetcode.medium.findminrotatedsortedarray_153

class Solution {
    fun findMin(nums: IntArray): Int {
        if(nums.size == 1) return nums[0]
        var l = 0
        var r = nums.size - 1
        while(l < r) {
            val mid = (l + r) / 2
            val x = nums[mid]
            if(x > nums[r]) {
                l = mid + 1
            } else {
                r = mid
            }
        }
        return nums[l]
    }
}

fun main() {
    Solution().findMin(intArrayOf(
        3,4,5,1,2
    )).also {
        println(it)
    }
}