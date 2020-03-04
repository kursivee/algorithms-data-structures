package leetcode.easy.faircandyswap_888

// https://leetcode.com/problems/fair-candy-swap/
class Solution {
    fun fairCandySwap(A: IntArray, B: IntArray): IntArray {
        val sumA = A.reduce { acc, i -> acc + i }
        val sumB = B.reduce { acc, i -> acc + i }
        var target = (sumA + sumB) / 2
        target -= sumA
        target *= -1
        for(i in A.indices) {
            for(j in B.indices) {
                if(A[i] - B[j] == target) {
                    return intArrayOf(A[i], B[j])
                }
            }
        }
        return intArrayOf()
    }
}

fun main() {
    Solution().fairCandySwap(intArrayOf(
        1,1
    ), intArrayOf(
        2,2
    )).also {
        println(it.joinToString(", "))
    }

    Solution().fairCandySwap(intArrayOf(
        2
    ), intArrayOf(
        1,3
    )).also {
        println(it.joinToString(", "))
    }

    Solution().fairCandySwap(intArrayOf(
        1,2,5
    ), intArrayOf(
        2,4
    )).also {
        println(it.joinToString(", "))
    }
}