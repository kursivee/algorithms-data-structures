package leetcode.easy.ranktransformofarray_1331

import java.util.*

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

    // Timeout was happening because my previous solution with sorted set
    // was iterating from 0..n to find the rank. Using binary search no longer causes
    // timeout
    fun arrayRankTransform2(arr: IntArray): IntArray {
        val rank = arr.toSortedSet().toList()
        for(i in arr.indices) {
            arr[i] = binSearch(arr[i], rank)
        }
        return arr
    }

    private fun binSearch(target: Int, list: List<Int>, start: Int = 0, end: Int = list.size - 1): Int {
        var s = start
        var e = end
        while(s <= e) {
            val index = (s + e)/2
            val i = list[index]
            if(target == i) return index + 1
            if(target > i) {
                s = index + 1
            } else {
                e = index - 1
            }
        }
        return -1
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

    println() 
    Solution().arrayRankTransform2(intArrayOf(
        40,10,20,30
    )).also {
        println(it.joinToString(", "))
    }

    Solution().arrayRankTransform2(intArrayOf(
        100,100,100
    )).also {
        println(it.joinToString(", "))
    }

    Solution().arrayRankTransform2(intArrayOf(
        37,12,28,9,100,56,80,5,12
    )).also {
        println(it.joinToString(", "))
    }
}