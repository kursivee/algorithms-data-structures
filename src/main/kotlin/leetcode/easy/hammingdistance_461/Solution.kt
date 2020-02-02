package leetcode.easy.hammingdistance_461

import kotlin.system.measureNanoTime
import kotlin.time.measureTime

// https://leetcode.com/problems/hamming-distance/
// Played around with caching but it didn't really do anything to improve performance
class Solution {
    private val ln = Math.log(2.0)

    fun hammingDistance(x: Int, y: Int): Int {
        return x.get1Bits().diff(y.get1Bits())
    }

    private fun List<Int>.diff(list: List<Int>): Int {
        var smaller = if (list.size <= size) {
            list
        } else this
        var bigger = if (list.size > size) {
            list
        } else this
        var count = bigger.size + smaller.size
        bigger.forEach {
            if (smaller.contains(it)) count -= 2
        }
        return count
    }

    private fun Int.get1Bits(): List<Int> {
        if (this == 0) return listOf()
        if (this == 1) return listOf(0)
        val list = mutableListOf<Int>()
        var x = this
        while (x > 1) {
            log2(x).also {
                x -= pow2N(it)
                list.add(it)
            }
        }
        if (this % 2 != 0) {
            list.add(0)
        }
        return list
    }

    private val cache = mutableMapOf(
        0 to 1
    )

    fun pow2N(exp: Int): Int =
        cache[exp] ?: run {
            var x = 2.0
            repeat(exp - 1) {
                cache[it + 1] = x.toInt()
                x *= 2
            }
            return x.toInt()
        }

    private fun log2(n: Int): Int = (Math.log(n.toDouble()) / ln).toInt()
}

fun main() {
    Solution().hammingDistance(19, 18).also { println(it == 1) }
    Solution().hammingDistance(1, 4).also { println(it == 2) }
}