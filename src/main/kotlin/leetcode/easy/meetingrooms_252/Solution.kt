package leetcode.easy.meetingrooms_252

class Solution {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        intervals.sortBy { it[0] }
        for(i in 1 until intervals.size) {
            if(intervals[i - 1][1] > intervals[i][0]) return false
        }
        return true
    }
}