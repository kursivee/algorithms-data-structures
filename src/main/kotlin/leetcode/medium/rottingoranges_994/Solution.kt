package leetcode.medium.rottingoranges_994

class Solution {
    /*
    one arr
    rot
        look at adjacent and change it to 2
        returns count of rotted

    if rotted == 0
        return validate

    validate checks if there are 1s

    */
    var total = 0
    fun orangesRotting(grid: Array<IntArray>): Int {
        bfs(grid)
        return if(grid.validate()) total else -1
    }

    fun bfs(grid: Array<IntArray>) {
        var count = 0
        grid.rotted().forEach { pair ->
            count += grid.rot(pair[0], pair[1])
        }
        if(count == 0)
            return
        total++
        orangesRotting(grid)
    }

    fun Array<IntArray>.validate(): Boolean {
        for(i in indices) {
            for(j in 0 until this[0].size) {
                if(this[i][j] == 1) return false
            }
        }
        return true
    }

    fun Array<IntArray>.rotted(): List<List<Int>> {
        val list = mutableListOf<List<Int>>()
        for(i in indices) {
            for(j in 0 until this[0].size) {
                if(this[i][j] == 2) {
                    list.add(listOf(i, j))
                }
            }
        }
        return list
    }

    fun Array<IntArray>.rot(i: Int, j: Int): Int {
        var rotCount = 0
        if(i < size - 1) {
            if(this[i + 1][j] == 1) {
                this[i + 1][j] = 2
                rotCount++
            }
        }
        if(i > 0) {
            if(this[i - 1][j] == 1) {
                this[i - 1][j] = 2
                rotCount++
            }
        }
        if(j < this[0].size - 1) {
            if(this[i][j + 1] == 1) {
                this[i][j + 1] = 2
                rotCount++
            }
        }
        if(j > 0) {
            if(this[i][j - 1] == 1) {
                this[i][j - 1] = 2
                rotCount++
            }
        }
        return rotCount
    }
}

fun main() {
    Solution().orangesRotting(
        arrayOf(
            intArrayOf(2,1,1),
            intArrayOf(1,1,0),
            intArrayOf(0,1,1)
        )
    ).also {
        println(it)
    }
}