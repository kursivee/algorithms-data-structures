package leetcode.medium.findklengthsubstringnorepeat_1100

class Solution {
    /*
    Tag: Sliding Window, Two Pointer
    
     */
    fun numKLenSubstrNoRepeats(S: String, K: Int): Int {
        if(S.length < K) return 0
        var i = 0
        var j = 0
        var count = 0
        var s = ""
        while(i != S.length) {
            if(j == S.length) break
            if(s.contains(S[j])) {
                i += s.indexOf(S[j]) + 1
                j = i
                s = ""
            }
            s += S[j]
            if(s.length == K) {
                i++
                j = i - 1
                s = ""
                count++
            }
            j++
        }
        return count
    }
}