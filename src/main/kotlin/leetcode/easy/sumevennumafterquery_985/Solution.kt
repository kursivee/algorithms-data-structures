package leetcode.easy.sumevennumafterquery_985

// https://leetcode.com/problems/sum-of-even-numbers-after-queries/
class Solution {
    fun sumEvenAfterQueries(A: IntArray, queries: Array<IntArray>): IntArray {
        val arr = IntArray(queries.size)
        if(queries.isEmpty()) return A
        queries.forEachIndexed { i, a ->
            A[a[1]] += a[0]
            arr[i] = A.fold(0) { acc, v ->
                if(v % 2 == 0)
                    acc + v
                else acc
            }
        }
        return arr
    }
}

fun main() {
    Solution().sumEvenAfterQueries(
        intArrayOf(1,2,3,4),
        arrayOf(
            intArrayOf(1,0),
            intArrayOf(-3,1),
            intArrayOf(-4,0),
            intArrayOf(2,3)
        )
    ).also {
        println(it.joinToString(", "))
    }
}