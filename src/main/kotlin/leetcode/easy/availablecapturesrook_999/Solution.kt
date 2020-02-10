package leetcode.easy.availablecapturesrook_999

// https://leetcode.com/problems/available-captures-for-rook/
class Solution {
    fun numRookCaptures(board: Array<CharArray>): Int {
        val rook = board.getRookCoord()
        var count = 0
        for(i in rook.second until 8) {
            val char = board[rook.first][i]
            if(char.toLowerCase() == 'b') {
                break
            }
            if(char == 'p') {
                count++
                break
            }
        }
        for(i in (rook.second-1) downTo 0) {
            val char = board[rook.first][i]
            if(char.toLowerCase() == 'b') {
                break
            }
            if(char == 'p') {
                count++
                break
            }
        }
        for(i in rook.first until 8) {
            val char = board[i][rook.second]
            if(char.toLowerCase() == 'b') {
                break
            }
            if(char == 'p') {
                count++
                break
            }
        }
        for(i in (rook.first-1) downTo 0) {
            val char = board[i][rook.second]
            if(char.toLowerCase() == 'b') {
                break
            }
            if(char == 'p') {
                count++
                break
            }
        }

        return count
    }

    private fun Array<CharArray>.getRookCoord(): Pair<Int, Int> {
        var pair: Pair<Int, Int>? = null
        forEachIndexed loop@ { i, arr ->
            arr.forEachIndexed { j, piece ->
                if(piece == 'R') {
                    pair = Pair(i, j)
                    return@loop
                }
            }
        }
        return pair!!
    }
}

fun main() {
    Solution().numRookCaptures(arrayOf(
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','p','.','.','.','.'),
        charArrayOf('.','.','.','R','.','.','.','p'),
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','p','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.')
    )).also { println(it) }

    Solution().numRookCaptures(arrayOf(
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','p','.','.','.','.'),
        charArrayOf('.','.','.','B','.','.','.','p'),
        charArrayOf('.','p','B','R','B','p','.','.'),
        charArrayOf('.','.','.','B','.','.','.','.'),
        charArrayOf('.','.','.','p','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','.','.','.')
    )).also { println(it) }
}