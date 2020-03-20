package leetcode.easy.thirdmaxnumber_414

import java.util.*

// https://leetcode.com/problems/third-maximum-number/
class Solution {
    fun thirdMax2(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        var max0 = Integer.MIN_VALUE
        var max1 = Integer.MIN_VALUE
        var max2 = Integer.MIN_VALUE
        nums.forEach {
            map[it] = it
            when {
                it > max0 -> {
                    max2 = max1
                    max1 = max0
                    max0 = it
                }
                it > max1 && it != max0 -> {
                    max2 = max1
                    max1 = it
                }
                it > max2 && it != max1 && it != max0 -> {
                    max2 = it
                }
            }
        }
        return if (map.size < 3) max0 else max2
    }

    fun thirdMax(nums: IntArray): Int {
        val maxHeap = PriorityQueue(nums.size, compareByDescending<Int> { it })
        nums.toSet().forEach {
            maxHeap.add(it)
        }
        if(maxHeap.size < 3) {
            return maxHeap.poll()
        }
        maxHeap.poll()
        maxHeap.poll()
        return maxHeap.poll()
    }
}

fun main() {
    Solution().thirdMax(intArrayOf(
        2,2,3,1
    )).also {
        println(it)
    }

    println()
    Solution().thirdMax(intArrayOf(
        3,2,1
    )).also {
        println(it)
    }
    println()

    Solution().thirdMax(intArrayOf(
        1,1,2
    )).also {
        println(it)
    }
    println()

    Solution().thirdMax(intArrayOf(
        1,2,2,5,3,5
    )).also {
        println(it)
    }
}