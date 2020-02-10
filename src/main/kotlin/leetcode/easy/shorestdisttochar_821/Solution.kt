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

    fun shortestToChar2(S: String, C: Char): IntArray {
        val arr = IntArray(S.length)
        var cIndex = -1
        var currI = 0
        S.forEachIndexed { index, c ->
            if(c == C) {
                for(i in currI until index) {
                    arr[i] = if(cIndex == -1) {
                        Math.min(S.length, index - i)
                    } else {
                        Math.min(i - cIndex, index - i)
                    }
                }
                cIndex = index
                currI = index
            } else if(index == S.length - 1) {
                for(i in currI..index) {
                    arr[i] = if(cIndex == -1) {
                        Math.min(S.length, index - i)
                    } else {
                        i - cIndex
                    }
                }
            }
        }
        return arr
    }
}

fun main() {
    Solution().shortestToChar("aaea", 'e').also {
        println(it.joinToString(", "))
    }

    Solution().shortestToChar("loveleetcode", 'e').also {
        println(it.joinToString(", "))
    }

    Solution().shortestToChar2("aaea", 'e').also {
        println(it.joinToString(", "))
    }

    Solution().shortestToChar2("loveleetcode", 'e').also {
        println(it.joinToString(", "))
    }
}