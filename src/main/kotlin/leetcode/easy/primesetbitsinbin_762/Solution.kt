package leetcode.easy.primesetbitsinbin_762

// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/
class Solution {
    fun countPrimeSetBits(L: Int, R: Int): Int {
        var count = 0
        for(i in L..R) {
            if(Integer.toBinaryString(i).countSet().isPrime()) count++
        }
        return count
    }

    fun countPrimeSetBits2(L: Int, R: Int): Int {
        var count = 0
        for(i in L..R) {
            if(Integer.bitCount(i).isPrime()) count++
        }
        return count
    }

    private fun Int.isPrime(): Boolean {
        if(this <= 1) return false
        for(i in 2 until this) {
            if(this % i == 0) {
                return false
            }
        }
        return true
    }

    private fun String.countSet(): Int =
        fold(0) { acc, i ->
            if(i == '1') {
                acc + 1
            } else acc
        }
}

fun main() {
    Solution().countPrimeSetBits(6,10).also {
        println(it)
    }

    Solution().countPrimeSetBits(10,15).also {
        println(it)
    }


    Solution().countPrimeSetBits2(6,10).also {
        println(it)
    }

    Solution().countPrimeSetBits2(10,15).also {
        println(it)
    }
}