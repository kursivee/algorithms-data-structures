package leetcode.easy.islandperimeter_463

// https://leetcode.com/problems/island-perimeter/submissions/
class Solution {
    fun islandPerimeter(grid: Array<IntArray>): Int {
        var count = 0
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                if(grid[i][j] == 1) {
                    count += grid.getOnes(i,j)
                }
            }
        }
        return count
    }
    
    private fun Array<IntArray>.getOnes(i: Int, j: Int): Int {
        var count = 4
        kotlin.runCatching { if(get(i+1)[j] == 1) count-- }
        kotlin.runCatching { if(get(i)[j+1] == 1) count-- }
        kotlin.runCatching { if(get(i-1)[j] == 1) count-- }
        kotlin.runCatching { if(get(i)[j-1] == 1) count-- }
        return count
    }
}

fun main() {
    Solution().islandPerimeter(arrayOf(
        intArrayOf(0,1,0,0),
        intArrayOf(1,1,1,0),
        intArrayOf(0,1,0,0),
        intArrayOf(1,1,0,0)
    )).also {
        println(it)
    }
}