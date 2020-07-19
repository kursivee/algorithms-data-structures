package leetcode.medium.countnumberteams_1395

class Solution {
    fun numTeams(rating: IntArray): Int {
        var count = 0
        for(i in 0 until rating.size - 2) {
            for(j in i + 1 until rating.size - 1) {
                for(k in i + 2 until rating.size) {
                    val isIncreasing = (rating[i] < rating[j] && rating[j] < rating[k])
                    val isDecreasing = (rating[i] > rating[j] && rating[j] > rating[k])
                    if(
                        (isIncreasing || isDecreasing) &&
                        i < j &&  j < k
                    ) {
                        count++
                    }
                }
            }
        }
        return count
    }
}

fun main() {
    Solution().numTeams(intArrayOf(2,5,3,4,1)).also {
        println(it)
    }
}