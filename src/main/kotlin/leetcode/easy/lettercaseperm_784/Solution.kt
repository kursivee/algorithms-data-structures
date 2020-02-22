package leetcode.easy.lettercaseperm_784

// https://leetcode.com/problems/letter-case-permutation/
class Solution {

    private val list = mutableListOf<String>()

    fun letterCasePermutation(S: String): List<String> {
        perm(S)
        return list.toSet().toList()
    }

    private fun perm(s: String, tickIndex: Int = 0) {
        list.add(s)
        if(tickIndex + 1 != s.length)
            perm(s.replaceAt(tickIndex), tickIndex+1)
        else list.add(s.replaceAt(tickIndex))
        for(i in tickIndex + 1 until s.length) {
            val newS = s.replaceAt(i)
            perm(newS, i)
        }
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
    Solution().letterCasePermutation("abcdefgi").also {
        println(it.joinToString(", "))
        println(it.size)
    }

    Solution().letterCasePermutation("a1b2").also {
        println(it.joinToString(", "))
    }

    Solution().letterCasePermutation("3z4").also {
        println(it.joinToString(", "))
    }

    Solution().letterCasePermutation("12345").also {
        println(it.joinToString(", "))
    }
    Solution().letterCasePermutation("mQe").also {
        println(it)
    }
}