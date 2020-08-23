package leetcode.medium.findkthbitinbinstring_1545

class Solution {
    /*
    STRING BUILDER IS FASTER THAN STRING CONCAT
     */
    fun findKthBit(n: Int, k: Int): Char {
        if(n == 1) return '0'
        var sb = StringBuilder("0")
        for(i in 1 .. n) {
            val inverted = sb.invert()
            sb.append('1').append(inverted)
        }
        return sb[k - 1]
    }

    private fun StringBuilder.invert(): String {
        var sb = StringBuilder()
        for(i in this.length - 1 downTo 0) {
            val char = this[i]
            if(char == '0') sb.append('1')
            else sb.append('0')
        }
        return sb.toString()
    }
}