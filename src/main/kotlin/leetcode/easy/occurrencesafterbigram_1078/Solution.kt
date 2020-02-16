package leetcode.easy.occurrencesafterbigram_1078

// https://leetcode.com/problems/occurrences-after-bigram/
class Solution {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val arr = mutableListOf<String>()
        Regex("(?=((\\b$first $second)\\s\\w+))").findAll(text).also {
            it.forEach {
                arr.add(it.groupValues[1].replace("$first $second ", "").trim())
            }
        }
        return arr.toTypedArray()
    }
}

fun main() {
    Solution().findOcurrences("alice is a good girl she is a good student", "a", "good").also {
        println(it.joinToString(", "))
    }

    Solution().findOcurrences("alice is aa good girl she is a good student", "a", "good").also {
        println(it.joinToString(", "))
    }

    Solution().findOcurrences("we will we will rock you", "we", "will").also {
        println(it.joinToString(", "))
    }
}