package leetcode.medium.partitionminnum_1689

class Solution {
    fun minPartitions(n: String): Int {
        var max = 0
        n.forEach { c ->
            max = maxOf(max, c - '0')
        }
        return max
    }
}