package leetcode.medium.majorityelementii_229

class Solution {
    // Boyer-Moore Voting Algorithm
    fun majorityElement(nums: IntArray): List<Int> {
        val limit = nums.size / 3
        var x: Int? = null
        var y: Int? = null
        var xCount = 0
        var yCount = 0

        for(n in nums) {
            when {
                x != null && x == n -> xCount++
                y != null && y == n -> yCount++
                xCount == 0 -> {
                    x = n
                    xCount++
                }
                yCount == 0 -> {
                    y = n
                    yCount++
                }
                else -> {
                    xCount--
                    yCount--
                }
            }
        }
        val list = mutableListOf<Int>()
        xCount = 0
        yCount = 0

        for(n in nums) {
            if(x != null && x == n) xCount++
            if(y != null && y == n) yCount++
        }
        if(xCount > limit) list.add(x!!)
        if(yCount > limit) list.add(y!!)
        return list
    }
}