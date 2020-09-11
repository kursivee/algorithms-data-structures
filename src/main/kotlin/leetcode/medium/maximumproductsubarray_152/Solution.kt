package leetcode.medium.maximumproductsubarray_152

class Solution {
    fun maxProduct(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        var max = nums[0]
        for(i in nums.indices) {
            var product = nums[i]
            max = maxOf(max, product)
            for(j in i + 1 until nums.size) {
                product *= nums[j]
                max = maxOf(max, product)
            }
        }
        return max
    }
}