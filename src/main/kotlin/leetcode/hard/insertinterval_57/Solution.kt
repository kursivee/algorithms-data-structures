package leetcode.hard.insertinterval_57

class Solution {
    /*
    Find the intervals that are in range of newInterval
    if 0 then determine whether the newInterval goes before/between/after
    if only 1 then determine whether the newInterval goes before/after/modify
    if two
        create a new min/max interval
        loop through the original arr from 0 .. newInterval
            add interval
        add new interval
        loop from newInterval + 1 .. end
            add interval
    */
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if(intervals.isEmpty()) return arrayOf(newInterval)
        val ans = mutableListOf<IntArray>()
        val targetIntervals = mutableMapOf<Int, IntArray>()
        for(i in intervals.indices) {
            val interval = intervals[i]
            if(
                interval.inRangeOf(newInterval[0]) ||
                interval.inRangeOf(newInterval[1]) ||
                newInterval.encompass(interval[0], interval[1])
            ) {
                targetIntervals[i] = interval
            }
        }
        if(targetIntervals.size == 0) {
            var found = false
            for(interval in intervals) {
                if(!found && newInterval[1] < interval[0]) {
                    ans.add(newInterval)
                    found = true
                }
                ans.add(interval)
            }
            if(!found) ans.add(newInterval)
        }
        if(targetIntervals.size == 1) {
            val modify = intervals[targetIntervals.keys.toList()[0]]
            modify[0] = minOf(newInterval[0], modify[0])
            modify[1] = maxOf(newInterval[1], modify[1])
            ans.addAll(intervals)
        }
        if(targetIntervals.size >= 2) {
            val keys = targetIntervals.keys.toList()
            val first = intervals[keys[0]]
            val second = intervals[keys[keys.size - 1]]
            newInterval[0] = minOf(first[0], newInterval[0])
            newInterval[1] = maxOf(second[1], newInterval[1])
            for(i in 0 until keys[0]) {
                ans.add(intervals[i])
            }
            ans.add(newInterval)
            for(i in keys[keys.size - 1] + 1 until intervals.size) {
                ans.add(intervals[i])
            }
        }
        return ans.toTypedArray()
    }

    private fun IntArray.encompass(i: Int, j: Int): Boolean {
        return this[0] < i && this[1] > j
    }

    private fun IntArray.inRangeOf(k: Int): Boolean {
        return this[0] <= k && this[1] >= k
    }
}