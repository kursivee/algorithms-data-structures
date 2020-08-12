package leetcode.easy.countnegnumsinsortedmatrix_1351

class Solution {
    fun countNegatives(grid: Array<IntArray>): Int {
        var count = 0
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                if(grid[i][j] < 0) count++
            }
        }
        return count
    }
}