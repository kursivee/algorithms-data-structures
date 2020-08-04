package leetcode.easy.numberstudentsdoinghw_1450

class Solution {

    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var count = 0
        for(i in endTime.indices) {
            if(queryTime <= endTime[i] && queryTime >= startTime[i]) {
                count++
            }
        }
        return count
    }

    fun busyStudent2pass(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var count = 0
        val list = mutableListOf<IntArray>()
        for(i in startTime.indices) {
            val arr = intArrayOf(startTime[i], endTime[i])
            list.add(arr)
        }

        list.forEach { arr ->
            if(queryTime >= arr[0] && queryTime <= arr[1]) {
                count++
            }
        }
        return count
    }
}