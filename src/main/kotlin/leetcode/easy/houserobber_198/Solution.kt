package leetcode.easy.houserobber_198

class Solution {
    /*
    1,2,3,1
    1,2,4,3

    2,7,9,3,1
    2,7,11,10,12
    */
    fun rob(nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        val dp = IntArray(nums.size)
        for(i in nums.indices) {
            var max = nums[i]
            for(j in 0 until i - 1) {
                max = Math.max(max, dp[j] + nums[i])
            }
            dp[i] = max
        }
        return dp.max()!!
    }
}