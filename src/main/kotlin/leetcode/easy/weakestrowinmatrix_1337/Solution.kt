package leetcode.easy.weakestrowinmatrix_1337

// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
class Solution {

    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val ans = mutableListOf<Pair<Int, Int>>()
        mat.forEachIndexed { index, i ->
            ans.add(index to i.getStrength())
        }
        ans.sortBy {
            it.second
        }
        return ans.subList(0, k).map {
            it.first
        }.toIntArray()
    }

    fun IntArray.getStrength(): Int {
        var count = 0
        forEach {
            if(it == 1) count++
        }
        return count
    }
}

fun main() {
    Solution().kWeakestRows(arrayOf(
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 0),
        intArrayOf(1, 0, 0, 0, 0),
        intArrayOf(1, 1, 0, 0, 0),
        intArrayOf(1, 1, 1, 1, 1)
    ), 3).also { println(it.joinToString(", ")) }
}