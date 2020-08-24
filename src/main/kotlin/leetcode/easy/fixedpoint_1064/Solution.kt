package leetcode.easy.fixedpoint_1064

class Solution {
    fun fixedPoint(A: IntArray): Int {
        A.forEachIndexed { index, n ->
            if(index == n) return index
        }
        return -1
    }
}