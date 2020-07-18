package leetcode.easy.smallerthancurrentnumber_1365

class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val counter = IntArray(nums.size)
        for(i in 0 until nums.size) {
            var count = 0
            for(j in 0 until nums.size) {
                if(nums[j] < nums[i]) count++
            }
            counter[i] = count
        }
        return counter
    }
}

fun main() {
    Solution().smallerNumbersThanCurrent(intArrayOf(8,1,2,2,3)).also {
        println(it.joinToString(", "))
    }
}