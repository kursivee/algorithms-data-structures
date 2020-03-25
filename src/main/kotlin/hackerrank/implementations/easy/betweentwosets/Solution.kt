package hackerrank.implementations.easy.betweentwosets

class Solution {
    fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
        // Write your code here
        var count = 0
        for(i in 1..100) {
            var t = true
            a.forEach { aInt ->
                if(i % aInt != 0) t = false
            }
            b.forEach {
                if(it % i != 0) t = false
            }
            if(t) count++
        }
        return count
    }
}

fun main() {
    Solution().getTotalX(
        arrayOf(2,4),
        arrayOf(16,32,96)
    ).also {
        println(it)
    }
}