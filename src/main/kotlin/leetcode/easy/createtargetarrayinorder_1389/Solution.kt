package leetcode.easy.createtargetarrayinorder_1389

class Solution {
    fun createTargetArray(nums: IntArray, index: IntArray): IntArray {
        val ans = IntArray(nums.size) { -1 }
        for(i in 0 until nums.size) {
            val trueIndex = index[i]
            val target = ans[trueIndex]
            if(target == -1) {
                ans[trueIndex] = nums[i]
            } else {
                for(j in nums.size - 1 downTo trueIndex + 1) {
                    ans[j] = ans[j-1]
                }
                ans[trueIndex] = nums[i]
            }
        }
        return ans
    }
}

fun main() {
    Solution().createTargetArray(intArrayOf(0,1,2,3,4), intArrayOf(0,1,2,2,1))
        .also {
            println(it.joinToString(", "))
        }
}