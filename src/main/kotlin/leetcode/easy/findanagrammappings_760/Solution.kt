package leetcode.easy.findanagrammappings_760

class Solution {
    fun anagramMappings(A: IntArray, B: IntArray): IntArray {
        val ans = IntArray(A.size)
        for(i in A.indices) {
            ans[i] = B.indexOf(A[i])
        }
        return ans
    }
}