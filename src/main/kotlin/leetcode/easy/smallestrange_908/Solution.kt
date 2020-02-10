package leetcode.easy.smallestrange_908

// https://leetcode.com/problems/smallest-range-i/
class Solution {
    fun smallestRangeI(A: IntArray, K: Int): Int {
        A.sort()
        val diff = A[A.size - 1] - A[0] - 2 * K
        return if (diff <= 0) 0 else diff
    }
}

fun main() {
    Solution().smallestRangeI(intArrayOf(
        1
    ), 0).also { println(it == 0) }

    Solution().smallestRangeI(intArrayOf(
        0, 10
    ), 2).also { println(it == 6) }

    Solution().smallestRangeI(intArrayOf(
        1, 3, 6
    ), 3).also { println(it == 0) }

    Solution().smallestRangeI(intArrayOf(
        2, 7, 2
    ), 1).also { println(it == 3) }

    Solution().smallestRangeI(intArrayOf(
        1, 7, 2
    ), 1).also { println(it == 4) }

    Solution().smallestRangeI(intArrayOf(
        4, 5, 3, 2, 5
    ), 1).also { println(it == 1) }

    Solution().smallestRangeI(intArrayOf(
        7, 8, 8
    ), 1).also { println(it == 0) }
}