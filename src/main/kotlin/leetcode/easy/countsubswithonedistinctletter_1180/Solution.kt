package leetcode.easy.countsubswithonedistinctletter_1180

class Solution {
    fun countLetters(S: String): Int {
        var s = ""
        var count = 0
        S.forEach { char ->
            if(s.isEmpty() || s[s.length - 1] == char) {
                s += char
            } else {
                count += (s.length * (s.length + 1) / 2)
                s = "$char"
            }
        }
        return count + (s.length * (s.length + 1) / 2)
    }
}