package leetcode.easy.uncommonwordsfromtwosent_884

// https://leetcode.com/problems/uncommon-words-from-two-sentences/
class Solution {
    fun uncommonFromSentences(A: String, B: String): Array<String> {
        val map = mutableMapOf<String, Int>()
        A.split(" ").forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        B.split(" ").forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.entries.filter {
            it.value == 1
        }.map {
            it.key.toString()
        }.toTypedArray()
    }
}

fun main() {
    Solution().uncommonFromSentences("this apple is sweet", "this apple is sour").also {
        println(it.joinToString(", "))
    }


    Solution().uncommonFromSentences("apple apple", "banana").also {
        println(it.joinToString(", "))
    }
}