package leetcode.medium.maxxortwonum_421

class Solution {
    fun findMaximumXOR(nums: IntArray): Int {
        var max = 0
        for(i in 0 until nums.size - 1) {
            for(j in i + 1 until nums.size) {
                max = maxOf(max, nums[i] xor nums[j])
            }
        }
        return max
    }
}