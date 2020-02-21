package leetcode.easy.laststoneweight_1046

// https://leetcode.com/problems/last-stone-weight/
class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        for(i in stones.size - 1 downTo 1) {
            stones.sort()
            val x = stones[i]
            val y = stones [i-1]
            if(x != 0) {
                if(x == y) {
                    stones[i-1] = 0
                } else {
                    stones[i-1] = x-y
                }
            }
        }
        return stones[0]
    }
}

fun main() {
    Solution().lastStoneWeight(intArrayOf(
        1,1,2,4,7,8
    )).also {
        println(it)
    }
}