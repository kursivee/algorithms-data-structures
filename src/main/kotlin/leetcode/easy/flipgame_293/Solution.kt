package leetcode.easy.flipgame_293

class Solution {
    fun generatePossibleNextMoves(s: String): List<String> {
        val list = mutableListOf<String>()
        for(i in 0 until s.length - 1) {
            var z = s.toCharArray()
            if(z[i] == '+' && z[i + 1] == '+') {
                z[i] = '-'
                z[i + 1] = '-'
                list.add(z.joinToString(""))
            }
        }
        return list
    }
}