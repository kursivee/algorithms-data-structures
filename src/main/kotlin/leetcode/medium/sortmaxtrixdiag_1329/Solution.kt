package leetcode.medium.sortmaxtrixdiag_1329

import java.util.*

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val map = mutableMapOf<Int, PriorityQueue<Int>>()
        for(i in mat.indices) {
            for(j in mat[i].indices) {
                val queue = map.getOrDefault(i - j, PriorityQueue())
                queue.add(mat[i][j])
                map[i - j] = queue
            }
        }

        for(i in mat.indices) {
            for(j in mat[i].indices) {
                mat[i][j] = map[i - j]!!.poll()
            }
        }
        return mat
    }
}

fun main() {
    Solution().diagonalSort(
        arrayOf(
            intArrayOf(3,3,1,1),
            intArrayOf(2,2,1,2),
            intArrayOf(1,1,1,2)
        )
    ).also {
        it.forEach {  arr ->
            println(arr.joinToString(", "))
        }
    }
}