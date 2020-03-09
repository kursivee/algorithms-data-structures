package leetcode.easy.largestperimetertriangle_976

// https://leetcode.com/problems/largest-perimeter-triangle/
class Solution {
    fun largestPerimeter(A: IntArray): Int {
        A.sort()
        for(i in A.size - 1 downTo 2) {
            val a = A[i]
            val b = A[i - 1]
            val c = A[i - 2]
            if(a + b > c && a + c > b && b + c > a) {
                return a + b + c
            }
        }
        return 0
    }
}

fun main() {
    Solution().largestPerimeter(
        intArrayOf(
            2,1,2
        )
    ).also {
        println(it)
    }

    Solution().largestPerimeter(
        intArrayOf(
            1,2,2,4,8,18
        )
    ).also {
        println(it)
    }

    Solution().largestPerimeter(
        intArrayOf(
            3,2,3,4
        )
    ).also {
        println(it)
    }

    Solution().largestPerimeter(
        intArrayOf(
            3,6,2,3
        )
    ).also {
        println(it)
    }
}