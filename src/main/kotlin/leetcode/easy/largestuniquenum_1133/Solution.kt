package leetcode.easy.largestuniquenum_1133

class Solution {
    fun largestUniqueNumber(A: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        A.forEach { n ->
            val count = map.getOrDefault(n, 0)
            map[n] = count + 1
        }
        var max = -1
        map.forEach { (k, v) ->
            if(v == 1) {
                max = maxOf(max, k)
            }
        }
        return max
    }
}