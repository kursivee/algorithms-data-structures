package leetcode.easy.minsubinnonincreaseorder_1403

class Solution {
    /*
    subsequence sum greater than the other subsequence
    */
    fun minSubsequence(nums: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        while(ans.sum() <= nums.sum()) {
            val max = nums.max() ?: 0
            ans.add(max)
            nums[nums.indexOf(max)] = 0
        }
        return ans
    }
}