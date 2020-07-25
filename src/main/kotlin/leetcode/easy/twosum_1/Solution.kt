package leetcode.easy.twosum_1

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            val diff = target - nums[i]
            if(map.containsKey(diff)) {
                return intArrayOf(i, map[diff]!!)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf()
    }
}

fun main() {
    Solution().twoSum(
        intArrayOf(2,7,11, 55),
        9
    ).also {
        println(it.joinToString(", "))
    }
}