package leetcode.easy.numbercomplement_476

// https://leetcode.com/problems/number-complement/
class Solution {
    fun findComplement(num: Int): Int {
        return Integer.parseInt(num.toBinaryComplement(), 2)
    }

    private fun Int.toBinaryComplement(): String {
        var x = this
        var s = ""
        while(x != 0) {
            s += if(x % 2 == 0) 1 else 0
            x /= 2
        }
        return s.reversed()
    }

    fun findComplement2(num: Int): Int =
        Integer.toBinaryString(num).toCharArray().map {
            if(it == '0') 1 else 0
        }.joinToString("").run {
            Integer.parseInt(this, 2)
        }
}

fun main() {
    Solution().findComplement(5).also {
        println(it)
    }

    Solution().findComplement2(5).also {
        println(it)
    }
}