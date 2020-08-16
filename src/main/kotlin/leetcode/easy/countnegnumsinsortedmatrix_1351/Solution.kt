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

    fun countNegativesBin(grid: Array<IntArray>): Int {
        var count = 0
        for(i in grid.indices) {
            count += (grid[i].size - grid[i].indexOfNegative())
        }
        return count
    }

    private fun IntArray.indexOfNegative(): Int {
        var l = 0
        var r = this.size - 1
        while(l < r) {
            val mid = l + (r - l) / 2
            if(this[mid] < 0) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        if(this[l] >= 0) return this.size
        return l
    }
}