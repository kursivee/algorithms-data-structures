package leetcode.easy.lettercaseperm_784

// https://leetcode.com/problems/letter-case-permutation/
/**
 * OMG This one took me forever. Need more practice with recursion!
 */
class Solution {

    private val list = mutableListOf<String>()

    fun letterCasePermutation(S: String): List<String> {
        perm(S)
        return list
    }

    private fun perm(s: String, tickIndex: Int = 0) {
        if(s.length == tickIndex) {
            list.add(s)
            return
        }
        perm(s, tickIndex + 1)
        val newS = s.replaceAt(tickIndex)
        if(newS != s)
            perm(newS, tickIndex + 1)
    }

    private fun String.replaceAt(index: Int): String {
        val arr = toCharArray()
        val c = arr[index]
        arr[index] = if(c.isLetter()) {
            if(c.isUpperCase()) {
                c.toLowerCase()
            } else c.toUpperCase()
        } else c
        return arr.joinToString("")
    }
}

fun main() {
    Solution().letterCasePermutation("abgi").also {
        println(it)
    }

    Solution().letterCasePermutation("a1b2").also {
        println(it)
    }

    Solution().letterCasePermutation("3z4").also {
        println(it)
    }

    Solution().letterCasePermutation("12345").also {
        println(it)
    }
    Solution().letterCasePermutation("mQe").also {
        println(it)
    }
}