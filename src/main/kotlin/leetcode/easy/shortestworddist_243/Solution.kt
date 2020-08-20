package leetcode.easy.shortestworddist_243

class Solution {
    fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
        var min = Int.MAX_VALUE
        for(i in words.indices) {
            if(words[i] == word1) {
                for(j in i + 1 until words.size) {
                    if(words[j] == word2) min = minOf(min, j - i)
                }
            } else if(words[i] == word2) {
                for(j in i + 1 until words.size) {
                    if(words[j] == word1) min = minOf(min, j - i)
                }
            }
        }
        return min
    }
}