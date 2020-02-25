package leetcode.easy.eleappear25inarr_1287

// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
class Solution {
    fun findSpecialInteger(arr: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        arr.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.entries.reduce { acc, mutableEntry ->
            if(acc.value < mutableEntry.value)
                mutableEntry
            else
                acc
        }.key
    }
}

fun main() {
    Solution().findSpecialInteger(
        intArrayOf(1,2,2,6,6,6,6,7,10)
    ).also {
        println(it)
    }
}