package leetcode.medium.minsizesubsum_209

class Solution {
    /*
    Initial:
        [0]
    Add 1:
        [0]
        [0, 1]
    Add 3:
        [0]
        [0, 1]
        [0, 3], [0, 1, 3]
    Add 5:
        [0]
        [0, 1]
        [0, 3], [0, 1, 3]
        [0, 5], [0, 3, 5], [0, 1, 3, 5]

        target is 6

        [1,3,5]
        [1,4,9]
    */
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if(nums.isEmpty()) return 0
        val prefix = IntArray(nums.size)
        prefix[0] = nums[0]
        if(prefix[0] >= s) return 1
        var max = prefix[0]
        for(i in 1 until prefix.size) {
            if(nums[i] >= s) return 1
            prefix[i] = prefix[i - 1] + nums[i]
        }

        var min = Int.MAX_VALUE
        for(i in 1 until prefix.size) {
            if(prefix[i] >= s) {
                for(j in 0 .. i) {
                    if(i == j) min = minOf(min, i + 1)
                    else if(prefix[i] - prefix[j] >= s) {
                        min = minOf(min, i - j)
                    }
                }
            }
        }

        return if(min == Int.MAX_VALUE) 0 else min
    }
}