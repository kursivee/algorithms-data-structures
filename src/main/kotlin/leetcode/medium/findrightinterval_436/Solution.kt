package leetcode.medium.findrightinterval_436

class Solution {
    fun findRightInterval(intervals: Array<IntArray>): IntArray {
        if(intervals.size == 1) return intArrayOf(-1)
        val arr = IntArray(intervals.size)
        for(i in intervals.indices) {
            var min = Int.MAX_VALUE
            for(j in intervals.indices) {
                if(j == i) continue
                if(intervals[j][0] >= intervals[i][1]) {
                    if(min > intervals[j][0]) {
                        min = intervals[j][0]
                        arr[i] = j
                    }
                }
            }
            arr[i] = if(min == Int.MAX_VALUE) -1 else arr[i]
        }
        return arr
    }
}