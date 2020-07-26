package leetcode.easy.adddigits_258

class Solution {

    val table = arrayOf(
        intArrayOf(0,1,2,3,4,5,6,7,8,9), // 0
        intArrayOf(1,2,3,4,5,6,7,8,9,1), // 1
        intArrayOf(2,3,4,5,6,7,8,9,1,2),
        intArrayOf(3,4,5,6,7,8,9,1,2,3),
        intArrayOf(4,5,6,7,8,9,1,2,3,4),
        intArrayOf(5,6,7,8,9,1,2,3,4,5),
        intArrayOf(6,7,8,9,1,2,3,4,5,6),
        intArrayOf(7,8,9,1,2,3,4,5,6,7),
        intArrayOf(8,9,1,2,3,4,5,6,7,8),
        intArrayOf(9,1,2,3,4,5,6,7,8,9)
    )

    fun addDigits(num: Int): Int {
        val arr = num.toString().toCharArray()
        var sum = arr[0] - '0'
        for(i in 1 until arr.size) {
            sum = table[arr[i] - '0'][sum]
        }
        return sum
    }
}

fun main() {
    Solution().addDigits(38).also {
        println(it)
    }
}