package leetcode.medium.teemoattacking_495

class Solution {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        if(timeSeries.isEmpty()) return 0
        var time = 0
        for(i in 0 until timeSeries.size - 1) {
            time += minOf(timeSeries[i + 1] - timeSeries[i], duration)
        }
        time += duration
        return time
    }
}