package leetcode.easy.relativesortarray_1122

import java.util.*

// https://leetcode.com/problems/relative-sort-array/
class Solution {
    private val map: SortedMap<Int, Int> = sortedMapOf()

    fun relativeSortArray(arr1: IntArray, arr2: IntArray): IntArray {
        arr1.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        val list = mutableListOf<Int>()
        arr2.forEach {
            repeat(map[it]!!) { _ ->
                list.add(it)
            }
            map.remove(it)
        }
        map.forEach { entry ->
            repeat(map[entry.key]!!) {
                list.add(entry.key)
            }
        }
        return list.toIntArray()
    }
}

fun main() {
    Solution().relativeSortArray(intArrayOf(
        2,3,1,3,2,4,6,7,9,2,19
    ), intArrayOf(
        2,1,4,3,9,6
    )).also { println(it.joinToString(", ")) }
}