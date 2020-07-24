package leetcode.medium.singlenumberIII_260

class Solution {
    fun singleNumber(nums: IntArray): IntArray {
        val sum = nums.fold(0) { acc, i ->
            acc xor i
        }
        val lowbit = sum and (-sum)
        val ans = IntArray(2)
        nums.forEach {
            if(lowbit and it == 0) {
                ans[0] = ans[0] xor it
            } else {
                ans[1] = ans[1] xor it
            }
        }
        return ans
    }
}

fun main() {
    Solution().singleNumber(intArrayOf(1,2,1,2,3,5))
        .also {
            println(it.joinToString(", "))
        }
}