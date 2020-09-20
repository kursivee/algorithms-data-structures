package leetcode.hard.uniquepathsiii_980

class Solution {
    private var count = 0
    private var maxSteps = 1
    private var start = 0 to 0

    fun uniquePathsIII(grid: Array<IntArray>): Int {
        grid.init()
        dfs(grid, start.first, start.second, 0)
        return count
    }

    private fun Array<IntArray>.init() {
        for(i in indices) {
            for(j in this[i].indices) {
                if(this[i][j] == 0) maxSteps++
                if(this[i][j] == 1) {
                    start = i to j
                }
            }
        }
    }

    private fun Array<IntArray>.isValid(i: Int, j: Int): Boolean {
        return when {
            i < 0 || i >= size -> false
            j < 0 || j >= this[i].size -> false
            this[i][j] == -1 -> false
            else -> true
        }
    }

    private fun dfs(grid: Array<IntArray>, i: Int, j: Int, totalSteps: Int) {
       if(!grid.isValid(i, j)) return
        if(grid[i][j] == 2) {
            if(totalSteps == maxSteps) count++
            return
        }
        grid[i][j] = -1
        val steps = totalSteps + 1
        dfs(grid, i + 1, j, steps)
        dfs(grid, i - 1, j, steps)
        dfs(grid, i, j + 1, steps)
        dfs(grid, i, j - 1, steps)
        grid[i][j] = 0
    }
}