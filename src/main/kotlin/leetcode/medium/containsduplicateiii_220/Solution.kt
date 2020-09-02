package leetcode.medium.containsduplicateiii_220

class Solution {
    fun containsNearbyAlmostDuplicate(nums: IntArray, k: Int, t: Int): Boolean {
        for(i in nums.indices) {
            for(j in i + 1 until nums.size) {
                if(Math.abs(i - j) <= k && Math.abs(nums[i].toLong() - nums[j].toLong()) <= t) {
                    return true
                }
            }
        }
        return false
    }
}