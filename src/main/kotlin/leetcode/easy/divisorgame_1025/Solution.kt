package leetcode.easy.divisorgame_1025

// https://leetcode.com/problems/divisor-game/
class Solution {
    fun divisorGame(N: Int): Boolean {
        if(N % 2 == 0) return true
        return !isPrime(N)
    }

    private fun isPrime(n: Int): Boolean {
        for(i in 2..n) {
            if((n.toDouble()/i.toDouble()) % 2 == 0.0) {
                return false
            }
        }
        return true
    }
}

fun main() {
    Solution().divisorGame(2).also { println(it) }
    Solution().divisorGame(3).also { println(it) }
    Solution().divisorGame(17).also { println(it) }
    Solution().divisorGame(100).also { println(it) }
}