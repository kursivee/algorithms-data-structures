package hackerrank.implementations.easy.appleandorange

class Solution {
    fun solve(s: Int, t: Int, a: Int, b: Int, apples: IntArray, oranges: IntArray) {
        var oCount = 0
        var aCount = 0
        apples.forEach {
            if(it + a in s..t) {
                aCount++
            }
        }
        oranges.forEach {
            if(it + b in s..t) {
                oCount++
            }
        }
        println(aCount)
        println(oCount)
    }
}

fun main() {
    Solution().solve(7, 11, 5, 15, intArrayOf(-2, 2, 1), intArrayOf(5, -6)).also {
        println(it)
    }
}