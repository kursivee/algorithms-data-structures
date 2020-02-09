package leetcode.easy.minabsdiff_1200

// https://leetcode.com/problems/minimum-absolute-difference/
class Solution {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val list = mutableListOf<List<Int>>()
        var minDiff = Int.MAX_VALUE
        for(i in 0 until arr.size - 1) {
            val diff = Math.abs(arr[i+1] - arr[i])
            if(diff < minDiff) {
                minDiff = diff
                list.clear()
            }
            if(diff == minDiff) {
                list.add(listOf(arr[i], arr[i+1]))
            }
        }
        return list
    }
}

fun main() {
    Solution().minimumAbsDifference(intArrayOf(
        4,2,1,3
    )).also { println(it) }

    Solution().minimumAbsDifference(intArrayOf(
        1,3,6,10,15
    )).also { println(it) }

    Solution().minimumAbsDifference(intArrayOf(
        3,8,-10,23,19,-4,-14,27
    )).also { println(it) }
}