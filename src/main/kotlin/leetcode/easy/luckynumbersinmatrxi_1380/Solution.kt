package leetcode.easy.luckynumbersinmatrxi_1380

class Solution {
    fun luckyNumbers (matrix: Array<IntArray>): List<Int> {
        val list = mutableListOf<Int>()
        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                val n = matrix[i][j]
                if(matrix[i].min() == n && n == matrix.colMax(j)) {
                    list.add(n)
                }
            }
        }
        return list
    }

    private fun Array<IntArray>.colMax(j: Int): Int {
        var max = 0
        for(i in indices) {
            max = maxOf(this[i][j], max)
        }
        return max
    }
}