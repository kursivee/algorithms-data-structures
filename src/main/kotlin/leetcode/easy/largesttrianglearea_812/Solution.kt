package leetcode.easy.largesttrianglearea_812

// https://leetcode.com/problems/largest-triangle-area/
class Solution {
    fun largestTriangleArea(points: Array<IntArray>): Double {
        var max = -1.0
        for(i in 0 until points.size - 2) {
            for(j in (i + 1) until points.size - 1) {
                for(k in (j + 1) until points.size) {
                    max = Math.max(max, getArea(points[i], points[j], points[k]))
                }
            }
        }
        return max
    }

    // shoelace formula
    private fun getArea(a: IntArray, b: IntArray, c: IntArray): Double {
        val x = a[0] * b[1] + b[0] * c[1] + c[0] * a[1]
        val y = a[1] * b[0] + b[1] * c[0] + c[1] * a[0]
        return Math.abs(x - y) / 2.0
    }
}

fun main() {
    Solution().largestTriangleArea(
        arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, 2),
            intArrayOf(2, 0)
        )
    ).also {
        println(it)
    }

    Solution().largestTriangleArea(
        arrayOf(
            intArrayOf(2, 2),
            intArrayOf(0, 1),
            intArrayOf(1, 0),
            intArrayOf(0, 2),
            intArrayOf(2, 0)
        )
    ).also {
        println(it)
    }

    Solution().largestTriangleArea(
        arrayOf(
            intArrayOf(4,6),
            intArrayOf(6,5),
            intArrayOf(3, 1)
        )
    ).also {
        println(it)
    }
}