package leetcode.easy.transposematrix_867

// https://leetcode.com/problems/transpose-matrix/
class Solution {
    fun transpose(A: Array<IntArray>): Array<IntArray> {
        if(A.isEmpty()) return emptyArray()
        val arr = Array(A[0].size) {
            IntArray(A.size)
        }
        for(i in A.indices) {
            for(j in A[0].indices) {
                arr[j][i] = A[i][j]
            }
        }
        return arr
    }
}

fun main() {
    Solution().transpose(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )).also {
        it.forEach { arr ->
            println(arr.joinToString(", "))
        }
    }

    Solution().transpose(arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )).also {
        it.forEach { arr ->
            println(arr.joinToString(", "))
        }
    }
}