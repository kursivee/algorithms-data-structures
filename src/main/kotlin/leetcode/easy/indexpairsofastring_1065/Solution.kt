package leetcode.easy.indexpairsofastring_1065

class Solution {
    fun indexPairs(text: String, words: Array<String>): Array<IntArray> {
        val list = mutableListOf<IntArray>()
        for(i in text.indices) {
            var s = ""
            for(j in i until text.length) {
                s += text[j]
                if(words.contains(s)) {
                    list.add(intArrayOf(i,j))
                }
            }
        }
        return list.toTypedArray()
    }
}