package leetcode.easy.sumdiginminnum_1085

class Solution {
    fun sumOfDigits(A: IntArray): Int {
        val min = A.min()
        var sum = 0
        val s = min.toString()
        s.forEach { c ->
            sum += Integer.parseInt(c.toString())
        }
        return if(sum % 2 == 0) 1 else 0
    }
}