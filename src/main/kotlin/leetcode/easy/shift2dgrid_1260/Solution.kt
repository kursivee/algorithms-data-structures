package leetcode.easy.shift2dgrid_1260

// https://leetcode.com/problems/shift-2d-grid/
class Solution {
    fun shiftGrid(grid: Array<IntArray>, k: Int): List<List<Int>> {
        val res = MutableList(grid.size) {
            MutableList(grid[0].size) { -1 }
        }
        for(i in grid.indices) {
            for(j in grid[0].indices) {
                var x = (j + k) % grid[0].size
                var y = i
                val z = (j + k) / grid[0].size
                if(z >= 1) {
                    y = (i + z) % grid.size
                }
//                println("${grid[i][j]} ($i, $j) ($y, $x)")
                res[y][x] = grid[i][j]
            }
        }
        return res
    }
}

fun main() {
    Solution().shiftGrid(arrayOf(
        intArrayOf(1,2,3),
        intArrayOf(4,5,6),
        intArrayOf(7,8,9)
    ), 2).also {
        println(it.joinToString("\n"))
    }
    println()
    Solution().shiftGrid(arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(3),
        intArrayOf(4),
        intArrayOf(7),
        intArrayOf(6),
        intArrayOf(5)
    ), 2).also {
        println(it.joinToString("\n"))
    }
    println()
    Solution().shiftGrid(arrayOf(
        intArrayOf(3,8,1,9),
        intArrayOf(19,7,2,5),
        intArrayOf(4,6,11,10),
        intArrayOf(12,0,21,13)
    ), 4).also {
        println(it.joinToString("\n"))
    }
}