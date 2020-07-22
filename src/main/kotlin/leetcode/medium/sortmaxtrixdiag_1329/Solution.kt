package leetcode.medium.sortmaxtrixdiag_1329

class Solution {
    fun diagonalSort(mat: Array<IntArray>): Array<IntArray> {
        val map = mutableMapOf<Int, MutableList<Int>>()
        for(i in mat.indices) {
            for(j in mat[i].indices) {
                val list = map.getOrDefault(i - j, mutableListOf())
                list.add(mat[i][j])
                map[i - j] = list
            }
        }

        map.values.forEach { it.sort() }
        for(i in mat.indices) {
            for(j in mat[i].indices) {
                mat[i][j] = map[i - j]!!.removeAt(0)
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