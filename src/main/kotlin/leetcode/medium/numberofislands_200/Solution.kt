package leetcode.medium.numberofislands_200

class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var count = 0
        for(i in grid.indices) {
            for(j in grid[i].indices) {
                if(grid[i][j] == '1') {
                    count++
                    traverse(grid, i, j)
                }
            }
        }
        return count
    }

    fun traverse(grid: Array<CharArray>, i: Int, j: Int) {
        if(i < 0 || i >= grid.size || j < 0|| j >= grid[i].size || grid[i][j] != '1')
            return
        grid[i][j] = '2'

        traverse(grid, i + 1, j)
        traverse(grid, i - 1, j)
        traverse(grid, i, j + 1)
        traverse(grid, i, j - 1)
    }
}

fun main() {
    Solution().numIslands(arrayOf(
        charArrayOf('1', '1', '1', '1', '0'),
        charArrayOf('1', '1', '0', '1', '0'),
        charArrayOf('1', '1', '0', '0', '0'),
        charArrayOf('0', '0', '0', '0', '0')
    )).also {
        println(it)
    }
}