package leetcode.easy.avgexcludingminandmax_1491

class Solution {
    fun average(salary: IntArray): Double {
        salary.sort()
        var sum = 0
        var count = 0
        for(i in 1 until salary.size - 1) {
            sum += salary[i]
            count++
        }
        return sum.toDouble() / count
    }
}