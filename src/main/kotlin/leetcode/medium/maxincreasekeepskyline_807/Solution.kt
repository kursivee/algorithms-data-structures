package leetcode.medium.maxincreasekeepskyline_807

class Solution {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        val highestRows = grid.highestRows()
        val highestCols = grid.highestCols()
        var sum = 0
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                sum += Math.min(highestRows[i], highestCols[j]) - grid[i][j]
            }
        }
        return sum
    }

    fun Array<IntArray>.highestRows(): IntArray {
        val arr = IntArray(this[0].size)
        for(row in 0 until size) {
            for(col in this[0].indices) {
                if(this[row][col] > arr[row]) {
                    arr[row] = this[row][col]
                }
            }
        }
        return arr
    }

    fun Array<IntArray>.highestCols(): IntArray {
        val arr = IntArray(this.size)
        for(col in 0 until size) {
            for(row in indices) {
                if(this[row][col] > arr[col]) {
                    arr[col] = this[row][col]
                }
            }
        }
        return arr
    }
}

fun main() {
    Solution().maxIncreaseKeepingSkyline(arrayOf(
        intArrayOf(3,0,8,4),
        intArrayOf(2,4,5,7),
        intArrayOf(9,2,6,3),
        intArrayOf(0,3,1,0)
    )).also {
        println(it)
    }
}