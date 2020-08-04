package leetcode.easy.armstrongnumber_1134

class Solution {

    fun isArmstrong(N: Int): Boolean {
        val count = (Math.log10(N.toDouble()) + 1).toInt()
        var sum = 0
        var n = N
        for(i in 0 until count) {
            sum += Math.pow(n.toDouble() % 10, count.toDouble()).toInt()
            n /= 10
        }
        return sum == N
    }

    fun isArmstrongWithString(N: Int): Boolean {
        val n = N.toString()
        var sum = 0
        n.forEach { c ->
            val ans = Math.pow((c - '0').toDouble(), n.length.toDouble()).toInt()
            sum += ans
        }
        return sum == N
    }
}