package leetcode.easy.loggerratelimiter_359

class Solution {

    /** Initialize your data structure here. */
    /*
    Map it''ll hold the message and the time it was logged.
    check if the logged time is > 10
    if yes print or doesn't exist and then store in map
    else no

    happen synchronously, 1 that will have the same time will cancel the other
    */

    companion object {
        const val THRESHOLD = 10
    }

    private val map = mutableMapOf<String, Int>()

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        if(map.contains(message)) {
            if((timestamp - map[message]!!) >= THRESHOLD) {
                map[message] = timestamp
                return true
            } else {
                return false
            }
        }
        map[message] = timestamp
        return true
    }

}

/**
 * Your Logger object will be instantiated and called as such:
 * var obj = Logger()
 * var param_1 = obj.shouldPrintMessage(timestamp,message)
 */

fun main() {
    val solution = Solution()
    println(solution.shouldPrintMessage(1, "foo"))
    println(solution.shouldPrintMessage(2, "bar"))
    println(solution.shouldPrintMessage(3, "foo"))
}