package leetcode.easy.uniqueoccurrence_1207

// https://leetcode.com/problems/unique-number-of-occurrences/submissions/
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        arr.forEach {
            map[it] = map[it] ?: 0 + 1
        }
        val values = map.values.sorted()
        for(i in 0 until values.size - 1) {
            if(values[i] == values[i + 1]) return false
        }
        return true
    }
}

fun main() {
    Solution().uniqueOccurrences(intArrayOf(1,2,2,2,1,1,3)).also {
        println(it)
    }
}