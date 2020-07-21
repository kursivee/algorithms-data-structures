package leetcode.medium.wordsearch_79

class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        for(i in board.indices) {
            for(j in board[i].indices) {
                if(board[i][j] == word[0] && dfs(board, word, i, j, 0)) {
                    return true
                }
            }
        }
        return false
    }

    fun dfs(board: Array<CharArray>, word: String, i: Int, j: Int, count: Int): Boolean {
        if(word.length == count) return true
        if(i < 0 || i >= board.size || j < 0 || j >= board[i].size) return false
        if(board[i][j] != word[count]) return false

        val temp = board[i][j]
        board[i][j] = ' '
        val found = dfs(board, word, i + 1, j, count + 1) ||
            dfs(board, word, i - 1, j, count + 1) ||
            dfs(board, word, i, j + 1, count + 1) ||
            dfs(board, word, i, j - 1, count + 1)
        board[i][j] = temp

        return found
    }
}

fun main() {
    Solution().exist(arrayOf(
        charArrayOf('a', 'b', 'c'),
        charArrayOf('a', 'b', 'c')
    ), "abc").also {
        println(it)
    }
}

