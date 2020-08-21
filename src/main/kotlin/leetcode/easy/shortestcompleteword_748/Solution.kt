package leetcode.easy.shortestcompleteword_748

class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val mapLp = mutableMapOf<Char, Int>()
        licensePlate.forEach { c ->
            if(c.isLetter()) {
                val count = mapLp.getOrDefault(c.toLowerCase(), 0)
                mapLp[c.toLowerCase()] = count + 1
            }
        }
        for(word in words.sortedBy { it.length }) {
            val mapWord = mutableMapOf<Char, Int>()
            word.forEach { c ->
                val count = mapWord.getOrDefault(c, 0)
                mapWord[c] = count + 1
            }
            var bool = true
            for((k, v) in mapLp.entries) {
                if(!mapWord.contains(k)) {
                    bool = false
                    break
                }
                if(mapWord[k]!! < v) {
                    bool = false
                    break
                }
            }
            if(bool) return word
        }
        return ""
    }
}