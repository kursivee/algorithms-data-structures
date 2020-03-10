package leetcode.easy.monotonicarray_896

// https://leetcode.com/problems/monotonic-array/
class Solution {
    fun isMonotonic(A: IntArray): Boolean {
        var prev = A[0]
        var isPos = false
        var isNeg = false
        for(i in 1 until A.size) {
            if(A[i] > prev) isPos = true
            if(A[i] < prev) isNeg = true
            prev = A[i]
            if(isPos && isNeg) {
                return false
            }
        }
        return true
    }
}

fun main() {
    Solution().isMonotonic(
        intArrayOf(
            1,2,2,3
        )
    ).also {
        println(it)
    }

    Solution().isMonotonic(
        intArrayOf(
            3,2,1
        )
    ).also {
        println(it)
    }

    Solution().isMonotonic(
        intArrayOf(
            1,3,2
        )
    ).also {
        println(it)
    }


    Solution().isMonotonic(
        intArrayOf(
            1,1,1,1,1
        )
    ).also {
        println(it)
    }
}