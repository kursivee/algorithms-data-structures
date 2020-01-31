package leetcode.easy.cellsodvaluesmatrix_1252

// https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
class Solution {
    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val arr = Array(n) {
            IntArray(m) { 0 }
        }
        indices.forEach {
            arr.incRow(it[0])
            arr.incCol(it[1])
        }
        return arr.countOdds()
    }

    private fun Array<IntArray>.incRow(i: Int) {
        get(i).run {
            forEachIndexed { index, j ->
                set(index, j + 1)
            }
        }
    }

    private fun Array<IntArray>.incCol(i: Int) {
        forEach {
            it[i]++
        }
    }

    private fun Array<IntArray>.countOdds(): Int {
        var sum = 0
        forEach { arr ->
            arr.forEach {
                if(it % 2 != 0) { sum++ }
            }
        }
        return sum
    }

    private fun Array<IntArray>.d() {
        forEach {
            it.joinToString(", ").also { println(it) }
        }
    }
}

fun main() {
    Solution().oddCells(2, 3, arrayOf(intArrayOf(0,1), intArrayOf(1,1))).also { println(it) }
    Solution().oddCells(2, 2, arrayOf(intArrayOf(1,1), intArrayOf(0,0))).also { println(it) }
}