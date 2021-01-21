package leetcode.medium.mostcompetitive_1673

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val sub = mutableListOf<Int>()
        var currIndex = 0
        while(sub.size < k) {
            val min = nums.minIndex(currIndex, nums.size - (k - sub.size))
            currIndex = min.first + 1
            sub.add(min.second)
        }
        return sub.toIntArray()
    }

    private fun IntArray.minIndex(start: Int, end: Int): Pair<Int, Int> {
        var min = this[start]
        var minIndex = start
        for(i in start .. end) {
            if(min > this[i]) {
                min = this[i]
                minIndex = i
            }
        }
        return minIndex to min
    }
}