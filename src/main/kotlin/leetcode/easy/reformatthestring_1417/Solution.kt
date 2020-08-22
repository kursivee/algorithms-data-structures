package leetcode.easy.reformatthestring_1417

class Solution {
    fun reformat(s: String): String {
        val digits = mutableListOf<Char>()
        val letters = mutableListOf<Char>()
        s.forEach { c ->
            if(c.isDigit()) digits.add(c)
            else letters.add(c)
        }
        if(Math.abs(digits.size - letters.size) > 1) return ""
        val large = if(digits.size >= letters.size) digits else letters
        val small = if(digits.size < letters.size) digits else letters
        var i = 0
        var s  = ""
        while(i < small.size) {
            s += "${large[i]}${small[i]}"
            i++
        }
        if(large.size != small.size) s += large[i]
        return s
    }
}