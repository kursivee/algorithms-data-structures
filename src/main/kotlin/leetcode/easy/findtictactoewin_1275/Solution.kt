package leetcode.easy.findtictactoewin_1275

class Solution {
    fun tictactoe(moves: Array<IntArray>): String {
        val arr = Array<CharArray>(3) {
            CharArray(3)
        }
        moves.forEachIndexed { index, move ->
            val player = if(index % 2 == 0) 'A' else 'B'
            arr[move[0]][move[1]] = player
        }
        val winner = arr.winner() ?: return if(moves.size < 9) "Pending"
        else "Draw"
        return winner.toString()
    }

    private fun Array<CharArray>.winner(): Char? {
        for(i in indices) {
            if((this[i][0] == 'A' || this[i][0] == 'B') && this[i][0] == this[i][1] && this[i][1] == this[i][2]) {
                return this[i][0]
            }
        }

        for(j in this[0].indices) {
            if((this[0][j] == 'A' || this[0][j] == 'B') && this[0][j] == this[1][j] && this[1][j] == this[2][j]) {
                return this[0][j]
            }
        }

        if((this[1][1] == 'A' || this[1][1] == 'B') && this[0][0] == this[1][1] && this[1][1] == this[2][2]) {
            return this[1][1]
        }

        if((this[1][1] == 'A' || this[1][1] == 'B') && this[0][2] == this[1][1] && this[1][1] == this[2][0]) {
            return this[1][1]
        }

        return null
    }
}