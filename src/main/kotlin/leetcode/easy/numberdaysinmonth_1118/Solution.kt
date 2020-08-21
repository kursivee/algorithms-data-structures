package leetcode.easy.numberdaysinmonth_1118

class Solution {
    val months = mutableMapOf<Int, Int>(
        1 to 31,
        2 to 28,
        3 to 31,
        4 to 30,
        5 to 31,
        6 to 30,
        7 to 31,
        8 to 31,
        9 to 30,
        10 to 31,
        11 to 30,
        12 to 31
    )

    fun numberOfDays(Y: Int, M: Int): Int {
        var days = months[M]!!
        if(M == 2 && Y.isLeap()) {
            days = 29
        }
        return days
    }

    private fun Int.isLeap(): Boolean {
        if(this % 4 == 0 && this % 100 != 0) return true
        if(this % 400 == 0) return true
        return false
    }
}