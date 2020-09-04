package leetcode.easy.dietplanperformance_1176

class Solution {
    fun dietPlanPerformance(calories: IntArray, k: Int, lower: Int, upper: Int): Int {
        var total = 0
        var i = 0
        var j = i + (k - 1)
        while(i < calories.size) {
            var sum = 0
            if(j - i + 1 != k) break
            for(a in i .. j) {
                sum += calories[a]
            }
            if(sum < lower) {
                total -= 1
            } else if(sum > upper) {
                total += 1
            }
            i++
            if(j != calories.size - 1) j++
        }
        return total
    }
}