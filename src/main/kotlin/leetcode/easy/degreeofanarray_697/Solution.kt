package leetcode.easy.degreeofanarray_697

class Solution {
    fun findShortestSubArray(nums: IntArray): Int {
        val freq = mutableMapOf<Int, Int>()
        nums.forEach { n ->
            val count = freq.getOrDefault(n, 0)
            freq[n] = count + 1
        }
        val max = freq.values.max()!!
        var minLength = Int.MAX_VALUE
        freq.forEach { (k, v) ->
            if(v == max) {
                val first = nums.indexOfFirst { it == k }
                val last = nums.indexOfLast { it == k }
                minLength = minOf(minLength, last - first + 1)
            }
        }
        return minLength
    }
}