package leetcode.easy.buddystrings_859

// https://leetcode.com/problems/buddy-strings/
class Solution {

    val a = IntArray(26)
    val b = IntArray(26)
    var hasDupe = false

    fun buddyStrings(A: String, B: String): Boolean {
        if(A.length != B.length) return false

        var diff = 0
        for(i in A.indices) {
            if(A[i] != B[i]) diff++
            val x = A[i] - 'a'
            val y = B[i] - 'a'
            a[x]++
            b[y]++
            hasDupe = a[x] > 1
        }
        for(i in a.indices) {
            if(a[i] != b[i]) return false
        }

        if(diff == 0) {
            return hasDupe
        }
        if(diff == 2) {
            return true
        }
        return false
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