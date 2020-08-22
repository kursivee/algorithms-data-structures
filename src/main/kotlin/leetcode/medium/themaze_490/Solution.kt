package leetcode.medium.themaze_490

class Solution {
    private var found = false
    fun hasPath(maze: Array<IntArray>, start: IntArray, destination: IntArray): Boolean {
        traverse(maze, start[0], start[1], destination)
        return found
    }

    private fun traverse(maze: Array<IntArray>, i: Int, j: Int, destination: IntArray) {
        if(maze[i][j] == -1) return
        if(i == destination[0] && destination[1] == j) {
            found = true
            return
        }
        maze[i][j] = -1
        traverse(maze, i, maze.n(i, j), destination)
        traverse(maze, i, maze.s(i, j), destination)
        traverse(maze, maze.e(i, j), j, destination)
        traverse(maze, maze.w(i, j), j, destination)
    }

    private fun Array<IntArray>.n(i: Int, j: Int): Int {
        if(j == 0) return 0
        for(y in j - 1 downTo 0) {
            if(this[i][y] == 1) return y + 1
        }
        return 0
    }

    private fun Array<IntArray>.s(i: Int, j: Int): Int {
        val size = this[i].size
        if(j == size - 1) return size - 1
        for(y in j + 1 until size) {
            if(this[i][y] == 1) return y - 1
        }
        return size - 1
    }

    private fun Array<IntArray>.w(i: Int, j: Int): Int {
        if(i == 0) return 0
        for(x in i - 1 downTo 0) {
            if(this[x][j] == 1) return x + 1
        }
        return 0
    }

    private fun Array<IntArray>.e(i: Int, j: Int): Int {
        if(i == size - 1) return size - 1
        for(x in i + 1 until size) {
            if(this[x][j] == 1) return x - 1
        }
        return size - 1
    }
}