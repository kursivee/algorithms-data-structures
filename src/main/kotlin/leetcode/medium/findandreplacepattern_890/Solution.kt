package leetcode.medium.findandreplacepattern_890

class Solution {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val list = words.map { s ->
            s.mask()
        }
        val ans = mutableListOf<String>()
        val maskedPattern = pattern.mask()
        list.forEachIndexed { index, s ->
            if(s == maskedPattern) {
                ans.add(words[index])
            }
        }
        return ans
    }

    private fun String.mask(): String {
        val charArray = IntArray(123) { -1 }
        var s = ""
        for(i in 0 until length) {
            val c = this[i]
            if(charArray[c.toInt()] == -1) {
                charArray[c.toInt()] = i
            }
            s += charArray[c.toInt()]
        }
        return s
    }
}