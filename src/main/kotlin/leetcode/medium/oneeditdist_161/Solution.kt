package leetcode.medium.oneeditdist_161

class Solution {
    // Yes I am very aware of what this looks like...
    fun isOneEditDistance(s: String, t: String): Boolean {
        if(s.isEmpty() || t.isEmpty()) {
            return Math.abs(s.length - t.length) == 1
        }
        if(Math.abs(s.length - t.length) > 1) return false
        if(s.length == t.length) {
            var diff = false
            for(i in s.indices) {
                if(s[i] != t[i]) {
                    if(diff) return false
                    else diff = true
                }
            }
            return diff
        }
        if(s.length > t.length) {
            var diff = false
            var si = 0
            var ti = 0
            while(si < s.length) {
                try {
                    if(s[si] != t[ti]) {
                        if(diff) return false
                        diff = true
                        ti--
                    }
                    si++
                    ti++
                } catch(e: Exception) {
                    return diff xor (Math.abs(ti - si) == 0)
                }

            }
            return diff
        } else {
            var diff = false
            var si = 0
            var ti = 0
            while(ti < t.length) {
                try {
                    if(s[si] != t[ti]) {
                        if(diff) return false
                        diff = true
                        si--
                    }
                    si++
                    ti++
                } catch(e: Exception) {
                    return diff xor (Math.abs(ti - si) == 0)
                }
            }
            return diff
        }
    }
}