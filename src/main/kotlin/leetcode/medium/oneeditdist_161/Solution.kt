package leetcode.medium.oneeditdist_161

class Solution {
    fun isOneEditDistance(s: String, t: String): Boolean {
        if(s.isEmpty() || t.isEmpty()) {
            return Math.abs(s.length - t.length) == 1
        }
        if(Math.abs(s.length - t.length) > 1) return false
        val longest = if(s.length >= t.length) s else t
        val shortest = if(s.length < t.length) s else t

        var diff = false
        var li = 0
        var si = 0
        while(li < longest.length && si < shortest.length) {
            if(longest[li] != shortest[si]) {
                if(diff) return false
                diff = true
                if(longest.length != shortest.length) si--
            }
            li++
            si++
        }
        return if(li == longest.length) {
            diff
        } else diff xor (li == si)
    }
}