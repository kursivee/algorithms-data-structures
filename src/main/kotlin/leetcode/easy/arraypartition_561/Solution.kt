package leetcode.easy.arraypartition_561

// https://leetcode.com/problems/array-partition-i/
class Solution {
    fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0
        for(i in nums.indices step 2) {
            sum += nums[i]
        }
        return sum
    }
}

fun main() {
    Solution().arrayPairSum(intArrayOf(1,4,3,2)).also { println(it) }
}
