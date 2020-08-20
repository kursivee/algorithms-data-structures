package leetcode.easy.stringmatchinginarray_1408

class Solution {
    fun stringMatching(words: Array<String>): List<String> {
        val list = mutableSetOf<String>()
        for(i in words.indices) {
            for(j in i + 1 until words.size) {
                if(words[i].contains(words[j])) list.add(words[j])
                else if(words[j].contains(words[i])) list.add(words[i])
            }
        }
        return list.toList()
    }
}