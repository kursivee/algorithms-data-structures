package leetcode.medium.twoclosestrings_1657

class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        if(word1.length != word2.length) return false
        val freq1 = word1.getFreq()
        val freq2 = word2.getFreq()
        if(freq1.keys.intersect(freq2.keys).size != freq1.keys.size) return false
        return freq1.values.sorted() == freq2.values.sorted()
    }

    fun String.getFreq(): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()
        forEach { c ->
            val count = map.getOrDefault(c, 0)
            map[c] = count + 1
        }
        return map
    }
}