package leetcode.easy.excelsheetcolnum_171

class Solution {
    /*
    Intuition:
    Rotating increment
    Sum = (26^(k - 1 - i) * c1) + ... + (26^(0) * ck)
    where k is the length of the string
    where i is the index 
     */
    fun titleToNumber(s: String): Int {
        var sum = 0.0
        var j = 0
        for(i in s.length - 1 downTo 0) {
            sum += Math.pow(26.0, i.toDouble()) * (s[j++] - 'A' + 1)
        }
        return sum.toInt()
    }
}