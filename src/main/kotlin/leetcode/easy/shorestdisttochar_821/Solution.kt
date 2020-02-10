package leetcode.easy.shorestdisttochar_821

// https://leetcode.com/problems/shortest-distance-to-a-character/
class Solution {
    fun shortestToChar(S: String, C: Char): IntArray {
        val arr = IntArray(S.length)
        val cIndexes = mutableListOf<Int>()
        S.forEachIndexed { index, c ->
            if(c == C) {
                cIndexes.add(index)
            }
        }
        S.forEachIndexed { index, c ->
            var minDist = S.length
            cIndexes.forEach {
                minDist = Math.min(minDist, Math.abs(it - index))
            }
            arr[index] = minDist
        }
        return arr
    }
}

fun main() {
    Solution().shortestToChar("loveleetcode", 'e').also {
        println(it.joinToString(", "))
    }
}