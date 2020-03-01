package leetcode.easy.comparestirngsfreqsmallchar_1170

// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/
class Solution {
    fun numSmallerByFrequency(queries: Array<String>, words: Array<String>): IntArray {
        val q = queries.map {
            it.frequency()
        }
        val w = words.map {
            it.frequency()
        }
        val ans = mutableListOf<Int>()
        q.forEach {  query ->
            var count = 0
            w.forEach {  word ->
                if(query < word) {
                    count++
                }
            }
            ans.add(count)
        }

        return ans.toIntArray()
    }

    private fun String.frequency(): Int {
        val map = mutableMapOf<Char, Int>()
        forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.entries.sortedBy {
            it.key
        }[0].value
    }
}

fun main() {
    Solution().numSmallerByFrequency(
        arrayOf("cbd"),
        arrayOf("zaaaz")
    ).also {
        println(it.joinToString(", "))
    }

    Solution().numSmallerByFrequency(
        arrayOf("bbb", "cc"),
        arrayOf("a","aa","aaa","aaaa")
    ).also {
        println(it.joinToString(", "))
    }
}