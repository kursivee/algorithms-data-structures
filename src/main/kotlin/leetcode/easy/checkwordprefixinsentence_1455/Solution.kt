package leetcode.easy.checkwordprefixinsentence_1455

class Solution {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        val words = sentence.split(" ")
        words.forEachIndexed { index, word ->
            if(word.length != word.removePrefix(searchWord).length) return index + 1
        }
        return -1
    }
}