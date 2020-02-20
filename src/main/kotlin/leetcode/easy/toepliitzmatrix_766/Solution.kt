package leetcode.easy.toepliitzmatrix_766

// https://leetcode.com/problems/toeplitz-matrix/
class Solution {
    fun isToeplitzMatrix(matrix: Array<IntArray>): Boolean {
        for(i in matrix[0].indices) {
            for(j in 1 until matrix.size) {
                if(j+i >= matrix[0].size) break
                if(matrix[j][j+i] != matrix[0][i]) {
                    return false
                }
            }
        }
        for(j in 1 until matrix.size) {
            for(i in 1 until matrix[0].size) {
                if(i+j >= matrix.size) break
                if(matrix[j+i][i] != matrix[j][0]) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    Solution().isToeplitzMatrix(arrayOf(
        intArrayOf(18),
        intArrayOf(66)
    )).also {
        println(it)
    }

    Solution().isToeplitzMatrix(arrayOf(
        intArrayOf(11, 74, 0, 93),
        intArrayOf(40, 11, 74, 7)
    )).also {
        println(it)
    }

    Solution().isToeplitzMatrix(arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 1)
    )).also {
        println(it)
    }

    Solution().isToeplitzMatrix(arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 1, 2, 3),
        intArrayOf(9, 5, 1, 2)
    )).also {
        println(it)
    }
}