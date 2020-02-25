package leetcode.easy.ranktransformofarray_1331

// https://leetcode.com/problems/rank-transform-of-an-array/
class Solution {

    // Had to do weird map stuff cause timeout if I used sorted set
    fun arrayRankTransform(arr: IntArray): IntArray {
        if(arr.isEmpty()) return arr
        val map = mutableMapOf<Int, Int>()
        val a1 = arr.clone()
        a1.sort()
        var prev = a1[0]
        var prevRank = 1
        map[prev] = prevRank
        for(i in 1 until a1.size) {
            if(a1[i] != prev) {
                map[a1[i]] = ++prevRank
                prev = a1[i]
            }
        }
        for(i in arr.indices) {
            arr[i] = map[arr[i]]!!
        }
        return arr
    }
}

fun main() {
    Solution().arrayRankTransform(intArrayOf(
        40,10,20,30
    )).also {
        println(it.joinToString(", "))
    }

    Solution().arrayRankTransform(intArrayOf(
        100,100,100
    )).also {
        println(it.joinToString(", "))
    }

    Solution().arrayRankTransform(intArrayOf(
        37,12,28,9,100,56,80,5,12
    )).also {
        println(it.joinToString(", "))
    }
}