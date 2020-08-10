package leetcode.easy.issubsequence_392

class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        if(t.length < s.length) return false
        if(s.isEmpty()) return true
        var j = 0
        for(i in t.indices) {
            if(s[j] == t[i]) {
                j++
            }
            if(j == s.length) return true
        }
        return false
    }
}