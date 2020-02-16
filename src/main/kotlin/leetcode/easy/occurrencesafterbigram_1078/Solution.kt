package leetcode.easy.occurrencesafterbigram_1078

// https://leetcode.com/problems/occurrences-after-bigram/
class Solution {
    fun findOcurrences(text: String, first: String, second: String): Array<String> {
        val list = mutableListOf<String>()
        val split = text.split(" ")
        for(i in 0..split.size - 3) {
            if(split[i] == first) {
                if(split[i+1] == second) {
                    list.add(split[i+2])
                }
            }
        }
        return list.toTypedArray()
    }
}

fun main() {
    Solution().findOcurrences("alice is a good girl she is a good student", "a", "good").also {
        println(it.joinToString(", ") == "girl, student")
    }

    Solution().findOcurrences("alice is aa good girl she is a good student", "a", "good").also {
        println(it.joinToString(", ") == "student")
    }

    Solution().findOcurrences("we will we will rock you", "we", "will").also {
        println(it.joinToString(", ") == "we, rock")
    }
}