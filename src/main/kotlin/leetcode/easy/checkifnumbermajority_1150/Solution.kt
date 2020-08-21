package leetcode.easy.checkifnumbermajority_1150

class Solution {
    fun isMajorityElement(nums: IntArray, target: Int): Boolean {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { n ->
            val count = freq.getOrDefault(n, 0)
            freq[n] = count + 1
        }
        return freq[target]?.let {
            it > nums.size / 2
        } ?: false
    }
}