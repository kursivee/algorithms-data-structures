package leetcode.easy.removepalindromicsubseq_1332

class Solution {
    fun removePalindromeSub(s: String): Int {
        if(s.isEmpty()) return 0
        var l = 0
        var r = s.length - 1
        while(l <= r) {
            if(s[l++] != s[r--]) return 2
        }
        return 1
    }
}