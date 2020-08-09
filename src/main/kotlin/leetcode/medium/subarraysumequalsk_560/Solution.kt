package leetcode.medium.subarraysumequalsk_560

class Solution {
    /*
    Tag: Prefix Sum
    Intuition:
    Want to track the amount of subarrays where sum == k
    Can do that with a frequency map where current sum is the key
    need to track because of (sum - k) + k = sum
    if there exists sum previous sum that == sum - k, then current sum contains
    subarrays where the sum of the subarray == k
    */
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = mutableMapOf<Int, Int>()
        var count = 0
        var sum = 0
        for(n in nums) {
            sum += n
            if(sum == k) {
                count++
            }
            if(map.contains(sum - k)) {
                count += map[sum - k]!!
            }
            map[sum] = map.getOrDefault(sum , 0) + 1
        }
        return count
    }
}