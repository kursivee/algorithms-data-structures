package leetcode.easy.convertinttosum2int_1317

// https://leetcode.com/problems/convert-integer-to-the-sum-of-two-no-zero-integers/
class Solution {
    fun getNoZeroIntegers(n: Int): IntArray {
        var i = 1
        while((n - i).hasZero() || i.hasZero()) {
            i++
        }
        return intArrayOf(i, n - i)
    }

    private fun Int.hasZero(): Boolean {
        var num = this
        while(num != 0) {
            if(num % 10 == 0) return true
            num /= 10
        }
        return false
    }
}

fun main() {
    Solution().getNoZeroIntegers(2).also {
        println(it.joinToString(", "))
    }

    Solution().getNoZeroIntegers(4102).also {
        println(it.joinToString(", "))
    }

    Solution().getNoZeroIntegers(10300).also {
        println(it.joinToString(", "))
    }

    Solution().getNoZeroIntegers(69).also {
        println(it.joinToString(", "))
    }
}