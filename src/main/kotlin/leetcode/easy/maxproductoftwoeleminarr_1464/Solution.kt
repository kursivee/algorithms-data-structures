package leetcode.easy.maxproductoftwoeleminarr_1464

class Solution {

    // n
    fun maxProduct(nums: IntArray): Int {
        var max1 = 0
        var max2 = 0
        for(i in nums.indices) {
            if(nums[i] > max1) {
                max2 = max1
                max1 = nums[i]
            } else if(nums[i] > max2) {
                max2 = nums[i]
            }
        }
        return (max1 - 1) * (max2 - 1)
    }

    // nlogN
    fun maxProduct1(nums: IntArray): Int {
        nums.sort()
        return (nums[nums.size - 1] - 1) * (nums[nums.size - 2] - 1)
    }

    // n^2
    fun maxProduct2(nums: IntArray): Int {
        var max = 0
        for(i in 0 until nums.size - 1) {
            for(j in i + 1 until nums.size) {
                max = Math.max(max, (nums[i] - 1) * (nums[j] - 1))
            }
        }
        return max
    }
}