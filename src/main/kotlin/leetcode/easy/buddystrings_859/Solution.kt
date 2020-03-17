package leetcode.easy.buddystrings_859

// https://leetcode.com/problems/buddy-strings/
class Solution {
    fun buddyStrings(A: String, B: String): Boolean {
        if(A.length != B.length) return false
        if(!A.hasAll(B)) return false
        val diff = A.diff(B)
        if(diff == 0) {
            val a = A.toSet().joinToString("")
            if(a.length != A.length) {
                return true
            }
            return false
        }
        if(diff == 2) {
            return true
        }
        return false
    }

    private fun String.diff(s: String): Int {
        var diff = 0
        for(i in this.indices) {
            if(this[i] != s[i]) diff++
        }
        return diff
    }

    private fun String.hasAll(s: String): Boolean {
        val a = mutableMapOf<Char, Int>()
        val b = mutableMapOf<Char, Int>()
        for(i in this.indices) {
            a[this[i]] = a.getOrDefault(this[i], 0) + 1
            b[s[i]] = b.getOrDefault(s[i], 0) + 1
        }
        return a.entries.containsAll(b.entries)
    }
}

fun main() {
    Solution().buddyStrings(
        "ab", "ba"
    ).also {
        println(it == true)
    }

    Solution().buddyStrings(
        "ab", "ab"
    ).also {
        println(it == false)
    }

    Solution().buddyStrings(
        "aab", "aab"
    ).also {
        println(it == true)
    }

    Solution().buddyStrings(
        "aaaaaaabc", "aaaaaaacb"
    ).also {
        println(it == true)
    }

    Solution().buddyStrings(
        "", "ba"
    ).also {
        println(it == false)
    }

    Solution().buddyStrings(
        "abcd", "badc"
    ).also {
        println(it == false)
    }
}