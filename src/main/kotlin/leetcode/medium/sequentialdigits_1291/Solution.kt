package leetcode.medium.sequentialdigits_1291

class Solution {
    fun sequentialDigits(low: Int, high: Int): List<Int> {
        val list = mutableListOf<Int>()
        var n = low
        while(true) {
            val seq = n.sequential()
            if(seq > high) break
            if(seq != - 1 && seq >= low) list.add(seq)
            if(seq == 123456789) break
            n = n.increment()
        }
        return list
    }

    private fun Int.sequential(): Int {
        val s = this.toString()
        if(s.length == 9) return 123456789
        var n = ""
        var i = Integer.parseInt(s[0].toString())
        repeat(s.length) {
            if(i > 9) return -1
            n += i++
        }
        return Integer.parseInt(n)
    }

    private fun Int.increment(): Int {
        val length = toString().length
        return this + (Math.pow(10.0, length.toDouble() - 1).toInt())
    }
}