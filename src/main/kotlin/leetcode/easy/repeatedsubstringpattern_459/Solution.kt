package leetcode.easy.repeatedsubstringpattern_459

class Solution {
    fun repeatedSubstringPattern(s: String): Boolean {
        var l = 0
        while(l < s.length - 1) {
            var r = l + 1
            var i = 0
            while(r < s.length) {
                if(s[r] != s[i % (l + 1)]) break
                r++
                i++
            }
            if(r == s.length && i % (l + 1) == 0) return true
            l++
        }
        return false
    }
}