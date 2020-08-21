package leetcode.easy.containsduplicate_217

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        nums.forEach { n ->
            if(set.contains(n)) return true
            set.add(n)
        }
        return false
    }
}