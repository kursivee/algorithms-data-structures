package leetcode.easy.reformatdate_1507

class Solution {
    fun reformatDate(date: String): String {
        val map = mutableMapOf<String, String>(
            "Jan" to "01",
            "Feb" to "02",
            "Mar" to "03",
            "Apr" to "04",
            "May" to "05",
            "Jun" to "06",
            "Jul" to "07",
            "Aug" to "08",
            "Sep" to "09",
            "Oct" to "10",
            "Nov" to "11",
            "Dec" to "12"
        )
        val arr = date.split(" ")
        return "${arr[2]}-${map[arr[1]]}-${arr[0].asDD()}"
    }

    private fun String.asDD(): String {
        var s = "${this[0]}"
        if(this[1].isDigit()) {
            s += this[1]
        } else s = "0$s"
        return s
    }
}