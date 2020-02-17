package leetcode.easy.dayofweek_1185

// https://leetcode.com/problems/day-of-the-week/
class Solution {
    private val baseYear = 1971

    fun dayOfTheWeek(day: Int, month: Int, year: Int): String {
        val daysAfter = yearToDays(year) + sumMonthToDays(month, isLeapYear(year)) + getDays(day)
        return daysAfterToDay(daysAfter % 7)
    }

    private fun daysAfterToDay(daysAfter: Int): String =
        when(daysAfter) {
            0 -> "Friday"
            1 -> "Saturday"
            2 -> "Sunday"
            3 -> "Monday"
            4 -> "Tuesday"
            5 -> "Wednesday"
            6 -> "Thursday"
            else -> ""
        }

    private fun getDays(day: Int): Int = day - 1

    private fun getLeapYearCount(year: Int): Int {
        return (baseYear..year).fold(0) { acc, i ->
            if(isLeapYear(i)) {
                acc + 1
            } else {
                acc
            }
        }
    }

    private fun isLeapYear(year: Int): Boolean {
        return if(year % 4 == 0) {
            if(year % 100 == 0) {
                year % 400 == 0
            } else {
                true
            }
        } else {
            false
        }
    }

    private fun yearToDays(year: Int): Int {
        if(year == baseYear) return 0
        val days = (year - baseYear) * 365
        return days + getLeapYearCount(year - 1)
    }

    private fun sumMonthToDays(month: Int, isLeap: Boolean): Int {
        if(month == 1) return 0
        return (1 until month).fold(0) { acc, i ->
            acc + monthToDays(i, isLeap)
        }
    }

    private fun monthToDays(month: Int, isLeap: Boolean): Int {
        return when(month) {
            1 -> 31
            2 -> if(isLeap) 29 else 28
            3 -> 31
            4 -> 30
            5 -> 31
            6 -> 30
            7 -> 31
            8 -> 31
            9 -> 30
            10 -> 31
            11 -> 30
            12 -> 31
            else -> -1
        }
    }
}

fun main() {
    Solution().dayOfTheWeek(31, 8, 2019).also {
        println(it == "Saturday")
    }

    Solution().dayOfTheWeek(18, 7, 1999).also {
        println(it == "Sunday")
    }

    Solution().dayOfTheWeek(15, 8, 1993).also {
        println(it == "Sunday")
    }
}