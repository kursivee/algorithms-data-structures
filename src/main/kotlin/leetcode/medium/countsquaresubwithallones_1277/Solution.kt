package leetcode.medium.countsquaresubwithallones_1277

class Solution {
    /*
    This guy is insane...
    https://leetcode.com/problems/count-square-submatrices-with-all-ones/discuss/643429/Python-DP-Solution-%2B-Thinking-Process-Diagrams-(O(mn)-runtime-O(1)-space)
     */
    fun countSquares(matrix: Array<IntArray>): Int {
        var count = 0
        for(i in matrix.indices) {
            for(j in matrix[0].indices) {
                val n = matrix[i][j]
                if(n == 1) {
                    if(i == 0 || j == 0) count++
                    else {
                        val min = minOf(matrix[i - 1][j - 1], matrix[i - 1][j], matrix[i][j -1])
                        matrix[i][j] += min
                        count += matrix[i][j]
                    }
                }
            }
        }
        return count
    }
}